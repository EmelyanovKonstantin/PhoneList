package ru.emelyanovkonstantin;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import ru.emelyanovkonstantin.dto.Country;
import ru.emelyanovkonstantin.dto.FreeCountryList;
import ru.emelyanovkonstantin.dto.FreePhoneList;
import ru.emelyanovkonstantin.dto.NumberInfo;
import ru.emelyanovkonstantin.service.QueryServiceImpl;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

/**
 * @author Emelyanov Konstantin
 * @version 1.0.0
 */
public class Main {

    public static void main(String[] args) {
        try {
            QueryServiceImpl queryService = new QueryServiceImpl();
            StringBuilder freeCountryListJson = queryService.query("https://onlinesim.ru/api/getFreeCountryList");

            ObjectMapper objectMapper = new ObjectMapper();
            objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);

            FreeCountryList freeCountryList = objectMapper.readValue(freeCountryListJson.toString(),FreeCountryList.class);
            ArrayList<Country> countriesList = freeCountryList.countries;

            List<NumberInfo> numberInfoList = countriesList.stream().map(country -> {
                StringBuilder freePhoneListJson = queryService.query("https://onlinesim.ru/api/getFreePhoneList?country=" + country.country);
                try {
                    FreePhoneList freePhoneList = objectMapper.readValue(freePhoneListJson.toString(), FreePhoneList.class);
                    ArrayList<NumberInfo> numbersList = freePhoneList.numbers;
                    for (NumberInfo numberInfo : numbersList) {
                        return numberInfo;
                    }
                } catch (JsonProcessingException e) {
                    e.printStackTrace();
                }
                return null;
            }).collect(Collectors.toList());

            numberInfoList.stream().filter(Objects::nonNull).forEach(System.out::println);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}