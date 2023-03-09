package ru.emelyanovkonstantin.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.ArrayList;

/**
 *  dto that represent a list of countries {@link ru.emelyanovkonstantin.dto.Country}
 *  @version 1.0
 */
public class FreeCountryList {

    public Integer response;

    @JsonProperty("countries")
    public ArrayList<Country> countries;
}
