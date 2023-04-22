package com.g55.myapplication;

import org.junit.Test;
import org.mockito.Mock;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;

import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.g55.myapplication.model.LandObstacle;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Tests if at least two types of logs which can be differentiated based on surface areas
 * and two buttons exist in the game win screen.
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class MinyoungTests {
    @Test
    public void logsAreaCheck() {
        int yBuffer = 150 * TurtlerApplication.getScreenHeight() / 1920;
        int sizeOfMap = 100 * TurtlerApplication.getScreenWidth() / 1080;
        Log log1 = new Log(false, 30, (15 * sizeOfMap) + yBuffer, 10, 20,
                sizeOfMap, sizeOfMap, R.drawable.log, R.id.log1);
        Log log2 = new Log(false, 15, (12 * sizeOfMap) + yBuffer, 10, 20,
                sizeOfMap, sizeOfMap, R.drawable.log, R.id.log2);
        assertNotEquals(log1, log2);
        assertEquals(log1, log1);
        assertEquals(log2, log2);
    }
    @Test
    public void isButtonExist() {
        Context mockContext = Mockito.mock(Context.class);
        Button returnToPrefMenu = new Button(mockContext);
        returnToPrefMenu.setText("Return to Preferences");
        Button terminate = new Button(mockContext);
        terminate.setText("Terminate");
        assertTrue(GameWin.optionsDisplayed(returnToPrefMenu, terminate));
    }

    /* These unit tests are for sprint 2. (method modified)
    @Test
    public void moveRight() {
       assertEquals(96, GameActivity.xUpdate(96));
       assertEquals(96, GameActivity.xUpdate(1000));
       assertEquals(96, GameActivity.xUpdate(350));
       assertEquals(96, GameActivity.xUpdate(700));
       assertEquals(0, GameActivity.xUpdate(0));
   }
   @Test
   public void moveLeft() {
       assertEquals(-96, GameActivity.xUpdate(-96));
       assertEquals(-96, GameActivity.xUpdate(-1000));
       assertEquals(-96, GameActivity.xUpdate(-350));
       assertEquals(-96, GameActivity.xUpdate(-700));
       assertEquals(0, GameActivity.xUpdate(0));
    }
     */
    /* These unit tests are for sprint 3.
    @Test
    public void speedCheck () {
        int w = (int) (Math.random() * 10);
        int sizeOfMap = (int) (Math.random() * 20);
        int yBuffer = (int) (Math.random() * 20);
        LandObstacle land1 = new LandObstacle(false, 0, (15 * sizeOfMap) + yBuffer, 10, 0, sizeOfMap, sizeOfMap, R.drawable.turtle1, R.id.test);
        LandObstacle land2 = new LandObstacle(false,0,(13 * sizeOfMap) + yBuffer, -7, 0, sizeOfMap, sizeOfMap, R.drawable.turtle2, R.id.test2);
        LandObstacle land3 = new LandObstacle(false, 0, (11 * sizeOfMap) + yBuffer, 12, 0, sizeOfMap, sizeOfMap, R.drawable.turtle3, R.id.test3);
        boolean  sameSpeed = false;
        ArrayList<LandObstacle> objects = new ArrayList<>();
        objects.add(land1);
        objects.add(land2);
        objects.add(land3);
        for (int i = 0; i < objects.size(); i++) {
            for (int j = i + 1; j < objects.size(); j++) {
                if (objects.get(i).getDx() == objects.get(j).getDx() && objects.get(i).getDy() == objects.get(j).getDy()) {
                    sameSpeed = true;
                }
            }
        }
        assertFalse(sameSpeed);
    }
    @Test
    public void moreThanThreeDifferentVehicles() {
        int w = (int) (Math.random() * 10);
        int sizeOfMap = (int) (Math.random() * 20);
        int yBuffer = (int) (Math.random() * 20);
        LandObstacle land1 = new LandObstacle(false, 0, (15 * sizeOfMap) + yBuffer, 10, 0, sizeOfMap, sizeOfMap, R.drawable.turtle1, R.id.test);
        LandObstacle land2 = new LandObstacle(false,0,(13 * sizeOfMap) + yBuffer, -7, 0, sizeOfMap, sizeOfMap, R.drawable.turtle2, R.id.test2);
        LandObstacle land3 = new LandObstacle(false, 0, (11 * sizeOfMap) + yBuffer, 12, 0, sizeOfMap, sizeOfMap, R.drawable.turtle3, R.id.test3);
        LandObstacle land4 = new LandObstacle(false, (w/3)*sizeOfMap, (15 * sizeOfMap) + yBuffer, 10, 0, sizeOfMap, sizeOfMap, R.drawable.turtle1, R.id.test);
        LandObstacle land5 = new LandObstacle(false,(w/3)*sizeOfMap,(13 * sizeOfMap) + yBuffer, -7, 0, sizeOfMap, sizeOfMap, R.drawable.turtle2, R.id.test2);
        LandObstacle land6 = new LandObstacle(false, (w/3)*sizeOfMap, (11 * sizeOfMap) + yBuffer, 12, 0, sizeOfMap, sizeOfMap, R.drawable.turtle3, R.id.test3);
        LandObstacle land7 = new LandObstacle(false, ((2*w)/3)*sizeOfMap, (15 * sizeOfMap) + yBuffer, 10, 0, sizeOfMap, sizeOfMap, R.drawable.turtle1, R.id.test);
        LandObstacle land8 = new LandObstacle(false,((2*w)/3)*sizeOfMap,(13 * sizeOfMap) + yBuffer, -7, 0, sizeOfMap, sizeOfMap, R.drawable.turtle2, R.id.test2);
        LandObstacle land9 = new LandObstacle(false, ((2*w)/3)*sizeOfMap, (11 * sizeOfMap) + yBuffer, 12, 0, sizeOfMap, sizeOfMap, R.drawable.turtle3, R.id.test3);
        LandObstacle land10 = new LandObstacle(false, 0, (15 * sizeOfMap) + yBuffer, 10, 0, sizeOfMap, sizeOfMap, R.drawable.turtle1, R.id.test);
        ArrayList<LandObstacle> landObstacles = new ArrayList<>();
        landObstacles.add(land1);
        landObstacles.add(land2);
        landObstacles.add(land3);
        landObstacles.add(land4);
        landObstacles.add(land5);
        landObstacles.add(land6);
        landObstacles.add(land7);
        landObstacles.add(land8);
        landObstacles.add(land9);
        landObstacles.add(land10);
        ArrayList<LandObstacle> landObstaclesReverse = new ArrayList<>();
        landObstaclesReverse.add(land10);
        landObstaclesReverse.add(land9);
        landObstaclesReverse.add(land8);
        landObstaclesReverse.add(land7);
        landObstaclesReverse.add(land6);
        landObstaclesReverse.add(land5);
        landObstaclesReverse.add(land4);
        landObstaclesReverse.add(land3);
        landObstaclesReverse.add(land2);
        landObstaclesReverse.add(land1);
        int count = 0;
        for (int i = 0; i < landObstacles.size(); i++) {
            if (landObstaclesReverse.indexOf(land1) - 9 == landObstacles.indexOf(land1)) {
                count++;
            }
        }
        assertTrue(count > 3);
    }
     */
    /* These tests are for sprint 4.
    @Test
    public void collisionImgValidity() {
        ImageView img1 = mock(ImageView.class);
        assertNotNull(img1);
        assertEquals(true, LandObstacle.checkCollisionValidity(img1));
        ImageView img2 = null;
        assertEquals(false, LandObstacle.checkCollisionValidity(img2));
        assertNull(img2);
        ImageView img3 = mock(ImageView.class);
        assertNotNull(img3);
        assertEquals(true, LandObstacle.checkCollisionValidity(img3));
        img3 = null;
        assertEquals(false, LandObstacle.checkCollisionValidity(img3));
    }
    @Test
    public void goBackFunctionValidity() {
        // b1 not null, b2 null
        Button b1 = mock(Button.class);
        Button b2 = null;
        assertEquals(false, GameOver.optionsDisplayed(b1, b2));

        // b3 not null, b4 not null
        Button b3 = mock(Button.class);
        assertNotNull(b3);
        Button b4 = mock(Button.class);
        assertNotNull(b4);
        assertEquals(true, GameOver.optionsDisplayed(b3, b4));

        // b5 null, b6 null
        Button b5 = null;
        Button b6 = null;
        assertEquals(false, GameOver.optionsDisplayed(b5, b6));
    }
    */
}
