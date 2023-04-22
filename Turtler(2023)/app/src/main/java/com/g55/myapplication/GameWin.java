package com.g55.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;
public class GameWin extends AppCompatActivity {
    private TextView score;
    private Button returnToPrefMenu;
    private Button terminate;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game_win);

        returnToPrefMenu = findViewById(R.id.win_restart_button);
        returnToPrefMenu.setOnClickListener(view -> {
            goToPreferences();
        });

        terminate = findViewById(R.id.exit_button);
        terminate.setOnClickListener(view -> {
            closeApp();
            finish();
            System.exit(0);
            return;
        });

        if (optionsDisplayed(terminate, returnToPrefMenu)) {
            System.out.println("Sucessfully Displayed!!!");
        }
        score = findViewById(R.id.score_win_Final);
        int currScore = getIntent().getIntExtra("currScore", 0);
        System.out.println("currScore: " + currScore);
        score.setText("Your score: " + currScore);
    }

    private void closeApp() {
        Intent intent = new Intent(Intent.ACTION_MAIN);
        intent.addCategory(Intent.CATEGORY_HOME);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
        startActivity(intent);
    }

    public void goToPreferences() {
        Intent intent = new Intent(this, PreferencesActivity.class);
        startActivity(intent);
    }

    public int scoreCheck() {
        String src = score.toString();
        if (Integer.parseInt(src) < 0 || Integer.parseInt(src) > 1000) {
            return -1;
        } else {
            return Integer.parseInt(src);
        }
    }

    public static boolean optionsDisplayed(Button returnMain, Button returnRestart) {
        if (returnMain == null || returnRestart == null) {
            return false;
        }
        return true;
    }
}