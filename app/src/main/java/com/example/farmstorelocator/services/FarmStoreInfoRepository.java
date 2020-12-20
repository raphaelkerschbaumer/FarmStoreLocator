package com.example.farmstorelocator.services;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.example.farmstorelocator.dto.FarmStoreData;
import com.example.farmstorelocator.dto.ListFarmStoresData;
import com.example.farmstorelocator.models.FarmStoreInfo;

import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class FarmStoreInfoRepository {
    private NetworkService service = NetworkService.getInstance();
    private MutableLiveData<List<FarmStoreInfo>> farmStoreInfo;

    String myBaseUrl = "http://10.0.2.2:5000/companies";

    public LiveData<List<FarmStoreInfo>> getFarmStoreInfo() {
        if (farmStoreInfo == null)
            farmStoreInfo = new MutableLiveData<>();
        return farmStoreInfo;
    }

   public void findFarmStores(){
        service.getFarmStoreInfoService().getFarmStores(myBaseUrl)
                .enqueue(new Callback<ListFarmStoresData>(){
                             @Override
                             public void onResponse(Call<ListFarmStoresData> call, Response<ListFarmStoresData> response) {
                                 ListFarmStoresData serverData = response.body();
                                 List<FarmStoreInfo> result = Arrays.stream(serverData.getFarmStoreData()).map(
                                         new Function<FarmStoreData, FarmStoreInfo>() {
                                             public FarmStoreInfo apply(FarmStoreData d){
                                                 return new FarmStoreInfo(d.getName(),d.getZip(),d.getTown(),d.getStreet(),d.getOpeningHours(),d.getProducts());
                                             }
                                         }).collect(Collectors.toList());
                                 farmStoreInfo.postValue(result);
                             }

                             @Override
                             public void onFailure(Call<ListFarmStoresData> call, Throwable t) {

                             }
                         });
    }

}



