//package com.cdhorn.feignbees.Classes;
//
//import com.cdhorn.feignbees.Interfaces.FeignInterface;
//import com.cdhorn.feignbees.Models.WeatherAPI;
//import feign.Feign;
//import feign.gson.GsonDecoder;
//import feign.gson.GsonEncoder;
//
//public class HelperFx {
//
//    WeatherAPI weatherAPI = new WeatherAPI();
//
//    public WeatherResponse getZipCode(String zipCode) {
//        System.out.println("++++++HELPERFX+++++++++");
//        System.out.println(zipCode);
//        FeignInterface feign = Feign.builder()
//                .encoder(new GsonEncoder())
//                .decoder(new GsonDecoder())
//                .target(FeignInterface.class, "http://api.openweathermap.org/data/2.5");
////        WeatherResponse response = feign.weatherResponse(zipCode, weatherAPI.getAPPID());
//        WeatherResponse response = feign.weatherResponse();
////        WeatherResponse response = feign.weatherResponse();
//        return response;
//    }
//}
