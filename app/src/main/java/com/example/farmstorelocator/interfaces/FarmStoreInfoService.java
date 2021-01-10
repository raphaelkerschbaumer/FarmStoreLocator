package com.example.farmstorelocator.interfaces;


import com.example.farmstorelocator.dto.FarmStoreData;
import com.example.farmstorelocator.dto.ListFarmStoresData;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Url;


public interface FarmStoreInfoService {

    @GET
    Call<FarmStoreData> getFarmStores(@Url String url);

    @GET
    Call<ListFarmStoresData> getFarmStoreList(@Url String url);
}


