package com.example.farmstorelocator.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

//https://android.jlelse.eu/rest-api-on-android-made-simple-or-how-i-learned-to-stop-worrying-and-love-the-rxjava-b3c2c949cad4
//http://de1.api.radio-browser.info/json/countries

public class WebRadioCountry {
    private String name;
    private Integer stationcount;
    private String error;

    public WebRadioCountry(String name, Integer stationcount) {
        this.name = name;
        this.stationcount = stationcount;
    }

    public WebRadioCountry(String error) {
        this.error = error;
    }

    public String getName() {
        return name;
    }

    public Integer getStationcount() {
        return stationcount;
    }
    public boolean isError(){
        return error != null;
    }

    public String getError() {
        return error;
    }
}
