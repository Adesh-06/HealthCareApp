package com.example.healthcareapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class HomeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        SharedPreferences sharedPreferences = getSharedPreferences("shared_prefs", Context.MODE_PRIVATE);
        String username = sharedPreferences.getString("username", "");

        // Check if the welcome message has been shown
        boolean isWelcomeShown = sharedPreferences.getBoolean("isWelcomeShown", false);

        if (!isWelcomeShown) {
            // Show the welcome message only the first time after login
            Toast.makeText(this, "Welcome " + username, Toast.LENGTH_SHORT).show();

            // Update SharedPreferences to set the flag
            SharedPreferences.Editor editor = sharedPreferences.edit();
            editor.putBoolean("isWelcomeShown", true);
            editor.apply();
        }

        // CardView for exit
        CardView exit = findViewById(R.id.cardExit);
        exit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.clear();  // Clear all saved data on logout
                editor.apply();
                startActivity(new Intent(HomeActivity.this, LoginAct.class));
            }
        });

        // CardView for find doctor
        CardView findDoctor = findViewById(R.id.cardFindDoctor);
        findDoctor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(HomeActivity.this, FindDoctor.class));
            }
        });

        // CardView for lab test
        CardView labTest = findViewById(R.id.cardLabTest);
        labTest.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(HomeActivity.this, LabTestAct.class));
            }
        });

        CardView orderDetails=findViewById(R.id.cardOrderDetails);
        orderDetails.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(HomeActivity.this,orderDetails.class));
            }
        });

        CardView buyMedicine=findViewById(R.id.cardBuyMedicine);
        buyMedicine.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(HomeActivity.this,BuyMedicine.class));
            }
        });

    }
}
