package com.example.donation10;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
/**
 * import support libraries for toolbar
 *
 */
import androidx.appcompat.widget.Toolbar;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

/**
 * import libraires for
 * RadioGroup, ProgressBar and NumberPicker
 */

import android.widget.NumberPicker;
import android.widget.ProgressBar;
import android.widget.RadioGroup;

public class MainActivity extends AppCompatActivity {

    private Button donateButton;

    private RadioGroup paymentMethod;
    private ProgressBar progressBar;
    private NumberPicker amountPicker;

    //bien de bo sung tinh nang ghi nho so tien donate
    private int totalDonated = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // these following lines are not working
        //Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
//        setSupportActionBar(toolbar);
//
//        FloatingActionButton fab = (FloatingActionButton)
//                findViewById(R.id.fab);
//        fab.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Snackbar.make(view, "Replace with your own",
//                        Snackbar.LENGTH_LONG)
//                        .setAction("Action", null).show();
//            }
//        });

        donateButton = (Button) findViewById(R.id.donateButton);

        if (donateButton != null){
            Log.v("Donate", "Really got the donate button");
        }

        paymentMethod = (RadioGroup) findViewById(R.id.paymentMethod);
        progressBar = (ProgressBar) findViewById(R.id.progressBar);
        amountPicker = (NumberPicker)  findViewById(R.id.amountPicker);

        amountPicker.setMinValue(0);
        amountPicker.setMaxValue(1000);

        progressBar.setMax(10000);
    }

    public void donateButtonPressed(View view){
        int amount = amountPicker.getValue();
        int radioId = paymentMethod.getCheckedRadioButtonId();

        String method = radioId == R.id.Paypal ? "Paypal" : "Direct";
        /**
         * giai thich cau lenh tren
         */
//        String method = "";
//        if (radioId == R.id.Paypal){
//            method = "Paypal";
//        } else {
//            method = "Direct";
//        }

        totalDonated = totalDonated + amount;
        progressBar.setProgress(totalDonated);

        Log.v("Donate", "Donate Pressed!" + amount
            + ", method: " + method);

        Log.v("Donate", "Current total " + totalDonated);
    }

//    @Override
//    public boolean onCreateOptionsMenu(Menu menu){
//
//        getMenuInflater().inflate(R.menu.menu_donate, menu);
//        return true;
//    }

//    @Override
//    public boolean onOptionsItemSelected(MenuItem item){
//
//        int id = item.getItemId();
//
//        if (id == R.id.action_settings){
//            return true;
//        }
//
//        return super.onOptionsItemSelected(item);
//    }
}