package com.example.farmstorelocator;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;


public class FilterMapActivity extends AppCompatActivity {
    private Toolbar buyerToolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.filter_map);

        buyerToolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(buyerToolbar);

         Button showresult = (Button) findViewById(R.id.button_showresult);

        showresult.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getBaseContext(), MapsActivity.class);
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
