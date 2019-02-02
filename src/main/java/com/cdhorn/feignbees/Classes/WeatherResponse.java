package com.cdhorn.feignbees.Classes;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.HashMap;
import java.util.Map;

public class WeatherResponse {
    @JsonProperty("main")
    Main main;
    @JsonProperty("name")
    private String name;

    @JsonProperty("main")
    public Main getMain() {
        return main;
    }

    public void setMain(Main main) {
        this.main = main;
    }
    @JsonIgnore
    public Map<String, Object> getAdditionalProperties() {
        return additionalProperties;
    }
    @JsonIgnore
    public void setAdditionalProperties(Map<String, Object> additionalProperties) {
        this.additionalProperties = additionalProperties;
    }

    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public WeatherResponse(Main main, String name, float temperature) {
        this.main = main;
        this.name = name;
        this.temperature = temperature;
    }

    @Override
    public String toString() {
        return "WeatherResponse{" +
                "main=" + main +
                ", name='" + name + '\'' +
                ", additionalProperties=" + additionalProperties +
                ", temperature=" + temperature +
                '}';
    }

    @JsonProperty("temp")
    float temperature;

    @JsonProperty("temp")
    public float getTemperature() {
        return main.getTemperature();
    }
    @JsonProperty("temp")
    public void setTemperature(float temperature) {
        main.setTemperature(temperature);
    }


}
