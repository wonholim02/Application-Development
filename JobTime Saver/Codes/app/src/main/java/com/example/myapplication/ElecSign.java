package com.example.myapplication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class ElecSign extends AppCompatActivity {
    BottomNavigationView bottomNavigationView;
    EditText name;
    EditText position;
    EditText organization;
    EditText address;
    EditText city;
    EditText phone;
    EditText email;
    EditText website;
    TextView result;
    String namei, positioni, organizationi, addressi, cityi, phonei, emaili, websitei, resulti;
    private Button button12;
    private Button button;
    private Button button11;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_elec_sign);

        button12 = (Button) findViewById(R.id.button12);
        button = (Button) findViewById(R.id.button);
        button11 = (Button) findViewById(R.id.button11);
        result = (TextView) findViewById(R.id.textView15);
        name = (EditText) findViewById(R.id.editText1);
        position = (EditText) findViewById(R.id.editText2);;
        organization = (EditText) findViewById(R.id.editText3);;
        address = (EditText) findViewById(R.id.editText4);;
        city = (EditText) findViewById(R.id.editText5);;
        phone = (EditText) findViewById(R.id.editText6);;
        email = (EditText) findViewById(R.id.editText7);;
        website = (EditText) findViewById(R.id.editText8);;

        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setDisplayShowTitleEnabled(true);
        //getSupportActionBar().setIcon(R.drawable.logo);
        ActionBar actionBar;
        actionBar = getSupportActionBar();
        ColorDrawable colorDrawable
                = new ColorDrawable(Color.parseColor("#009688"));
        actionBar.setBackgroundDrawable(colorDrawable);

        bottomNavigationView = findViewById(R.id.bottom_navigator);
        bottomNavigationView.setSelectedItemId(R.id.elecsignature);
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch(item.getItemId()){
                    case R.id.coverletter:
                        startActivity(new Intent(getApplicationContext(), MainActivity.class));
                        overridePendingTransition(0,0);
                        return true;
                    case R.id.elecsignature:
                        return true;
                    case R.id.usefulinfo:
                        startActivity(new Intent(getApplicationContext(), UsefulInfo.class));
                        overridePendingTransition(0,0);
                        return true;
                    case R.id.tips:
                        startActivity(new Intent(getApplicationContext(), Tips.class));
                        overridePendingTransition(0,0);
                        return true;
                }
                return false;
            }
        });
        button12.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                namei = name.getText().toString();
                positioni = position.getText().toString();
                organizationi = organization.getText().toString();
                addressi = address.getText().toString();
                cityi = city.getText().toString();
                phonei = phone.getText().toString();
                emaili = email.getText().toString();
                websitei = website.getText().toString();
                resulti = result.getText().toString();
            }
        });
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                result1(v);
            }
        });
        button11.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                result2(v);
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu2, menu);

        return true;
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle presses on the action bar items
        switch (item.getItemId()) {
            case R.id.action_feedback:
                startActivity(new Intent(this, Feedback.class));
                return true;
            case R.id.action_about:
                startActivity(new Intent(this,About.class));
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
    public void result1(View view){
        result.setText(namei + "\n" + positioni + "\n------------------------------------------------\n" + organizationi + "\n" + addressi + "\n" + cityi + "\nMobile: " + phonei + "\nEmail: " + emaili + "\n" + websitei);
    }

    public void result2(View view){
        result.setText(namei + "\n" + positioni + "-" + organizationi + "\n------------------------------------------------ \n" + addressi + "\n" + cityi + "\nMobile: " + phonei + "\nEmail: " + emaili + "\n" +  websitei);
    }




}