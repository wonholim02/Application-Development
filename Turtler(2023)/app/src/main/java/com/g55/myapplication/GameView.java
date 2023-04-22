package com.g55.myapplication;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.View;

import androidx.annotation.Nullable;

import com.g55.myapplication.components.Tiles;

import java.util.ArrayList;

public class GameView extends View {
    private Bitmap towelTile;
    private Bitmap grassTile;
    private Bitmap oceanTile;
    private Bitmap darkOceanTile;
    private Bitmap bridgeTopTile;
    private Bitmap bridgeBottomTile;
    private Bitmap shoreTile;
    private static int sizeOfMap = 100 * TurtlerApplication.getScreenWidth() / 1080;
    private int h = 17;
    private int w = 11;
    private ArrayList<Tiles> arrTiles = new ArrayList<>();

    public GameView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        grassTile = BitmapFactory.decodeResource(this.getResources(), R.drawable.grass);
        oceanTile = BitmapFactory.decodeResource(this.getResources(), R.drawable.ocean);
        darkOceanTile = BitmapFactory.decodeResource(this.getResources(),
                R.drawable.dark_ocean_tile);
        bridgeTopTile = BitmapFactory.decodeResource(this.getResources(), R.drawable.bridge_top);
        bridgeBottomTile = BitmapFactory.decodeResource(this.getResources(),
                R.drawable.bridge_bottom);
        shoreTile = BitmapFactory.decodeResource(this.getResources(), R.drawable.shore);

        grassTile = Bitmap.createScaledBitmap(grassTile, sizeOfMap, sizeOfMap, true);
        oceanTile = Bitmap.createScaledBitmap(oceanTile, sizeOfMap, sizeOfMap, true);
        darkOceanTile = Bitmap.createScaledBitmap(darkOceanTile, sizeOfMap, sizeOfMap, true);
        bridgeTopTile = Bitmap.createScaledBitmap(bridgeTopTile, sizeOfMap, sizeOfMap, true);
        bridgeBottomTile = Bitmap.createScaledBitmap(bridgeBottomTile, sizeOfMap, sizeOfMap,
                true);
        shoreTile = Bitmap.createScaledBitmap(shoreTile, sizeOfMap, sizeOfMap, true);

        for (int y = 0; y < h; y++) {

            Bitmap temp;
            if (y == 0) {
                temp = darkOceanTile;
            } else if (7 >= y && y >= 1) {
                temp = oceanTile;
            } else if (y == 8) {
                temp = bridgeTopTile;
            } else if (15 >= y && y >= 10) {
                temp = shoreTile;
            } else if (y == 16) {
                temp = grassTile;
            } else {
                temp = bridgeBottomTile;
            }

            for (int x = 0; x < w; x++) {
                arrTiles.add(new Tiles(temp, x * sizeOfMap, y * sizeOfMap
                        + 150 * TurtlerApplication.getScreenHeight() / 1920,
                        sizeOfMap, sizeOfMap));
            }
        }
    }

    public Bitmap getOcean() {
        return  oceanTile;
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.drawColor(0xEAE7B1);
        for (int i = 0; i < arrTiles.size(); i++) {
            canvas.drawBitmap(arrTiles.get(i).getBm(), arrTiles.get(i).getX(),
                    arrTiles.get(i).getY(), null);
        }
    }
}
