package com.cdhorn.feignbees.Interfaces;

import com.cdhorn.feignbees.Classes.Main;
import com.cdhorn.feignbees.Classes.WeatherResponse;
import feign.Param;
import feign.RequestLine;
import org.springframework.web.bind.annotation.PathVariable;


public interface FeignInterface {

    @RequestLine(value = "GET /weather?units=imperial&zip=22314&APPID={key}")
//    WeatherResponse weatherResponse();
    WeatherResponse weatherResponse(@Param("key") String key);

    @RequestLine(value = "GET /weather?units=imperial&zip={zip},us&APPID={key}")
//    WeatherResponse weatherResponse();
    Main mainResponse(@PathVariable("zip") String zip, @Param("key") String key);

//    @RequestLine(value = "api/trigger/us.33109/")
}
//    @RequestLine("GET /data/2.5/weather?units=imperial&zip=22314,us&APPID={key}")
//    @Headers("Content-Type: application/json")

