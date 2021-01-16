package com.example.farmstorelocator;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.farmstorelocator.adapters.FarmStoreAdapter;
import com.example.farmstorelocator.viewmodels.FarmStoreViewModel;

public class ShopListActivity extends AppCompatActivity  {
    private final static int DISTANCE_DUMMY = 1000;
    private Toolbar buyerToolbar;
    private FarmStoreViewModel viewModel;
    private RecyclerView recyclerView;
    private FarmStoreAdapter adapter;
    private Button buttonRefresh;

    @RequiresApi(api = Build.VERSION_CODES.O)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.shoplist);

        buyerToolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(buyerToolbar);
        buttonRefresh = findViewById(R.id.refreshShopListButton);

        recyclerView = findViewById(R.id.listOfShops);

        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        adapter = new FarmStoreAdapter(ShopListActivity.this,null);

        recyclerView.setAdapter(adapter);

        viewModel = new ViewModelProvider(this).get(FarmStoreViewModel.class);

        viewModel.getFarmStoreInfoList().observe(this,
                farmStoreInfoList -> {
            adapter.updateDataList(farmStoreInfoList);
         });


        buttonRefresh.setOnClickListener( view -> {
                viewModel.queryFarmStoreList(DISTANCE_DUMMY);
            }
        );

        final Button showlistonmap = (Button) findViewById(R.id.showOnMapShopList);

        showlistonmap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getBaseContext(), MapsActivity.class);
                startActivity(intent);
            }
        });
    }

}
