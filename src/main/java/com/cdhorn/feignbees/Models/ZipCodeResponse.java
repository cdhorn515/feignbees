package com.cdhorn.feignbees.Models;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ZipCodeResponse {
    @JsonProperty("distance")
    private float distance;

    public static final String decimalFormatStr = "0.00";

    @JsonProperty("distance")
    public float getDistance() {
        return distance;
    }

    public ZipCodeResponse(float distance) {
        this.distance = distance;
    }

    @Override
    public String toString() {
        return "ZipCodeResponse{" +
                "distance='" + distance + '\'' +
                '}';
    }

}
