package com.cdhorn.feignbees.Models;

//@JsonRootName("CurrentWeather")

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.HashMap;
import java.util.Map;

public class WeatherResponse {

    @JsonProperty("name")
    private String name;

    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("name")
    public String getName() {
        return name;
    }

    public WeatherResponse(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "WeatherResponse{" +
                "name='" + name + '\'' +
                '}';
    }
}
