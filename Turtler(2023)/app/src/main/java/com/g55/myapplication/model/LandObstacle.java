package com.g55.myapplication.model;

import android.widget.ImageView;

import com.g55.myapplication.TurtlerApplication;

public class LandObstacle extends Sprite {


    public LandObstacle(boolean hidden, double x, double y, double dx, double dy,
                        int width, int height, int spriteImageId, int xmlElementId) {
        super(hidden, x, y, dx, dy, width, height, spriteImageId, xmlElementId);
    }

    public LandObstacle() {

    }

    @Override
    public void update() {
        update(null);
    }
    public boolean update(ImageView player) {
        super.setX((super.getX() + super.getDx()));
        super.setY((super.getY() + super.getDy()));
        boolean check = false;
        if (player != null && isCollidingWith(player)) {
            check = true;
        }
        updatingPosition();
        return check;
    }
    private boolean isCollidingWith(ImageView other) {
        checkCollisionValidity(other);
        return super.getX() < other.getX() + other.getWidth()
                && super.getX() + super.getWidth() > other.getX()
                && super.getY() < other.getY() + other.getHeight()
                && super.getY() + super.getHeight() > other.getY();
    }
    public static boolean checkCollisionValidity(ImageView other) {
        if (other == null || other.equals(null)) {
            return false;
        }
        return true;
    }
    private void updatingPosition() {
        if (getDx() > 0) {
            if (super.getX() > TurtlerApplication.getScreenWidth()) {
                super.setX(-super.getWidth());
            }
        } else {
            if (super.getX() + super.getWidth() < 0) {
                super.setX(TurtlerApplication.getScreenWidth());
            }
        }
    }
}
