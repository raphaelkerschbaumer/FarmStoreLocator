package com.example.farmstorelocator.services;


import com.example.farmstorelocator.interfaces.FarmStoreInfoService;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class NetworkService {
    private static NetworkService mInstance;
    private Retrofit retrofit;

    private NetworkService() {
        retrofit = new Retrofit.Builder()
                .baseUrl("http://10.0.2.2:5000/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }

    public static NetworkService getInstance() {
        if (mInstance == null)
            mInstance = new NetworkService();
        return mInstance;
    }

    public FarmStoreInfoService getFarmStoreInfoService(){
        return retrofit.create(FarmStoreInfoService.class);
    }

}
