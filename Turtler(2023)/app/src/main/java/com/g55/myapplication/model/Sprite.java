package com.g55.myapplication.model;

public abstract class Sprite {
    private boolean hidden;
    private double x;
    private double y;
    private double dx;
    private double dy;
    private int width;
    private int height;
    private int spriteImageId;
    private int xmlElementId;

    // TO DO: Implement for animated sprite
    private boolean isAnimated;
    private int animationTime;
    private int numFrames;
    private int[] spriteFrames;

    public static boolean hasCollided(Sprite a, Sprite b) {
        //TO DO: Implement me :)
        return a.x < b.x + b.width
                && a.x + a.width > b.x
                && a.y < b.y + b.height
                && a.y + a.height > b.y;
    }

    public boolean hasCollided(Sprite other) {
        return x < other.x + other.width
                && x + width > other.x
                && y < other.y + other.height
                && y + height > other.y;
    }

    public abstract void update();

    public Sprite(boolean hidden, double x, double y, double dx, double dy,
            int width, int height, int spriteImageId, int xmlElementId) {
        this.hidden = hidden;
        this.x = x;
        this.y = y;
        this.dx = dx;
        this.dy = dy;
        this.width = width;
        this.height = height;
        this.spriteImageId = spriteImageId;
        this.xmlElementId = xmlElementId;
    }

    public Sprite() {
    }

    public boolean isHidden() {
        return hidden;
    }

    public void setHidden(boolean hidden) {

        this.hidden = hidden;
    }

    public boolean getHidden() {
        return hidden;
    }

    public double getX() {

        return x;
    }

    public void setX(double x) {

        this.x = x;
    }

    public double getY() {

        return y;
    }

    public void setY(double y) {

        this.y = y;
    }

    public double getDx() {

        return dx;
    }

    public void setDx(double dx) {
        this.dx = dx;
    }

    public double getDy() {

        return dy;
    }

    public void setDy(double dy) {

        this.dy = dy;
    }

    public int getWidth() {

        return width;
    }

    public void setWidth(int width) {

        this.width = width;
    }

    public int getHeight() {

        return height;
    }

    public void setHeight(int height) {

        this.height = height;
    }

    public int getSpriteImageId() {

        return spriteImageId;
    }

    public void setSpriteImageId(int spriteImageId) {

        this.spriteImageId = spriteImageId;
    }

    public int getXmlElementId() {

        return xmlElementId;
    }

    public void setXmlElementId(int xmlElementId) {

        this.xmlElementId = xmlElementId;
    }
}
