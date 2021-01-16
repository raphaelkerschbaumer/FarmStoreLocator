package com.example.farmstorelocator;

import android.content.Intent;
import android.icu.util.Calendar;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import com.example.farmstorelocator.models.FarmStoreInfo;
import com.example.farmstorelocator.models.OpeningHours;
import com.example.farmstorelocator.models.Products;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;


public class SelectedShopActivity extends AppCompatActivity {
    private Toolbar buyerToolbar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Intent intent = getIntent();
        FarmStoreInfo data = (FarmStoreInfo)intent.getSerializableExtra("FARM_STORE_OBJECT");
        List<String> items = new ArrayList<>();
        Calendar c = Calendar.getInstance();
        int dayOfWeek = c.get(Calendar.DAY_OF_WEEK);
        String weekDay = "";

        if (Calendar.MONDAY == dayOfWeek) weekDay = "Mo";
        else if (Calendar.TUESDAY == dayOfWeek) weekDay = "Tu";
        else if (Calendar.WEDNESDAY == dayOfWeek) weekDay = "We";
        else if (Calendar.THURSDAY == dayOfWeek) weekDay = "Th";
        else if (Calendar.FRIDAY == dayOfWeek) weekDay = "Fr";
        else if (Calendar.SATURDAY == dayOfWeek) weekDay = "Sa";
        else if (Calendar.SUNDAY == dayOfWeek) weekDay = "Su";


        setContentView(R.layout.selectedshop);
        buyerToolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(buyerToolbar);


        //set View
        final ListView myList = findViewById(R.id.ListOfShopItems);
        final TextView textFarmStoreName = findViewById(R.id.product_scan);
        final TextView textFarmStoreZipTown = findViewById(R.id.data_addr_zipcode);
        final TextView textFarmStoreStreet = findViewById(R.id.data_addr_streetname);
        final TextView textFarmStoreOpeningHours = findViewById(R.id.time_open_hours);

        textFarmStoreName.setText(data.getName());
        textFarmStoreZipTown.setText(data.getZip()+" "+data.getTown());
        textFarmStoreStreet.setText(data.getStreet());
        for(OpeningHours day : data.getOpeningHours()){
            if(day.getDay().equals(weekDay)){
                textFarmStoreOpeningHours.setText(day.getDay() + " " + day.getHours());
            }
        }

        for(Products prod : data.getProducts()){
            items.add(prod.getType());
        }

        //create a list from the string elements
        final List<String> itemsList = new ArrayList<String>(items);

        //create an Array Adapter from list
        final ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(this,android.R.layout.simple_selectable_list_item, itemsList);

        // DataBind ListView with items from ArrayAdapter
        myList.setAdapter(arrayAdapter);

        final Button scanproduct = (Button) findViewById(R.id.button_scan_products);

        scanproduct.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getBaseContext(), QRScanActivity.class);
                startActivity(intent);
            }
        });

        final Button showShopOnMap = (Button) findViewById(R.id.button_shoplist_show_on_map);
        showShopOnMap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getBaseContext(), MapsActivity.class);
                intent.putExtra("FARM_STORE_OBJECTS", (Serializable) data);
                intent.putExtra("PREVIOUS_ACTIVITY", "SelectedShopActivity");
                startActivity(intent);
            }
        });

    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.toolbar_menu, menu);
        return true;
    }
}
