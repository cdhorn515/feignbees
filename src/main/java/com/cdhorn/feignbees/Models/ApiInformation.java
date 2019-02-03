package com.cdhorn.feignbees.Models;

public class ApiInformation {

    // for petfinder
    private String APIKEY = "76193c74d72a83615da948468d17251f";
    private String APISECRET = "e5841d2ce9c76042888d84a435f71ead";

    // for weatherunlocked
    private String WU_APPID = "a74e0df3";
    private String WU_APPKEY = "1fcd2572b677910051ec1179bfface09";

    // for openweathermap
    private String APPID = "ff39b07d8f30b3075727ec5dfee364e1";

    //zipcodeapi
    private String ZC_APIKEY = "IJlOr089ConlJ6khihNfMkyJwyJr2eOWzuDfRK2VDBHEGooqpdhKvpJQspznY1Wf";



    public String getZC_APIKEY() {
        return ZC_APIKEY;
    }

    public String getAPISECRET() {
        return APISECRET;
    }

    public String getWU_APPID() {
        return WU_APPID;
    }

    public String getWU_APPKEY() {
        return WU_APPKEY;
    }


    public String getAPPID() {
        return APPID;
    }

    public String getAPIKEY() {
        return APIKEY;
    }
}
