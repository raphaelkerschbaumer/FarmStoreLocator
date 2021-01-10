package com.example.farmstorelocator.services;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.example.farmstorelocator.dto.FarmStoreData;
import com.example.farmstorelocator.dto.ListFarmStoresData;
import com.example.farmstorelocator.models.FarmStoreInfo;

import java.time.Instant;
import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class FarmStoreInfoRepository {
    private NetworkService service = NetworkService.getInstance();
    private MutableLiveData<List<FarmStoreInfo>> farmStoreList;
    String myListUrl = "http://10.0.2.2:5000/multiplecompanies";

    public LiveData<List<FarmStoreInfo>> getFarmStoreInfoList() {
        if (farmStoreList == null)
            farmStoreList = new MutableLiveData<>();
        return farmStoreList;
    }

    public void findFarmStoreList(int distance){
        service.getFarmStoreInfoService().getFarmStoreList(myListUrl)
                .enqueue(new Callback<ListFarmStoresData>() {
                    @Override
                    public void onResponse(Call<ListFarmStoresData> call, Response<ListFarmStoresData> response) {
                        ListFarmStoresData serverData = response.body();

                        List<FarmStoreInfo> result = Arrays.stream(serverData.getFarmStoreData()).map(
                                new Function<FarmStoreData, FarmStoreInfo>() {
                                    @Override
                                    public FarmStoreInfo apply(FarmStoreData farmStoreData) {
                                        return new FarmStoreInfo(farmStoreData.getId(),
                                                farmStoreData.getName(),
                                                farmStoreData.getZip(),
                                                farmStoreData.getTown(),
                                                farmStoreData.getStreet(),
                                                farmStoreData.getOpeningHours(),
                                                farmStoreData.getProducts());
                                    }
                                }
                        ).collect(Collectors.toList());
                        farmStoreList.postValue(result);
                    }

                    @Override
                    public void onFailure(Call<ListFarmStoresData> call, Throwable t) {}
                });
    }

}



