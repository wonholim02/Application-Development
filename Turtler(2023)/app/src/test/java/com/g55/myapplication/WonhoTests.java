package com.g55.myapplication;
import org.junit.Test;
import com.g55.myapplication.model.Player;
import com.g55.myapplication.model.Log;
import static org.junit.Assert.*;
import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;

/**
 * Checks if the sprite moves exactly 96 in the right direction when user moves up or down
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class WonhoTests {
    private GameWin gameOverWin;
    private GameWin gameOverWin2;
    private GameWin gameOverWin3;
    @Test
    public void winScreenDisplayScoreDefault() {
        gameOverWin = mock(GameWin.class);
        assertEquals(0, gameOverWin.scoreCheck());
        gameOverWin2 = mock(GameWin.class);
        assertNotEquals(-1, gameOverWin2.scoreCheck());
        gameOverWin3 = mock(GameWin.class);
        assertNotNull(gameOverWin3.scoreCheck());
    }
    @Test
    public void checkLogMovedToEndDeath() {
        Log log1 = new Log();
        Log log2 = new Log();
        log1.update();
        log2.update();
        Player play1 = new Player();
        Player play2 = new Player();
        play1.setX(-1);
        play1.setY(10);
        play1.setWidth(10);
        play2.setX(-1);
        play2.setY(-10);
        play2.setWidth(10);
        assertTrue(GameActivity.checkSideDeath(play1));
        assertTrue(GameActivity.checkSideDeath(play2));
    }
    /*
    These tests will only work on Sprint 4 version - it is not valid on
       current version due to change in class structure.
    public void goBackToOrigin() {
        Player play1 = new Player();
        Player play2 = new Player();
        Player play3 = new Player();
        Player play4 = new Player();
        Player play5 = new Player();
        play1.setX(5.0);
        play1.setY(4.0);
        play2.setX(8.0);
        play2.setY(8.0);
        play3.setX(12.0);
        play3.setY(6.0);
        play4.setX(6.0);
        play4.setY(12.0);
        play5.setX(12.0);
        play5.setY(12.0);
        assertTrue(GameActivity.oceanCheck(play1.getX(), play1.getY()));
        assertTrue(GameActivity.oceanCheck(play2.getX(), play2.getY()));
        assertTrue(GameActivity.oceanCheck(play3.getX(), play3.getY()));
        assertFalse(GameActivity.oceanCheck(play4.getX(), play4.getY()));
        assertFalse(GameActivity.oceanCheck(play5.getX(), play5.getY()));
    }
    @Test
    public void checkIfOcean() {
        Player play1 = new Player();
        Player play2 = new Player();
        Player play3 = new Player();
        GameActivity.goBackPlayer(play1);
        GameActivity.goBackPlayer(play2);
        GameActivity.goBackPlayer(play3);
        assertTrue(play1.getX() == 5);
        assertTrue(play2.getX() == 5);
        assertTrue(play3.getX() == 5);
        assertTrue(play1.getY() == 20);
        assertTrue(play2.getY() == 20);
        assertTrue(play3.getY() == 20);
    } */
    /* These vehicleDifference() and scoreZero() tests are for Sprint 3 version
    @Test
    public void vehicleDifference() {
        int w = 11;
        int yBuffer = 150 * TurtlerApplication.getScreenHeight() / 1920;
        int sizeOfMap = 100 * TurtlerApplication.getScreenWidth() / 1080;
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
        assertFalse(land1.equals(land2));
        assertFalse(land1.equals(land3));
        assertFalse(land1.equals(land4));
        assertFalse(land1.equals(land5));
        assertFalse(land1.equals(land6));
        assertFalse(land1.equals(land7));
        assertFalse(land1.equals(land8));
        assertFalse(land1.equals(land9));
        assertTrue(land1.equals(land1));
    }
    @Test
    public void scoreZero() {
        gameActivity = mock(GameActivity.class);
        assertEquals(0, gameActivity.getCurrScore());
    }
    /* These moveUp() and moveDown() tests will only work on Sprint 2 version - it is not valid on
       current version due to change in class structure.
    @Test
    public void moveUp() {
        assertEquals(96, GameActivity.yUpdate(96));
        assertEquals(96, GameActivity.yUpdate(1000));
        assertEquals(96, GameActivity.yUpdate(960));
        assertEquals(96, GameActivity.yUpdate(480));
        assertEquals(0, GameActivity.yUpdate(0));
    }
    @Test
    public void moveDown() {
        assertEquals(-96, GameActivity.yUpdate(-96));
        assertEquals(-96, GameActivity.yUpdate(-1000));
        assertEquals(-96, GameActivity.yUpdate(-960));
        assertEquals(-96, GameActivity.yUpdate(-480));
        assertEquals(0, GameActivity.yUpdate(0));
    }
     */
}
