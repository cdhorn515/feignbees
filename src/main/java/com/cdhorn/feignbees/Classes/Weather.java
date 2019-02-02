package com.cdhorn.feignbees.Classes;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Weather {

    @JsonProperty("description")
    private String description;

    public String getDescription() {
        return description;
    }

    public Weather(String description) {
        this.description = description;
    }
}
