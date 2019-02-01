package com.cdhorn.feignbees.Interfaces;

import com.cdhorn.feignbees.Classes.WeatherResponse;
import feign.Headers;
import feign.Param;
import feign.RequestLine;


//@FeignClient(value = Class<? extends Encoder> encoder = default feign.codec.Decoder.Default.class)
public interface FeignInterface {

    @RequestLine("POST /data/2.5/weather?units=imperial&zip={zip},us&APPID={key}")
    @Headers("Content-Type: application/json")
    WeatherResponse weatherResponse(@Param("zip") String zip, @Param("key") String key);
}
