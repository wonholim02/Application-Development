package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Arrays;

public class TipForInterview extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tip_for_interview);
        if (getSupportActionBar() != null) {
            getSupportActionBar().hide();
        }
        TextView one = findViewById(R.id.textView7);
        TextView two = findViewById(R.id.textView8);
        TextView three = findViewById(R.id.textView9);
        TextView four = findViewById(R.id.textView10);
        TextView five = findViewById(R.id.textView11);
        TextView six = findViewById(R.id.textView12);
        TextView seven = findViewById(R.id.textView13);
        TextView eight = findViewById(R.id.textView14);
        TextView nine = findViewById(R.id.textView15);
        TextView ten = findViewById(R.id.textView16);

        String[] str = new String[10];
        try {
            InputStream inputStream = getAssets().open("tips.txt");
            InputStreamReader reader = new InputStreamReader(inputStream);
            BufferedReader br = new BufferedReader(reader);
            for(int i=0;i<10;i++) {
                str[i] = br.readLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        String result = Arrays.toString(str);
        result = result.substring(1,result.length()-1);
        String[] b = result.split(",");
        one.setText(b[0]);
        two.setText(b[1]);
        three.setText(b[2]);
        four.setText(b[3]);
        five.setText(b[4]);
        six.setText(b[5]);
        seven.setText(b[6]);
        eight.setText(b[7]);
        nine.setText(b[8]);
        ten.setText(b[9]);


    }
}