package com.example.farmstorelocator;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.farmstorelocator.adapters.FarmStoreAdapter;
import com.example.farmstorelocator.models.FarmStoreInfo;
import com.example.farmstorelocator.viewmodels.FarmStoreViewModel;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class ShopListActivity extends AppCompatActivity  {
    private final static int DISTANCE_DUMMY = 1000;
    private Toolbar buyerToolbar;
    private FarmStoreViewModel viewModel;
    private RecyclerView recyclerView;
    private FarmStoreAdapter adapter;
    private Button buttonRefresh, buttonShowOnMap;
    private List<FarmStoreInfo> fsiList;

    @RequiresApi(api = Build.VERSION_CODES.O)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.shoplist);

        buyerToolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(buyerToolbar);
        buttonRefresh = findViewById(R.id.refreshShopListButton);
        buttonShowOnMap = findViewById(R.id.showOnMapShopList);

        recyclerView = findViewById(R.id.listOfShops);

        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        adapter = new FarmStoreAdapter(ShopListActivity.this,null);

        recyclerView.setAdapter(adapter);

        viewModel = new ViewModelProvider(this).get(FarmStoreViewModel.class);

        viewModel.getFarmStoreInfoList().observe(this,
                farmStoreInfoList -> {
            adapter.updateDataList(farmStoreInfoList);
            fsiList = farmStoreInfoList;
        });


        buttonRefresh.setOnClickListener( view -> {
                    viewModel.queryFarmStoreList(DISTANCE_DUMMY);
                }
        );

        buttonShowOnMap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int i = 0;
                String label = "FARM_STORE_OBJECT_";
                List<String> labelList = new ArrayList<>();
                Intent intent = new Intent(getBaseContext(), MapsActivity.class);

                if(fsiList != null){
                    //for(FarmStoreInfo fsi : fsiList){
                    //    labelList.add(label + i);
                    //    intent.putExtra(labelList.get(i), (Serializable) fsiList);
                    //    i++;
                    //}
                    intent.putExtra("FARM_STORE_OBJECTS", (Serializable) fsiList);
                    intent.putExtra("PREVIOUS_ACTIVITY", "ShopListActivity");
                    startActivity(intent);
                }
                else {
                    Log.d("ShopList", "Farm Store List couldn't be initialized, farmStoreInfoList is null.");
                }
            }
        });

        Button filter_shoplist = (Button) findViewById(R.id.button5);
        filter_shoplist.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getBaseContext(), FilterShopActivity.class);
                startActivity(intent);
            }
        });
    }
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.toolbar_menu, menu);
        return true;
    }
    public boolean onOptionsItemSelected (MenuItem item){
        switch(item.getItemId()){
            case R.id.item1:
                Intent intent = new Intent(getBaseContext(), BuyerSettingsActivity.class);
                startActivity(intent);
                finish();
                break;

            case R.id.item2:
                intent = new Intent(getBaseContext(), AccountBuyerActivity.class);
                startActivity(intent);
                finish();
                break;

            case R.id.item3:
                Toast.makeText(getApplicationContext(), "You are not logged in", Toast.LENGTH_SHORT).show();
                break;
        }
        return true;
    }
}
