package com.example.farmstorelocator.viewmodels;

import android.os.Build;

import androidx.annotation.RequiresApi;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Transformations;
import androidx.lifecycle.ViewModel;

import com.example.farmstorelocator.models.FarmStoreInfo;
import com.example.farmstorelocator.services.FarmStoreInfoRepository;

import java.util.List;

public class FarmStoreViewModel extends ViewModel {

    private FarmStoreInfoRepository repository = new FarmStoreInfoRepository();

    @RequiresApi(api = Build.VERSION_CODES.O)
    public LiveData<List<FarmStoreInfo>> getFarmStoreInfoList() {
        return Transformations.map(repository.getFarmStoreInfoList(),
                farmStoreInfoList -> farmStoreInfoList);
    }

    @RequiresApi(api = Build.VERSION_CODES.O)
    public void queryFarmStoreList(int distance) {
        repository.findFarmStoreList(distance);
    }
}
