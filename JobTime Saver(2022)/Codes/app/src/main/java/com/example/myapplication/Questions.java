package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class Questions extends AppCompatActivity {
    Button setButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_questions);
        if (getSupportActionBar() != null) {
            getSupportActionBar().hide();
        }
        setButton = findViewById(R.id.button);
        setButton.setText("start!");
        TextView first = findViewById(R.id.textView);
        TextView second = findViewById(R.id.textView2);
        TextView third = findViewById(R.id.textView3);
        TextView fourth = findViewById(R.id.textView4);
        TextView fifth = findViewById(R.id.textView5);

        setButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String[] string = new String[20];
                try {
                    InputStream inputStream = getAssets().open("questions.txt");
                    InputStreamReader reader = new InputStreamReader(inputStream);
                    BufferedReader br = new BufferedReader(reader);
                    for(int i=0;i<20;i++) {
                        string[i] = br.readLine();
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
                //txt.setText(Arrays.toString(string));
                Random rand = new Random();
                List<String> givenList = Arrays.asList(string);
                int numberOfElements = 5;
                String[] elements = new String[5];
                //  int k = 0;
                for(int n =0;n<numberOfElements;n++) {
                    int randomIndex = rand.nextInt(givenList.size());
                    String randomElement = givenList.get(randomIndex);
                    elements[n] = randomElement;
                    //      k+=1;
                }
                String a = Arrays.toString(elements);
                a = a.substring(1,a.length()-1);
                first.setText("1. "+(a.split(",")[0]));
                second.setText("5. "+(a.split(",")[1]));
                third.setText("4. "+(a.split(",")[2]));
                fourth.setText("3. "+(a.split(",")[3]));
                fifth.setText("2. "+(a.split(",")[4]));
            }
        });


    }
}

