package com.example.farmstorelocator;
/* Code Snippets/Helpers/etc.
    QR-Scanner: https://www.journaldev.com/18198/qr-code-barcode-scanner-android
                https://ourcodeworld.com/articles/read/907/how-to-create-a-qr-code-reader-in-android-using-the-qreader-library
 */

import android.os.Bundle;
import android.view.Menu;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private Toolbar buyerToolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.qrscan);

        buyerToolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(buyerToolbar);

        //set list View
        final ListView myList = (ListView) findViewById(R.id.listScannedProducts);
        //final Button btn = (Button) findViewById(R.id.item1);

        //list items
        String[] items = new String[]{
                "Entry 1",
                "Entry 2",
                "Entry 3",
                "Entry 4",
                "Entry 5",
                "Entry 6",
                "Entry 7",
                "Entry 8",
                "Entry 9",
                "Entry 10",
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

