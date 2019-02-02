package com.cdhorn.feignbees.Classes;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Main {

    @JsonProperty("temp")
    private float temperature;

    @JsonProperty("temp")
    public float getTemperature() {
        return temperature;
    }

    public void setTemperature(float temperature) {
        this.temperature = temperature;
    }

    public Main(float temperature) {
        this.temperature = temperature;
    }
}
