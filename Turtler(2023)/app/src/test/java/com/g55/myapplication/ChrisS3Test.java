package com.g55.myapplication;

import static org.junit.Assert.*;

import com.g55.myapplication.model.LandObstacle;


import org.junit.Test;

/**
 * Written by Chris Cheung
 * Local unit test checking to see if setHidden and setX from LandObstacle class works.
 * Local unit test checking to see if getX from LandObstacle class works.
 */
public class ChrisS3Test {

    @Test
    public void setHidden() {
        LandObstacle crab = new LandObstacle(false, 0, (15 * 0) + 0, 10, 0, 0, 0, R.drawable.turtle1, R.id.test);
        crab.setHidden(true);
        assertTrue(crab.getHidden());
    }

    @Test
    public void getX() {
        LandObstacle crab = new LandObstacle(false, 16, (15 * 0) + 0, 10, 0, 0, 0, R.drawable.turtle1, R.id.test);
        double val = crab.getX();
        assertEquals(16,val,0);
    }

    @Test
    public void setX() {
        LandObstacle crab = new LandObstacle(false, 234, (15 * 0) + 0, 10, 0, 0, 0, R.drawable.turtle1, R.id.test);
        crab.setX(76);
        assertEquals(76,crab.getX(),0);
    }
}