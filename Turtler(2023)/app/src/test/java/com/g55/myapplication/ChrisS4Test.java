package com.g55.myapplication;

import static org.junit.Assert.*;
import org.junit.Test;

import com.g55.myapplication.model.LandObstacle;
import com.g55.myapplication.model.Log;

public class ChrisS4Test {
    @Test
    public void testLogSpeed() {
        Log log1 = new Log(false, 5.55, 5.55, 40.7, 0, 10, 10, R.drawable.log, 1);
        Log log2 = new Log(false, 5.55, 5.55, 30, 0, 10, 10, R.drawable.log, 1);
        double dx = Math.abs(log1.getDx()-log2.getDx());
        assertNotEquals(0,dx,0);
    }

    @Test
    public void testLandObstacleSpeed() {
        LandObstacle crab = new LandObstacle(false, 0, 0, 40, 0, 10, 10, R.drawable.crab_1, R.id.test);
        LandObstacle snake = new LandObstacle(false, 0, 0, 12, 0, 10, 10, R.drawable.snake_1, R.id.test3);
        double dx = Math.abs(crab.getDx()-snake.getDx());
        assertNotEquals(0,dx,0);
    }


}
