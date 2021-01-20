package com.example.farmstorelocator;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;


public class BuyerSettingsActivity extends AppCompatActivity {
    private Toolbar buyerToolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.settings_buyer);

        buyerToolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(buyerToolbar);


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
