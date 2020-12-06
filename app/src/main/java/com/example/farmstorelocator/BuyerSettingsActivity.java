package com.example.farmstorelocator;

import android.os.Bundle;

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
}
