package com.example.farmstorelocator;
/* Code Snippets/Helpers/etc.
    QR-Scanner: https://www.journaldev.com/18198/qr-code-barcode-scanner-android
 */

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

public class MainActivity extends AppCompatActivity {

    private Toolbar buyerToolbar;

    @RequiresApi(api = Build.VERSION_CODES.O)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Intent intent = new Intent(getBaseContext(), LoginPageActivity.class);
        startActivity(intent);
    }
}

