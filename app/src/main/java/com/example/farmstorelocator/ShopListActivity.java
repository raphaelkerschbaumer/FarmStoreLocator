package com.example.farmstorelocator;

import android.os.Build;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.farmstorelocator.adapters.FarmStoreAdapter;
import com.example.farmstorelocator.viewmodels.FarmStoreViewModel;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class ShopListActivity extends AppCompatActivity {
    private Toolbar buyerToolbar;
    private FarmStoreViewModel viewModel;
    private RecyclerView recyclerView;
    private FarmStoreAdapter adapter;

    @RequiresApi(api = Build.VERSION_CODES.O)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.shoplist);

        buyerToolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(buyerToolbar);

        recyclerView = findViewById(R.id.listOfShops);

        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        adapter = new FarmStoreAdapter(null);
        recyclerView.setAdapter(adapter);

        viewModel = new ViewModelProvider(this).get(FarmStoreViewModel.class);

        viewModel.getFarmStoreInfo().observe(this,
                farmStoreInfos -> {
                    adapter.updateData(farmStoreInfos);
                });

        viewModel.queryFarmStores();
    }
}
