package com.cdhorn.feignbees.Interfaces;

import com.cdhorn.feignbees.Models.WeatherResponse;
import com.cdhorn.feignbees.Models.ZipCodeResponse;
import feign.Param;
import feign.RequestLine;


public interface FeignInterface {

    @RequestLine(value = "GET /data/2.5/weather?zip={zip}&APPID={key}")
    WeatherResponse getCity(@Param(value = "zip") String zip, @Param("key") String key);

    @RequestLine(value = "GET /rest/{clientKey}/distance.json/{zipcode}/20001/mile")
    ZipCodeResponse getDistance(@Param("clientKey") String clientKey, @Param(value = "zipcode") String zipcode);
}


