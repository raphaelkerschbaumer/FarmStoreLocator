package com.example.farmstorelocator;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;


public class WelcomePageActivity extends AppCompatActivity {
    private Toolbar buyerToolbar;
    private Handler mHandler = new Handler();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.welcomepage);

        buyerToolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(buyerToolbar);

        mHandler.postDelayed(new Runnable(){
            public void run(){
                Intent intent = new Intent(getBaseContext(), LoginPageActivity.class);
                startActivity(intent);
            }
        }, 4000);

    }


}
