package com.cdhorn.feignbees.Interfaces;

import com.cdhorn.feignbees.Classes.WeatherResponse;
import feign.RequestLine;


public interface FeignInterface {

    @RequestLine(value = "GET /weather?units=imperial&zip=22314,us&APPID=ff39b07d8f30b3075727ec5dfee364e1")
    WeatherResponse weatherResponse();
//    WeatherResponse weatherResponse(@Param("zip") String zip, @Param("key") String key);
}
//    @RequestLine("GET /data/2.5/weather?units=imperial&zip=22314,us&APPID={key}")
//    @Headers("Content-Type: application/json")

