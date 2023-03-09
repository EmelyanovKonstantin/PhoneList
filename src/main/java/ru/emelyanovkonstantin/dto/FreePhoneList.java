package ru.emelyanovkonstantin.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.ArrayList;

/**
 *  dto that represent a list of countries {@link ru.emelyanovkonstantin.dto.NumberInfo}
 *  @version 1.0
 */
public class FreePhoneList {

    public Integer response;

    @JsonProperty("numbers")
    public ArrayList<NumberInfo> numbers;
}
