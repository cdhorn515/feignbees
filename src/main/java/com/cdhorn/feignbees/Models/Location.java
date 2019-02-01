package com.cdhorn.feignbees.Models;

public class Location {
    private String zip;

    public String getZip() {
        return zip;
    }

    public void setZip(String zip) {
        this.zip = zip;
    }

    public Location(String zip) {
        this.zip = zip;
    }

    public Location() {
    }
}
