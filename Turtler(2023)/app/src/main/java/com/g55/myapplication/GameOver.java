package com.g55.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;
public class GameOver extends AppCompatActivity {
    private TextView score;
    private Button returnToMainMenu;
    private Button restart;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game_over);
        returnToMainMenu = findViewById(R.id.go_home_button);
        returnToMainMenu.setOnClickListener(view -> {
            goToMainMenu();
        });
        restart = findViewById(R.id.restart_button);
        restart.setOnClickListener(view -> {
            goToGame();
        });
        if (optionsDisplayed(restart, returnToMainMenu)) {
            System.out.println("Sucessfully Displayed");
        }
        score = findViewById(R.id.scoreFinal);
        int currScore = getIntent().getIntExtra("currScore", 0);
        System.out.println("currScore: " + currScore);
        score.setText("Your score: " + currScore);
    }
    void goToMainMenu() {
        Intent intent = new Intent(this, MainMenu.class);
        startActivity(intent);
    }
    public void goToGame() {
        Intent intent = new Intent(this, GameActivity.class);
        startActivity(intent);
    }
    public static boolean optionsDisplayed(Button returnMain, Button returnRestart) {
        if (returnMain == null || returnRestart == null) {
            return false;
        }
        return true;
    }
}