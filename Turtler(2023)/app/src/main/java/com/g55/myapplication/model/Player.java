package com.g55.myapplication.model;

import com.g55.myapplication.R;

public class Player extends Sprite {

    private PlayerPreferences preferences;
    private int currLives;
    private int startingLives;

    public Player(boolean hidden, double x, double y, double dx, double dy,
                  int width, int height, int spriteImageId, int xmlElementId) {
        super(hidden, x, y, dx, dy, width, height, spriteImageId, xmlElementId);
    }

    public Player() {
        super();
        this.preferences = new PlayerPreferences();
        //default sprite to prevent errors
        setSpriteImageId(R.drawable.turtle1);
    }

    @Override
    public void update() {
        // TO DO: Animation frames here
        return;
    }

    public int getCurrLives() {
        return currLives;
    }

    public void setCurrLives(int currLives) {
        this.currLives = currLives;
    }

    public int getStartingLives() {
        startingLives = 4 - preferences.getDifficulty();
        return startingLives;
    }

    public void setStartingLives(int startingLives) {
        this.startingLives = startingLives;
    }

    public PlayerPreferences getPreferences() {
        return preferences;
    }

    public void setPreferences(PlayerPreferences preferences) {
        this.preferences = preferences;
    }
}
