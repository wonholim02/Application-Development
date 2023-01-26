package com.example.myapplication;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.lang.reflect.Array;

public class Feedback extends AppCompatActivity {
    private String TO;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_feedback);
        getSupportActionBar().hide();

        Button startBtn = (Button) findViewById(R.id.sendEmail);
        TextView to = findViewById(R.id.edit_text_to);
        TO = "jobtimesaver@gmail.com";
        //String[] CC = {"junghwang31@gmail.com"};
        to.setText(TO);

        startBtn.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                sendEmail();
            }
        });
    }
    @SuppressLint("IntentReset")
    protected void sendEmail() {
        Log.i("Send email", "");
        EditText mEditTextSubject = findViewById(R.id.edit_text_subject);
        EditText mEditTextMessage = findViewById(R.id.edit_text_text_message);
        String subject = mEditTextSubject.getText().toString();
        String message = mEditTextMessage.getText().toString();

        Intent emailIntent = new Intent(Intent.ACTION_SEND);

        emailIntent.setData(Uri.parse("mailto:"));
        emailIntent.setType("text/plain");
        emailIntent.putExtra(Intent.EXTRA_EMAIL, TO);
        //emailIntent.putExtra(Intent.EXTRA_CC, CC);
        emailIntent.putExtra(Intent.EXTRA_SUBJECT, subject);
        emailIntent.putExtra(Intent.EXTRA_TEXT, message);

        try {
            startActivity(Intent.createChooser(emailIntent, "Send mail..."));
            finish();
            Log.i("Finished email...", "");
        } catch (android.content.ActivityNotFoundException ex) {
            Toast.makeText(Feedback.this, "There is no email client installed.", Toast.LENGTH_SHORT).show();
        }
    }
}

