package com.example.farmstorelocator;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.widget.AbsListView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.farmstorelocator.adapters.RadioAdapter;
import com.example.farmstorelocator.models.WebRadioCountry;
import com.example.farmstorelocator.viewmodels.RadioStationCountryViewModel;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class RadioSelectedShopActivity extends AppCompatActivity {
    private Toolbar buyerToolbar;
    private RadioStationCountryViewModel viewModel;
    private RecyclerView recyclerView;
    private RadioAdapter adapter;

    @RequiresApi(api = Build.VERSION_CODES.O)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.radioselectedshop);

        recyclerView = findViewById(R.id.RadioListOfShopItems);

        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        adapter = new RadioAdapter(null);
        recyclerView.setAdapter(adapter);

        viewModel = new ViewModelProvider(this).get(RadioStationCountryViewModel.class);

        viewModel.getWebRadioInfo().observe(this,
                webRadioInfo -> {
                    adapter.updateData(webRadioInfo);
                });

        viewModel.queryRadioStations("at");

       // Intent intent = getIntent();
       // String cityName = intent.getStringExtra("CITY_NAME");
       // String[] parts = cityName.split(";");



    }
}
