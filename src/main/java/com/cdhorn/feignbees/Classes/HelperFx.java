package com.cdhorn.feignbees.Classes;

import com.cdhorn.feignbees.Interfaces.FeignInterface;
import com.cdhorn.feignbees.Models.WeatherAPI;
import feign.Feign;
import feign.jackson.JacksonDecoder;
import feign.jackson.JacksonEncoder;

public class HelperFx {

    WeatherAPI weatherAPI = new WeatherAPI();

    public WeatherResponse getZipCode(String zipCode) {
        FeignInterface feign = Feign.builder()
                .encoder(new JacksonEncoder())
                .decoder(new JacksonDecoder())
                .target(FeignInterface.class, "http://api.openweathermap.org");
        WeatherResponse response = feign.weatherResponse(weatherAPI.getAPPID());
        return response;
    }
}
