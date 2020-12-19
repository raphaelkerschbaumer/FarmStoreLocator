package com.example.farmstorelocator.services;

import android.os.Build;

import androidx.annotation.RequiresApi;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.recyclerview.widget.DiffUtil;

import com.example.farmstorelocator.dto.CurrentRSCountPerCountry;
import com.example.farmstorelocator.dto.RadioStationCountryData;
import com.example.farmstorelocator.models.WebRadioCountry;


import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class RadioStationCountryRepository {
    private NetworkService service = NetworkService.getInstance();
    private MutableLiveData<List<WebRadioCountry>> WebRadioInfo;

    String myBaseUrl = "https://de1.api.radio-browser.info/json/countries/";

    public LiveData<List<WebRadioCountry>> getWebRadioInfo() {
        if (WebRadioInfo == null)
            WebRadioInfo = new MutableLiveData<>();
        return WebRadioInfo;
    }

   public void findRadioStations(String textFilter){
        service.getRadioStationCountryService().getCurrentStationCount(myBaseUrl+textFilter)
                .enqueue(new Callback<CurrentRSCountPerCountry>(){
                             @Override
                             public void onResponse(Call<CurrentRSCountPerCountry> call, Response<CurrentRSCountPerCountry> response) {
                                 CurrentRSCountPerCountry serverData = response.body();
                                 List<WebRadioCountry> result = Arrays.stream(serverData.getCurrent()).map(
                                         new Function<RadioStationCountryData, WebRadioCountry>() {
                                             public WebRadioCountry apply(RadioStationCountryData d){
                                                 return new WebRadioCountry(d.getCountry(),d.getCountOfStations());
                                             }
                                         }).collect(Collectors.toList());
                                 WebRadioInfo.postValue(result);
                             }

                             @Override
                             public void onFailure(Call<CurrentRSCountPerCountry> call, Throwable t) {

                             }
                         });
    }

}



