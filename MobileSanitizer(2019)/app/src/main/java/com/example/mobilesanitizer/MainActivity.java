package com.example.mobilesanitizer;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.method.LinkMovementMethod;
import android.text.style.ClickableSpan;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private Button button;
    private Button button22;
    private Button button33;
    private Button button44;
    private Button button55;
    private Button button66;
    private Button button77;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button = (Button) findViewById(R.id.button);
        button22 = (Button) findViewById(R.id.button2);
        button33 = (Button) findViewById(R.id.button4);
        button44 = (Button) findViewById(R.id.button5);
        button55 = (Button) findViewById(R.id.button6);
        button77 = (Button) findViewById(R.id.button8);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openVirus();
            }
        });
        button22.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openFoods();
            }
        });
        button33.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openAirQuality();
            }
        });
        button44.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openExercise();
            }
        });
        button55.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openHospital();
            }
        });
        button77.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openWeather();
            }
        });

    }
        public void openVirus() {
            Intent intent = new Intent(this, Virus.class);
            startActivity(intent);
        }
        public void openExercise() {
            Intent intent = new Intent(this, Excercise.class);
            startActivity(intent);
        }
        public void openHospital() {
            Intent intent = new Intent(this, Hospital.class);
            startActivity(intent);
        }
        public void openFoods() {
            Intent intent = new Intent(this, Foods.class);
            startActivity(intent);
        }
        public void openTips() {
            Intent intent = new Intent(this, Tips.class);
            startActivity(intent);
        }
        public void openWeather() {
            Intent intent = new Intent(this, Sunny.class);
            startActivity(intent);
        }
        public void openAirQuality() {
            Intent intent = new Intent(this, AirQuality.class);
            startActivity(intent);
        }
}
