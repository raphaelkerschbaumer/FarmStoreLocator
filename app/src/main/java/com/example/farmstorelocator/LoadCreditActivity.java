package com.example.farmstorelocator;

import android.os.Bundle;
import android.view.Menu;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;



public class LoadCreditActivity extends AppCompatActivity {
    private Toolbar buyerToolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.load_credit);

        buyerToolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(buyerToolbar);


        //set list View
        final ListView myList = (ListView) findViewById(R.id.listView_credit);
        //final Button btn = (Button) findViewById(R.id.item1);

        //list items
        String[] items = new String[]{
                "Visa",
                "MasterCard",
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


    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.toolbar_menu, menu);
        return true;
    }
}
