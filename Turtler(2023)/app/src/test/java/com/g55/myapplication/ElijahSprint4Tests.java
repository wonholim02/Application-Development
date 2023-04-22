package com.g55.myapplication;

import static com.g55.myapplication.GameActivity.checkSideDeath;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertThrows;
import static org.junit.Assert.assertTrue;

import com.g55.myapplication.model.Log;
import com.g55.myapplication.model.Player;
import com.g55.myapplication.model.PlayerPreferences;
import com.g55.myapplication.model.Sprite;

import org.junit.Test;

public class ElijahSprint4Tests {
    @Test
    public void testCheckNegativeSideDeath() {
        Player p = new Player();
        p.setX(-1);
        assertTrue(checkSideDeath(p));
    }
    @Test
    public void testPositiveSideDeath() {
        Player p = new Player();
        p.setX(1200);
        assertTrue(checkSideDeath(p));
    }

    @Test
    public void testLogCollision() {
        Player p = new Player();
        p.setX(200);
        p.setY(200);
        p.setHeight(1);
        p.setWidth(1);

        Log l = new Log();
        l.setX(199);
        l.setY(200);
        l.setHeight(1);
        l.setWidth(2);

        assertTrue(Sprite.hasCollided(p, l));
    }

}
