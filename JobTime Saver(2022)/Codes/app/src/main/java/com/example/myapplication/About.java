package com.example.myapplication;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class About extends AppCompatActivity {
    ImageView imageView1;
    ImageView imageView2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about);

        getSupportActionBar().hide();

        TextView intro = findViewById(R.id.intro);
        imageView1 = findViewById(R.id.imageView);
        TextView paragraph1 = findViewById(R.id.text1);
       // paragraph1.setText("Jungeun Hwang\nPurdue University\nData Science\nhwang227@purdue.edu");
        Button website1 = findViewById(R.id.website1);
        website1.setText("Website");
        website1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openWeb(v);
            }
        });
        imageView2 = findViewById(R.id.imageView2);
        TextView paragraph2 = findViewById(R.id.text2);
        //paragraph2.setText("Wonho Lim\nGeorgia Tech\nComputer Science\nwlim49@gatech.edu\n");
        Button website2 = findViewById(R.id.website2);
        website2.setText("Website");
        website2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openWeb2(v);
            }
        });

    }
    public void openWeb(View view) {
        Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://junghwang.notion.site/Resume-1b9d96347eb8402abf2df1263f63e551"));
        startActivity(browserIntent);
    }

    public void openWeb2(View view) {
        Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.wonholim.com/"));
        startActivity(browserIntent);
    }
}