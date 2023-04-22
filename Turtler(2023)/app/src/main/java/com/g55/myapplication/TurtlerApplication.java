package com.g55.myapplication;

import android.app.Application;

import com.g55.myapplication.model.Player;

public class TurtlerApplication extends Application {

    /**
     * This class creates a globally accessible PlayerPreferences object.
     */

    private static int screenWidth;
    private static int screenHeight;

    private Player player;

    public Player getPlayer() {
        return player;
    }

    public void setPlayer(Player player) {

        this.player = player;
    }

    public static int getScreenWidth() {
        return screenWidth;
    }

    public static void setScreenWidth(int screenWidth) {
        TurtlerApplication.screenWidth = screenWidth;
    }

    public static int getScreenHeight() {
        return screenHeight;
    }

    public static void setScreenHeight(int screenHeight) {
        TurtlerApplication.screenHeight = screenHeight;
    }
}
