package com.example.farmstorelocator;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FilterShopActivity extends AppCompatActivity {
    private Toolbar buyerToolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.filter_map);

        buyerToolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(buyerToolbar);

        //set list View
        final ListView myList = (ListView) findViewById(R.id.list_products);
        //final Button btn = (Button) findViewById(R.id.item1);

        //list items
        String[] items = new String[]{
                "eggs",
                "milk",
                "apples"
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

         Button showresult = (Button) findViewById(R.id.button_showresult);

        showresult.setOnClickListener(new View.OnClickListener() {
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
