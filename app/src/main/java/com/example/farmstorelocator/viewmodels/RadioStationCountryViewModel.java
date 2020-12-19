package com.example.farmstorelocator.viewmodels;

import android.os.Build;

import androidx.annotation.RequiresApi;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Transformations;
import androidx.lifecycle.ViewModel;

import com.example.farmstorelocator.models.WebRadioCountry;
import com.example.farmstorelocator.services.RadioStationCountryRepository;

import java.util.List;

public class RadioStationCountryViewModel extends ViewModel {

    private RadioStationCountryRepository repository = new RadioStationCountryRepository();

    @RequiresApi(api = Build.VERSION_CODES.O)
    public LiveData<List<WebRadioCountry>> getWebRadioInfo() {
        return Transformations.map(repository.getWebRadioInfo(),
                webRadioInfo -> webRadioInfo);
    }
    @RequiresApi(api = Build.VERSION_CODES.O)
    public void queryRadioStations(String textFilter) {
        repository.findRadioStations(textFilter);
    }

}
