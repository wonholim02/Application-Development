package com.example.mobilesanitizer;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;

public class AirQuality extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_air_quality);
    }
    public void open10(View view){
        Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://aqicn.org/map/world/"));
        startActivity(browserIntent);
    }
    public void open11(View view){
        Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.who.int/health-topics/air-pollution#tab=tab_1"));
        startActivity(browserIntent);
    }
    public void open12(View view){
        Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.amazon.com/face-masks/s?k=face+masks"));
        startActivity(browserIntent);
    }
}
