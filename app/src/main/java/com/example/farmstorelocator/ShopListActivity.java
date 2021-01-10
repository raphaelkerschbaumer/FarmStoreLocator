package com.example.farmstorelocator;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

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
    private final static int DISTANCE_DUMMY = 1000;
    private Toolbar buyerToolbar;
    private FarmStoreViewModel viewModel;
    private RecyclerView recyclerView;
    private TextView textViewTest;
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

        textViewTest = findViewById(R.id.textViewTestDummy);

        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        adapter = new FarmStoreAdapter(null);
        recyclerView.setAdapter(adapter);

        viewModel = new ViewModelProvider(this).get(FarmStoreViewModel.class);

        viewModel.getFarmStoreInfoList().observe(this,
                farmStoreInfoList -> {
            adapter.updateDataList(farmStoreInfoList);
        });

       // viewModel.queryFarmStoreList(DISTANCE_DUMMY);


        //viewModel.getFarmStoreInfo().observe(this,
        //        farmStoreInfos -> {
        //            if(farmStoreInfos.isError()){
        //                Toast.makeText(ShopListActivity.this,farmStoreInfos.getError(),Toast.LENGTH_SHORT).show();
        //            }
        //            else{
        //                textViewTest.setText(String.format("FS: %s, %s, %s",farmStoreInfos.getName(), farmStoreInfos.getTown(), farmStoreInfos.getStreet()));
        //                //adapter.updateData(farmStoreInfos);
        //            }
        //        });

        buttonRefresh.setOnClickListener( view -> {
                viewModel.queryFarmStoreList(DISTANCE_DUMMY);
            }
        );
    }
}
