package com.g55.myapplication;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertSame;
import static org.mockito.Mockito.when;
import static org.mockito.Mockito.*;

import android.view.MotionEvent;
import android.widget.TextView;

import com.g55.myapplication.model.LandObstacle;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
//public class JinyoungUnitTest_Sp2{
//        /**
//         * Difficulty check wrong initial.
//         */
//        @Test
//        public void DifficultyCheckWrongInitial(){
//            PlayerPreferences difficultyPlayer = new PlayerPreferences();
//            int difficulty = difficultyPlayer.getDifficulty();
//            assertFalse(difficulty < 4 && difficulty > 0);
//        }
//
//        /**
//         * Difficulty check wrong.
//         */
//        @Test
//        public void DifficultyCheckWrong(){
//            PlayerPreferences difficultyPlayer = new PlayerPreferences
//                    (true, "diff",1,4,1);
//            int difficulty = difficultyPlayer.getDifficulty();
//            assertFalse(difficulty < 4 && difficulty > 0);
//        }
//
//        /**
//         * Difficulty check correct.
//         */
//        @Test
//        public void DifficultyCheckCorrect(){
//            PlayerPreferences difficultyPlayer = new PlayerPreferences
//                    (true, "diff",1,3,1);
//            int difficulty = difficultyPlayer.getDifficulty();
//            assertTrue(difficulty < 4 && difficulty > 0);
//        }
//
//        /**
//         * Character check wrong initial.
//         */
//        @Test
//        public void CharacterCheckWrongInitial(){
//            PlayerPreferences spritePlayer = new PlayerPreferences();
//            int character = spritePlayer.getCharacterSpriteNum();
//            assertFalse(character <= 3 && character >= 1);
//        }
//
//        /**
//         * Character check wrong.
//         */
//        @Test
//        public void CharacterCheckWrong(){
//            PlayerPreferences spritePlayer = new PlayerPreferences
//                    (true, "diff",4,3,1);
//            int character = spritePlayer.getCharacterSpriteNum();
//            assertFalse(character <= 3 && character >= 1);
//        }
//
//        /**
//         * Character check right.
//         */
//        @Test
//        public void CharacterCheckRight(){
//            PlayerPreferences spritePlayer = new PlayerPreferences
//                    (true, "diff",1,3,1);
//            int character = spritePlayer.getCharacterSpriteNum();
//            assertTrue(character <= 3 && character >= 1);
//        }
//}
//
//public class JinyoungUnitTest {
//    @Mock
//    private TurtlerApplication mockApplication;
//    private TextView scoreDisplayMock;
//    private GameActivity gameActivity;
//
//    @Test
//    public void testNoVertical() {
//        // Mock the application to return a fixed screen width
//        if (mockApplication != null) {
//            when(mockApplication.getScreenWidth()).thenReturn(800);
//        }
//
//        // Create a new LandObstacle instance
//        LandObstacle animal = new LandObstacle(false, 0, 0, 5, 0, 10, 10, 1, 1);
//
//        // Call the update() method and check the animal's position
//        animal.update();
//        double initialY = animal.getY();
//
//        animal.update();
//        double newY = animal.getY();
//
//        assertEquals(initialY, newY, 0.01);
//    }
//
//    @Test
//    public void testSameSpriteUsed() {
//        // Create two LandObstacle instances with the same y position and sprite ID
//        LandObstacle obstacle1 = new LandObstacle(false, 0, 100, 0, 0, 10, 10, 1, 1);
//        LandObstacle obstacle2 = new LandObstacle(false, 50, 100, 0, 0, 10, 10, 1, 1);
//
//        // Check that the two obstacles use the same sprite
//        assertSame(obstacle1.getSpriteImageId(), obstacle2.getSpriteImageId());
//    }
//}

public class JinyoungUnitTest {
    @Test
    public void testReset() {
        GameOver gameOver = new GameOver();
        gameOver.goToGame();
        // Check that the activity started successfully
        assertEquals(GameActivity.class.getName(),
                gameOver.getComponentName().getClassName());
    }
    @Test
    public void testExit() {
        GameOver gameOver = new GameOver();
        gameOver.goToMainMenu();
        assertEquals(MainMenu.class.getName(),
                gameOver.getComponentName().getClassName());
    }

}