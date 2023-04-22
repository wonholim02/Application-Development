package com.g55.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.widget.Button;
import android.widget.TextView;

import com.g55.myapplication.model.Player;
import com.g55.myapplication.model.PlayerPreferences;

public class MainMenu extends AppCompatActivity {

    private Button goGameButton;
    private Button goInstructionsButton;
    private Button goPreferencesButton;

    private TextView statusText;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        DisplayMetrics dm = new DisplayMetrics();
        this.getWindowManager().getDefaultDisplay().getMetrics(dm);
        TurtlerApplication.setScreenWidth(dm.widthPixels);
        TurtlerApplication.setScreenHeight(dm.heightPixels);

        goInstructionsButton = findViewById(R.id.instructionsButton);
        goPreferencesButton = findViewById(R.id.preferencesButton);
        goGameButton = findViewById(R.id.goGameButton);
        statusText = findViewById(R.id.statusText);
        if (((TurtlerApplication) this.getApplication()).getPlayer() == null) {
            ((TurtlerApplication) this.getApplication()).setPlayer(
                    new Player());
        }

        //navigation
        goPreferencesButton.setOnClickListener(view -> {
            goToPreferences();
        });
        goInstructionsButton.setOnClickListener(view -> {
            goToInstructions();
        });

        goGameButton.setOnClickListener(view -> {
            //accessing global preferences
            PlayerPreferences fetchedPreferences = ((TurtlerApplication) this.getApplication())
                    .getPlayer().getPreferences();
            System.out.println(fetchedPreferences.toString());
            if (fetchedPreferences.isSetup()) {
                goToGame();
            } else {
                statusText.setText("Complete setup in preferences to play!");
                statusText.setTextColor(Color.rgb(255, 0, 0));
            }
        });

    }

    /**
     * launches game activity
     */
    public void goToGame() {
        Intent intent = new Intent(this, GameActivity.class);
        startActivity(intent);
    }

    /**
     * launches preferences selection activity
     */
    public void goToPreferences() {
        Intent intent = new Intent(this, PreferencesActivity.class);
        startActivity(intent);
    }

    /**
     * launches instructions activity
     */
    public void goToInstructions() {
        Intent intent = new Intent(this, InstructionsActivity.class);
        startActivity(intent);
    }
}