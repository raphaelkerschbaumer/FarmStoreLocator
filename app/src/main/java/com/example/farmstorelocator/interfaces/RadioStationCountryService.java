package com.example.farmstorelocator.interfaces;


import com.example.farmstorelocator.dto.CurrentRSCountPerCountry;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;
import retrofit2.http.Url;


public interface RadioStationCountryService {

    @GET
    Call<CurrentRSCountPerCountry> getCurrentStationCount(@Url String textFilter);
    //@GET("countries")
    //Call<CurrentRSCountPerCountry> getCurrentStationCount(@Query("") String textFilter);
}


