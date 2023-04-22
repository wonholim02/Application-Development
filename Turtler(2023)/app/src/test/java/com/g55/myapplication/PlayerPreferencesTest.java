//package com.g55.myapplication;
//
//import static org.junit.Assert.*;
//
//import com.g55.myapplication.model.PlayerPreferences;
//
//import org.junit.Test;
//
///**
// * Written by Chris Cheung
// * Local unit test checking to see if number of lives is between 1 and 3.
// * Local unit test checking to see if "Name" is not accepted as an input
// */
//public class PlayerPreferencesTest {
//
//    @Test
//    public void getLives() {
//        PlayerPreferences playerPreference = new PlayerPreferences(true, "Bob", 2, 2, 1);
//        int numLives = playerPreference.getStartingLives();
//        assertTrue(numLives >= 1 && numLives <=3);
//    }
//    @Test
//    public void getLives1() {
//        PlayerPreferences playerPreference = new PlayerPreferences(true, "Bob", 2, 4, 2);
//        int numLives = playerPreference.getStartingLives();
//        assertTrue(numLives >= 1 && numLiveas <=3);
//    }
//    @Test
//    public void getLives2() {
//        PlayerPreferences playerPreference = new PlayerPreferences(true, "Bob", 2, 0, 3);
//        int numLives = playerPreference.getStartingLives();
//        assertTrue(numLives >= 1 && numLives <=3);
//    }
//    @Test
//    public void getName() {
//        PlayerPreferences playerPreference = new PlayerPreferences(true, "Name", 2, 2, 0);
//        String namePlayer = playerPreference.getName();
//        assertFalse(namePlayer.equals("Name"));
//    }
//    @Test
//    public void getName1() {
//        PlayerPreferences playerPreference = new PlayerPreferences(true, "Chris", 2, 2, 0);
//        String namePlayer = playerPreference.getName();
//        assertFalse(namePlayer.equals("Name"));
//    }
//}