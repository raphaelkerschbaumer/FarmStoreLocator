package com.example.farmstorelocator;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class AccountBuyerActivity extends AppCompatActivity {
    private Toolbar buyerToolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.account_buyer);

        buyerToolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(buyerToolbar);

        //set list View
        final ListView myList = (ListView) findViewById(R.id.listRecentBuys);
        //final Button btn = (Button) findViewById(R.id.item1);

        //list items
        String[] items = new String[]{
                "Kräuter Sigi   5,50 €",
                "Kuchlbauer     2,30 €",
                "Seifried       8,60 €"
        };

        //create a list from the string elements
        final List<String> itemsList = new ArrayList<String>(Arrays.asList(items));

        //create an Array Adapter from list
        final ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(this,android.R.layout.simple_selectable_list_item, itemsList);

        // DataBind ListView with items from ArrayAdapter
        myList.setAdapter(arrayAdapter);

        //  btn.setOnClickListener(new View.OnClickListener() {
        //      @Override
        //      public void onClick(View v) {
        //          // Add new Items to List
        //          itemsList.add("Entry 11");
        //          itemsList.add("Entry 12");
        //          arrayAdapter.notifyDataSetChanged();
        //      }
        //  });

        final Button load_credit = (Button) findViewById(R.id.options_load_credit);

        load_credit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getBaseContext(), LoadCreditActivity.class);
                startActivity(intent);
            }
        });

        final Button showmap = (Button) findViewById(R.id.options_open_map);

        showmap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getBaseContext(), MapsActivity.class);
                startActivity(intent);
            }
        });

        final Button showshoplist = (Button) findViewById(R.id.options_open_shoplist);

        showshoplist.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getBaseContext(), ShopListActivity.class);
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
