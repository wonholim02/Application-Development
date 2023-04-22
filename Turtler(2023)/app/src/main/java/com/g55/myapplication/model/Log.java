package com.g55.myapplication.model;

import com.g55.myapplication.TurtlerApplication;

public class Log extends Sprite {
    public Log(boolean hidden, double x, double y, double dx, double dy, int width, int height,
               int spriteImageId, int xmlElementId) {
        super(hidden, x, y, dx, dy, width, height, spriteImageId, xmlElementId);
    }

    public Log() {

    }

    @Override
    public void update() {
        super.setX((super.getX() + super.getDx()));
        super.setY((super.getY() + super.getDy()));
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
