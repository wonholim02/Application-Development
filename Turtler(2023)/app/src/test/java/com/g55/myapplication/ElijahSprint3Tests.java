package com.g55.myapplication;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

import com.g55.myapplication.model.Player;
import com.g55.myapplication.model.PlayerPreferences;

import org.junit.Test;

public class ElijahSprint3Tests {
    @Test
    public void testValidPreferences() {
        Player p = new Player();
        PlayerPreferences pr = p.getPreferences();
        assertFalse(pr.isSetup());
    }
    @Test
    public void testValidStartingLives() {
        Player p = new Player();
        p.setPreferences(new PlayerPreferences(false, "hi", 2));
        assertEquals(p.getStartingLives(), 2);
    }
}
