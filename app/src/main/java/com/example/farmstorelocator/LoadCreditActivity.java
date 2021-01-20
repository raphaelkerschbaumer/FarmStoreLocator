package com.example.farmstorelocator;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;



public class LoadCreditActivity extends AppCompatActivity {
    private Toolbar buyerToolbar;
   // public static final String LOG_TAG = LoadCreditActivity.class.getSimpleName();
    Database db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.load_credit);

       // db = new Database(this);
        buyerToolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(buyerToolbar);

       /* CreditMemo testMemo = new CreditMemo((double) 20, 1);
        Log.d(LOG_TAG, "InhaltTestmemo: " + testMemo.toString());
        dataScource = new CreditMemoDataSource(this);*/
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
        EditText updateamount = findViewById(R.id.editTextNumberDecimal2);
        String amount = updateamount.getText().toString();
       final Button btn_update = findViewById(R.id.button2);

       btn_update.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
              // db.db.execSQL("insert into credit (amount) values (' " + amount + "')");
               Intent intent = new Intent(getApplicationContext(), AccountBuyerActivity.class);
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
