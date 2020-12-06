package com.example.farmstorelocator;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class FilterMapActivity extends AppCompatActivity {
    private Toolbar buyerToolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.filter_map);

        buyerToolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(buyerToolbar);

    }
}
