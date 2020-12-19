package com.example.farmstorelocator.services;


import com.example.farmstorelocator.interfaces.RadioStationCountryService;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class NetworkService {
    private static NetworkService mInstance;
    private Retrofit retrofit;

    private NetworkService() {
        retrofit = new Retrofit.Builder()
                .baseUrl("https://de1.api.radio-browser.info/json/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }

    public static NetworkService getInstance() {
        if (mInstance == null)
            mInstance = new NetworkService();
        return mInstance;
    }

    public RadioStationCountryService getRadioStationCountryService() {
        return retrofit.create(RadioStationCountryService.class);
    }
}
