package com.example.farmstorelocator.interfaces;


import com.example.farmstorelocator.dto.ListFarmStoresData;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Url;


public interface FarmStoreInfoService {

    @GET
    Call<ListFarmStoresData> getFarmStores(@Url String url);
    //@GET("countries")
    //Call<CurrentRSCountPerCountry> getCurrentStationCount(@Query("") String textFilter);
}


