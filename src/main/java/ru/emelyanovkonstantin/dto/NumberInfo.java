package ru.emelyanovkonstantin.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 *  Simple data transfer object that represent a number information
 *  * @version 1.0
 */
public class NumberInfo {

    public String number;

    public Integer country;

    @JsonProperty("updated_at")
    public String updatedAt;

    @JsonProperty("data_humans")
    public String dataHumans;

    @JsonProperty("full_number")
    public String fullNamber;

    @JsonProperty("country_text")
    public String countryText;

    public String maxdate;

    public String status;

    @Override
    public String toString() {
        return "number : " + this.number + ";  country : " + this.country +
                ";  updated_at : " + this.updatedAt + ";  data_humans : " + this.dataHumans +
                ";  full_number : " + this.fullNamber + ";  country_text : " + this.countryText +
                ";  maxdate : " + this.maxdate + ";  status : " + status;
    }
}
