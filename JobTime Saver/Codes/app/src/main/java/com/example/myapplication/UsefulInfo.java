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

public class UsefulInfo extends AppCompatActivity {
    BottomNavigationView bottomNavigationView;
    private Button button22;
    private Button button33;
    private Button button44;
    private Button button55;
    private Button button66;
    private Button button77;
    private Button button88;
    private Button button99;
    private Button button100;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_useful_info);

        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setDisplayShowTitleEnabled(true);
        //getSupportActionBar().setIcon(R.drawable.logo);
        ActionBar actionBar;
        actionBar = getSupportActionBar();
        ColorDrawable colorDrawable
                = new ColorDrawable(Color.parseColor("#009688"));
        actionBar.setBackgroundDrawable(colorDrawable);

        bottomNavigationView = findViewById(R.id.bottom_navigator);
        bottomNavigationView.setSelectedItemId(R.id.usefulinfo);
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.coverletter:
                        startActivity(new Intent(getApplicationContext(), MainActivity.class));
                        overridePendingTransition(0, 0);
                        return true;
                    case R.id.elecsignature:
                        startActivity(new Intent(getApplicationContext(), ElecSign.class));
                        overridePendingTransition(0, 0);
                        return true;
                    case R.id.usefulinfo:
                        return true;
                    case R.id.tips:
                        startActivity(new Intent(getApplicationContext(), Tips.class));
                        overridePendingTransition(0, 0);
                        return true;
                }
                return false;
            }
        });

        button22 = (Button) findViewById(R.id.button2);
        button33 = (Button) findViewById(R.id.button3);
        button44 = (Button) findViewById(R.id.button4);
        button55 = (Button) findViewById(R.id.button5);
        button66 = (Button) findViewById(R.id.button6);
        button77 = (Button) findViewById(R.id.button7);
        button88 = (Button) findViewById(R.id.button8);
        button99 = (Button) findViewById(R.id.button9);
        button100 = (Button) findViewById(R.id.button10);

        button22.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                open2(v);
            }
        });
        button33.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                open3(v);
            }
        });
        button44.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                open4(v);
            }
        });
        button55.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                open5(v);
            }
        });
        button66.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                open6(v);
            }
        });
        button77.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                open7(v);
            }
        });
        button88.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                open8(v);
            }
        });
        button99.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                open9(v);
            }
        });
        button100.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                open10(v);
            }
        });

    }
    public void open2(View view){
        Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.linkedin.com"));
        startActivity(browserIntent);
    }

    public void open3(View view){
        Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.indeed.com"));
        startActivity(browserIntent);
    }

    public void open4(View view){
        Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.glassdoor.com"));
        startActivity(browserIntent);
    }
    public void open5(View view){
        Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.hackerrank.com/"));
        startActivity(browserIntent);
    }
    public void open6(View view){
        Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.careerbuilder.com/"));
        startActivity(browserIntent);
    }
    public void open7(View view){
        Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://youtu.be/Si4GLeQoqLA"));
        startActivity(browserIntent);
    }

    public void open8(View view){
        Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://youtu.be/BYUy1yvjHxE"));
        startActivity(browserIntent);
    }

    public void open9(View view){
        Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://youtu.be/HG68Ymazo18w"));
        startActivity(browserIntent);
    }
    public void open10(View view){
        Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://youtu.be/5v-wyR5emRw"));
        startActivity(browserIntent);
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

}