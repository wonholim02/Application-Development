package com.example.vgocproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    private Button button11;
    private Button button22;
    private Button button33;
    private Button button44;
    private Button button55;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        button11 = (Button) findViewById(R.id.webstie);
        button22 = (Button) findViewById(R.id.instagram);
        button33 = (Button) findViewById(R.id.facebook);
        button44 = (Button) findViewById(R.id.twitter);
        button55 = (Button) findViewById(R.id.contact);

        button11.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                open50(v);
            }
        });
        button22.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                open51(v);
            }
        });
        button33.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                open52(v);
            }
        });
        button44.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                open53(v);
            }
        });
        button55.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                open54(v);
            }
        });
    }


    public void open50(View view){
        Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.vgocseattle.com/"));
        startActivity(browserIntent);
    }
    public void open51(View view){
        Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.vgocseattle.com/about.html"));
        startActivity(browserIntent);
    }
    public void open52(View view){
        Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.facebook.com/SeattleVGOC/"));
        startActivity(browserIntent);
    }
    public void open53(View view){
        Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://twitter.com/seattlevgoc?lang=en"));
        startActivity(browserIntent);
    }
    public void open54(View view){
        Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.vgocseattle.com/contact.html"));
        startActivity(browserIntent);
    }
}
