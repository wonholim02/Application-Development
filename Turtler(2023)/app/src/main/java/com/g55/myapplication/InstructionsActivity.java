package com.g55.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

public class InstructionsActivity extends AppCompatActivity {

    private Button returnToMainMenu;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_instructions);
        returnToMainMenu = findViewById(R.id.returnToMainMenu);

        returnToMainMenu.setOnClickListener(view -> {
            goToMainMenu();
        });
    }
    private void goToMainMenu() {
        Intent intent = new Intent(this, MainMenu.class);
        startActivity(intent);
    }
}