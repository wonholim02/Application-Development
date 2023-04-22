package com.g55.myapplication;

import static org.junit.Assert.*;
import org.junit.Test;

import com.g55.myapplication.model.LandObstacle;
import com.g55.myapplication.model.Log;
public class ChrisS5Tests {
    @Test
    public void testLogSpeed() {
        Log log1 = new Log(false, 7.77, 5.55, 7.9, 0, 10, 10, R.drawable.log, 1);
        Log log2 = new Log(false, 3.33, 5.55, 15.8, 0, 10, 10, R.drawable.log, 1);
        double dx = Math.abs(log1.getDx()-log2.getDx());
        assertNotEquals(0,dx,0);
    }

    @Test
    public void voidTestUpdate() {
        LandObstacle crab = new LandObstacle(false, 0, 0, 40, 0, 10, 10, R.drawable.crab_1, R.id.test);
        boolean check = crab.update(null);
        assertNotEquals(true,check);
    }
}
