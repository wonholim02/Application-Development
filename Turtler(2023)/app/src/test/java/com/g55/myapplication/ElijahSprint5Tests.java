package com.g55.myapplication;

import static com.g55.myapplication.GameActivity.checkSideDeath;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertThrows;
import static org.junit.Assert.assertTrue;

import com.g55.myapplication.model.LandObstacle;
import com.g55.myapplication.model.Log;
import com.g55.myapplication.model.Player;
import com.g55.myapplication.model.PlayerPreferences;
import com.g55.myapplication.model.Sprite;

import org.junit.Test;

public class ElijahSprint5Tests {
    @Test
    public void testSpriteCollision() {
        Sprite s1 = new Player();
        s1.setX(0);
        s1.setY(0);
        s1.setHeight(96);
        s1.setWidth(96);

        Sprite s2 = new Log();
        s2.setX(64);
        s2.setY(64);
        s2.setHeight(96);
        s2.setWidth(96 * 2);

        Sprite s3 = new LandObstacle();
        s3.setX(96);
        s3.setY(96);
        s3.setHeight(96);
        s3.setWidth(96);

        assertTrue(s1.hasCollided(s2));
        assertFalse(s1.hasCollided(s3));
    }

    @Test
    public void testGoalTileChecking() {
        Player s1 = new Player();
        s1.setX(0);
        s1.setY(0);
        s1.setHeight(96);
        s1.setWidth(96);

        assertTrue(GameActivity.checkGoalTileReached(s1));
        s1.setY(1);
        assertFalse(GameActivity.checkGoalTileReached(s1));

    }

}
