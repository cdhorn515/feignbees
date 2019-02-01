package com.cdhorn.feignbees.Classes;

public class WeatherResponse {

    Main main;
    private String name;


    public Main getMain() {
        return main;
    }

    public void setMain(Main main) {
        this.main = main;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public WeatherResponse(Main main, String name) {
        this.main = main;
        this.name = name;
    }

    public float getTemperature() {
        return main.getTemperature();
    }

    public void setTemperature(float temperature) {
        main.setTemperature(temperature);
    }


}
