package com.g55.myapplication.model;

public class PlayerPreferences {

    /**
     * Model class of the global playerPreferences
     */

    private boolean setup;
    private String name;
    private int difficulty;

    public PlayerPreferences() {
        setup = false;
        name = "";
        difficulty = -1;
    }

    public PlayerPreferences(boolean setup, String name, int difficulty) {
        this.setup = setup;
        this.name = name;
        this.difficulty = difficulty;
    }

    public boolean isSetup() {
        setup = (name != "" && difficulty != -1);
        return setup;
    }

    public void setSetup(boolean setup) {
        this.setup = setup;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getDifficulty() {
        return difficulty;
    }
    public void setDifficulty(int difficulty) {
        this.difficulty = difficulty;
    }

    //    @Override
    //    public String toString() {
    //        return "PlayerPreferences{" +
    //                "setup=" + setup +
    //                ", name='" + name + '\'' +
    //                ", difficulty=" + difficulty +
    //                '}';
    //    }

    //        return "checkstyle made me comment this out go to PlayerPreference and uncomment.";
}