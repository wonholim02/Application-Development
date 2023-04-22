package com.g55.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.SeekBar;
import android.widget.TextView;

import com.g55.myapplication.model.Player;
import com.g55.myapplication.model.PlayerPreferences;


public class PreferencesActivity extends AppCompatActivity {

    private Button saveAndReturnToMain;

    private PlayerPreferences localPreferencesCopy;

    private int difficulty;
    private String name;

    private ImageButton selectSprite1;
    private ImageButton selectSprite2;
    private ImageButton selectSprite3;
    private EditText textEntryName;
    private SeekBar difficultySelector;
    private TextView spriteSelectionDisplay;
    private TextView difficultySelectionDisplay;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_preferences);
        //find elements
        saveAndReturnToMain = findViewById(R.id.savePreferencesAndReturn);
        selectSprite1 = findViewById(R.id.selectSprite1);
        selectSprite2 = findViewById(R.id.selectSprite2);
        selectSprite3 = findViewById(R.id.selectSprite3);
        textEntryName = findViewById(R.id.textEntryName);
        spriteSelectionDisplay = findViewById(R.id.selectSpriteDisplay);
        difficultySelectionDisplay = findViewById(R.id.selectDifficultyDisplay);
        difficultySelector = findViewById(R.id.difficultyInputBar);
        //if version allows set min/max
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            difficultySelector.setMin(1);
            difficultySelector.setMax(3);
        }
        difficultySelector.setProgress(1);
        difficulty = 1;
        //fetch global preferences
        Player localPlayerCopy = ((TurtlerApplication) this.getApplication()).getPlayer();
        localPreferencesCopy = localPlayerCopy.getPreferences();

        // difficulty listener
        difficultySelector.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                difficulty = i;
                difficultySelectionDisplay.setText(Integer.toString(i));
            }
            @Override
            public void onStartTrackingTouch(SeekBar seekBar) { }
            @Override
            public void onStopTrackingTouch(SeekBar seekBar) { }
        });
        //sprite selection listeners
        selectSprite1.setOnClickListener(view -> {
            spriteSelectionDisplay.setText("Green shell");
            localPlayerCopy.setSpriteImageId(R.drawable.turtle1);
        });
        selectSprite2.setOnClickListener(view -> {
            spriteSelectionDisplay.setText("Purple shell");
            localPlayerCopy.setSpriteImageId(R.drawable.turtle2);
        });
        selectSprite3.setOnClickListener(view -> {
            spriteSelectionDisplay.setText("Red shell");
            localPlayerCopy.setSpriteImageId(R.drawable.turtle3);
        });
        //save and return action
        saveAndReturnToMain.setOnClickListener((view -> {
            System.out.println(difficulty + "__" + textEntryName.getText().toString());
            name = textEntryName.getText().toString();
            if (!nameValid(name)) {
                textEntryName.setError("Please enter a valid name! :)");
                return;
            }
            localPreferencesCopy.setName(name);
            localPreferencesCopy.setDifficulty(difficulty);
            ((TurtlerApplication) this.getApplication()).setPlayer(localPlayerCopy);

            goToMainMenu();
        }));

    }

    protected static boolean nameValid(String name) {
        if (name.equals("Name")) {
            return false;
        }
        boolean nonwhitespacefound = false;
        for (char c : name.toCharArray()) {
            if (!Character.isWhitespace(c)) {
                nonwhitespacefound = true;
            }
        }
        return nonwhitespacefound;
    }

    /**
     * launches main menu activity
     */
    private void goToMainMenu() {
        Intent intent = new Intent(this, MainMenu.class);
        startActivity(intent);
    }
}