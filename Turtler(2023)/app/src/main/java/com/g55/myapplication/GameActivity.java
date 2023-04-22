package com.g55.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewTreeObserver;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Button;

import com.g55.myapplication.model.LandObstacle;
import com.g55.myapplication.model.Log;
import com.g55.myapplication.model.Player;
import com.g55.myapplication.model.PlayerPreferences;
import com.g55.myapplication.model.Sprite;

import java.util.Timer;
import java.util.TimerTask;


public class GameActivity extends AppCompatActivity {

    private boolean collide = false;
    private ImageView playerSpriteDisplay;
    private TextView nameDisplay;
    private TextView difficultyDisplay;
    private TextView liveDisplay;
    private TextView scoreDisplay;
    private Button returnMain;
    static final int MIN_DISTANCE = 150;
    private int currLives;
    private int currScore = 0;
    private PlayerPreferences localPrefCopy;
    private static int sizeOfMap = 100 * TurtlerApplication.getScreenWidth() / 1080;
    private int h = 17;
    private static int w = 11;
    private int minPlayerY = h * sizeOfMap;

    private LandObstacle[] landObstacles = new LandObstacle[12];
    private Log[] logs = new Log[24];
    private Player player;


    private Handler handler = new Handler();
    private Timer timer = new Timer();
    private int yBuffer = 150 * TurtlerApplication.getScreenHeight() / 1920;

    private float x1;
    private float x2;
    private float y1;
    private float y2;

    private int[] logIDs = {R.id.log1, R.id.log2, R.id.log3, R.id.log4, R.id.log5, R.id.log6,
        R.id.log7, R.id.log8, R.id.log9, R.id.log10, R.id.log11, R.id.log12, R.id.log13,
        R.id.log14, R.id.log15, R.id.log16, R.id.log17, R.id.log18, R.id.log19, R.id.log20,
        R.id.log21};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_game);

        //fetch player & prefs
        player = ((TurtlerApplication) this.getApplication()).getPlayer();
        localPrefCopy = player.getPreferences();
        System.out.println(localPrefCopy.toString());
        player.setCurrLives(player.getStartingLives());
        currScore = 0;
        currLives = player.getStartingLives();


        //find elements
        scoreDisplay = findViewById(R.id.scoreDisplay);
        playerSpriteDisplay = findViewById(R.id.spriteDisplay);
        nameDisplay = findViewById(R.id.nameDisplay);
        difficultyDisplay = findViewById(R.id.difficultyDisplay);
        liveDisplay = findViewById(R.id.livesDisplay);
        returnMain = findViewById(R.id.returnMain);

        //set player sprite
        playerSpriteDisplay.setImageDrawable(getDrawable(player.getSpriteImageId()));

        // set displays
        nameDisplay.setText("Name: " + localPrefCopy.getName());
        difficultyDisplay.setText("Difficulty: " + localPrefCopy.getDifficulty());
        liveDisplay.setText(" " + currLives);
        returnMain.setOnClickListener((view -> {
            goToMainMenu();
        }));

        playerSpriteDisplay.getViewTreeObserver().addOnGlobalLayoutListener(
                new ViewTreeObserver.OnGlobalLayoutListener() {
                    @Override
                    public void onGlobalLayout() {
                        playerSpriteDisplay.getViewTreeObserver().
                                removeOnGlobalLayoutListener(this);
                        resetPlayer();
                    }
            });

        init();

        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                update();
            }
        }, 0, 60);
    }

    private void resetPlayer() {
        player.setX((int) (w / 2) * sizeOfMap);
        player.setY(yBuffer + sizeOfMap * (h - 1));
        playerSpriteDisplay.setX((float) player.getX());
        playerSpriteDisplay.setY((float) player.getY());
        minPlayerY = h * sizeOfMap;
    }

    private void init() {
        initLandObstacles();
        initLogs();
        initPlayer();
    }

    private void update() {
        if (!this.collide) {
            for (LandObstacle l : landObstacles) {
                if (l != null) {
                    boolean collisionCheck = l.update(playerSpriteDisplay);
                    if (collisionCheck) {
                        die();
                    }
                    if (l.isHidden()) {
                        findViewById(l.getXmlElementId()).setVisibility(View.INVISIBLE);
                    } else {
                        findViewById(l.getXmlElementId()).setX((int) l.getX());
                    }
                }
            }
        }

        boolean logCollisionOccurred = false;

        for (Log l : logs) {
            if (l != null) {
                l.update();
                if (l.hasCollided(player)) {
                    if (!logCollisionOccurred) {
                        player.setX(player.getX() + l.getDx());
                        findViewById(l.getXmlElementId()).setBackgroundColor(Color.YELLOW);
                        logCollisionOccurred = true;
                        System.out.println("collision occurred");
                    }

                } else {
                    findViewById(l.getXmlElementId()).setBackgroundColor(Color.RED);
                }
                if (l.isHidden()) {
                    findViewById(l.getXmlElementId()).setVisibility(View.INVISIBLE);
                } else {
                    findViewById(l.getXmlElementId()).setX((int) l.getX());
                }
            }
        }

        if (player.getY() >= yBuffer + (sizeOfMap * 1)
                && player.getY() <= yBuffer + (sizeOfMap * 7)
                && !logCollisionOccurred) {
            System.out.println("death by water detected");
            // currScore /= 2; removed 4/11 because it made no sense, losing a life is bad enough
            die();
        }

        if (checkSideDeath(player)) {
            System.out.println("death by side exit detected");
            // currScore /= 2; removed 4/11 because it made no sense, losing a life is bad enough
            die();
        }

        if (checkGoalTileReached(player)) {
            System.out.println("reached goal tile detected");
            currScore += 30;
            Intent intent = new Intent(this, GameWin.class);
            intent.putExtra("currScore", currScore);
            startActivity(intent);
            finish();
            resetPlayer();
        }

        playerSpriteDisplay.setX((float) player.getX());
        playerSpriteDisplay.setY((float) player.getY());

        updateHUD();
    }

    private void updateHUD() {
        updateTextViewOnUIThread(scoreDisplay, " " + currScore);
        updateTextViewOnUIThread(liveDisplay, " " + currLives);
    }

    public static boolean checkSideDeath(Player player) {
        return (player.getX() < 0 || player.getX() + player.getWidth() > sizeOfMap * w);
    }

    public static boolean checkGoalTileReached(Player player) {
        return (player.getY() == 150 * TurtlerApplication.getScreenHeight() / 1920);
    }

    private void die() {
        currLives--;
        if (currLives == 0) {
            this.collide = true;
            Intent intent = new Intent(this, GameOver.class);
            intent.putExtra("currScore", currScore);
            startActivity(intent);
            finish();
        } else {
            resetPlayer();
        }
    }

    private void initLandObstacles() {
        landObstacles[0] = new LandObstacle(false, 0,
                (15 * sizeOfMap) + yBuffer, 4, 0, sizeOfMap, sizeOfMap,
                R.drawable.crab_1, R.id.test);
        landObstacles[1] = new LandObstacle(false, 0,
                (13 * sizeOfMap) + yBuffer, -7, 0, sizeOfMap, sizeOfMap,
                R.drawable.shell_1, R.id.test2);
        landObstacles[2] = new LandObstacle(false, 0,
                (11 * sizeOfMap) + yBuffer, 12, 0, sizeOfMap, sizeOfMap,
                R.drawable.snake_1, R.id.test3);
        landObstacles[3] = new LandObstacle(false, (w / 3) * sizeOfMap,
                (15 * sizeOfMap) + yBuffer, 4, 0, sizeOfMap, sizeOfMap,
                R.drawable.crab_1, R.id.test12);
        landObstacles[4] = new LandObstacle(false, (w / 3) * sizeOfMap,
                (13 * sizeOfMap) + yBuffer, -7, 0, sizeOfMap, sizeOfMap,
                R.drawable.shell_1, R.id.test22);
        landObstacles[5] = new LandObstacle(false, (w / 3) * sizeOfMap,
                (11 * sizeOfMap) + yBuffer, 12, 0, sizeOfMap, sizeOfMap,
                R.drawable.snake_1, R.id.test32);
        landObstacles[6] = new LandObstacle(false, ((2 * w) / 3) * sizeOfMap,
                (15 * sizeOfMap) + yBuffer, 4, 0, sizeOfMap, sizeOfMap,
                R.drawable.crab_1, R.id.test13);
        landObstacles[7] = new LandObstacle(false, ((2 * w) / 3) * sizeOfMap,
                (13 * sizeOfMap) + yBuffer, -7, 0, sizeOfMap, sizeOfMap,
                R.drawable.shell_1, R.id.test23);
        landObstacles[8] = new LandObstacle(false, ((2 * w) / 3) * sizeOfMap,
                (11 * sizeOfMap) + yBuffer, 12, 0, sizeOfMap, sizeOfMap,
                R.drawable.snake_1, R.id.test33);
        landObstacles[9] = new LandObstacle(false, ((2 * w) / 6) * sizeOfMap,
                (2 * sizeOfMap) + yBuffer, 8, 0, sizeOfMap, sizeOfMap,
                R.drawable.sharkfin, R.id.test44);
        landObstacles[10] = new LandObstacle(false, ((2 * w) / 6) * sizeOfMap,
                (4 * sizeOfMap) + yBuffer, -7, 0, sizeOfMap, sizeOfMap,
                R.drawable.sharkfin, R.id.test55);
        landObstacles[11] = new LandObstacle(false, ((2 * w) / 6) * sizeOfMap,
                (6 * sizeOfMap) + yBuffer, 4, 0, sizeOfMap, sizeOfMap,
                R.drawable.sharkfin, R.id.test66);

        for (LandObstacle l : landObstacles) {
            if (l != null) {
                ((ImageView) findViewById(l.getXmlElementId())).
                        setImageDrawable(getDrawable(l.getSpriteImageId()));
                findViewById(l.getXmlElementId()).setX((float) l.getX());
                findViewById(l.getXmlElementId()).setY((float) l.getY());
                ((ImageView) findViewById(l.getXmlElementId())).setMaxHeight(l.getHeight());
                findViewById(l.getXmlElementId()).setMinimumHeight(l.getHeight());
                ((ImageView) findViewById(l.getXmlElementId())).setMaxWidth(l.getHeight());
                findViewById(l.getXmlElementId()).setMinimumWidth(l.getWidth());
            }
        }
    }

    private void initLogs() {
        for (int row = 1; row < 8; row++) {
            int offset = (int) (Math.random() * 3 * sizeOfMap);
            int rowSpeed = (int) ((Math.random() - .5) * 30);
            for (int col = 0; col < 3; col++) {
                int i = ((row - 1) * 3) + col;
                System.out.println(i);
                logs[i] = new Log(false,
                        (int) (col * 3.5 * sizeOfMap) + offset,
                        (int) row * sizeOfMap + yBuffer,
                        rowSpeed,
                        (int) 0,
                        sizeOfMap * 3,
                        sizeOfMap,
                        R.drawable.log,
                        logIDs[i]);
            }
        }

        for (Log l : logs) {
            if (l != null) {
                ((ImageView) findViewById(l.getXmlElementId())).
                        setImageDrawable(getDrawable(l.getSpriteImageId()));
                findViewById(l.getXmlElementId()).setX((float) l.getX());
                findViewById(l.getXmlElementId()).setY((float) l.getY());
                ((ImageView) findViewById(l.getXmlElementId())).setMaxHeight(l.getHeight());
                findViewById(l.getXmlElementId()).setMinimumHeight(l.getHeight());
                ((ImageView) findViewById(l.getXmlElementId())).setMaxWidth(l.getHeight());
                findViewById(l.getXmlElementId()).setMinimumWidth(l.getWidth());
            }
        }
    }

    private void initPlayer() {
        player.setWidth(sizeOfMap);
        player.setHeight(sizeOfMap);
        playerSpriteDisplay.setBackgroundColor(Color.GREEN);
        playerSpriteDisplay.bringToFront();
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {

        switch (event.getAction()) {
        case MotionEvent.ACTION_DOWN:
            x1 = event.getX();
            y1 = event.getY();
            break;
        case MotionEvent.ACTION_UP:
            x2 = event.getX();
            y2 = event.getY();
            float deltaX = x2 - x1;
            float deltaY = y2 - y1;
            if (Math.abs(deltaX) > MIN_DISTANCE) {
                player.setX(player.getX() + ((deltaX > 0) ? sizeOfMap : -sizeOfMap));
            } else if (Math.abs(deltaY) > MIN_DISTANCE) {
                player.setY(player.getY() + ((deltaY > 0) ? sizeOfMap : -sizeOfMap));

                //if swiped up
                if (deltaY < 0) {
                    //and if highest point yet
                    if (player.getY() <= minPlayerY) {
                        //add to score
                        minPlayerY -= sizeOfMap;
                        if (16 * sizeOfMap > player.getY() && player.getY() > 8 * sizeOfMap) {
                            currScore += 10;
                        }
                        if (8 * sizeOfMap > player.getY() && player.getY() >= 0 * sizeOfMap) {
                            currScore += 20;
                        }
                    }
                }
            }

            constrainYToGrid(player);
            if (player.getY() > 8 * sizeOfMap) {
                constrainXToGrid(player);
            }

            player.setX(Math.max(0, Math.min(player.getX(), sizeOfMap * (w - 1))));
            player.setY(Math.max(yBuffer, Math.min(player.getY(), yBuffer + sizeOfMap * (h - 1))));

            break;
        default:
            break;
        }
        return super.onTouchEvent(event);
    }

    public void constrainXToGrid(Sprite sprite) {
        sprite.setX(((int) (sprite.getX() / sizeOfMap)) * sizeOfMap);
    }

    public void constrainYToGrid(Sprite sprite) {
        sprite.setY((((int) ((sprite.getY() - yBuffer) / sizeOfMap)) * sizeOfMap) + yBuffer);
    }
    public static boolean oceanCheck(double x, double y) {
        if (x < 0 || x > 10000) {
            System.out.println("Invalid X location");
        } else if (y < 0 || y > 10000) {
            System.out.println("Invalid Y location");
        } else {
            if (y < 8.0) {
                return true;
            }
        }
        return true;
    }
    public static void goBackPlayer(Player play) {
        if (play == null) {
            System.out.println("Invalid Player");
        }
        play.setX(5);
        play.setY(20);
    }

    private void goToMainMenu() {
        Intent intent = new Intent(this, MainMenu.class);
        startActivity(intent);
    }

    private void updateTextViewOnUIThread(TextView tv, String s) {
        runOnUiThread(() -> tv.setText(s));
    }

    public void resetGame() {
        resetPlayer();
        init();
    }
}
