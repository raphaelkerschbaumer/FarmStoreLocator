package com.example.farmstorelocator;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;


public class LoginPageActivity extends AppCompatActivity {
    private Toolbar buyerToolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.loginpage);

        buyerToolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(buyerToolbar);

        final Button button_login = (Button) findViewById(R.id.btn_login);

        button_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getBaseContext(), AccountBuyerActivity.class);
                startActivity(intent);
            }
        });

        final Button button_sign_go = (Button) findViewById(R.id.btn_go_signup);
        button_sign_go.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getBaseContext(), SignUpActivity.class);
                startActivity(intent);
            }
        });

        final Button forgot_pw = (Button) findViewById(R.id.btn_forgotpw);
        forgot_pw.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(), "Your bad", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
