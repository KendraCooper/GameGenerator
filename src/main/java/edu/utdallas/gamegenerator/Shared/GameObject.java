package edu.utdallas.gamegenerator.Shared;

/**
 * User: clocke
 * Date: 2/17/13
 * Time: 3:27 PM
 */
public class GameObject {
    private int locX;
    private int locY;
    private int width;
    private int height;
    private String pathToAsset;
    private String text;

    public GameObject() {

    }

    public GameObject(int locX, int locY, int width, int height, String pathToAsset) {
        this.locX = locX;
        this.locY = locY;
        this.width = width;
        this.height = height;
        this.pathToAsset = pathToAsset;
    }

    public int getLocX() {
        return locX;
    }

    public void setLocX(int locX) {
        this.locX = locX;
    }

    public int getLocY() {
        return locY;
    }

    public void setLocY(int locY) {
        this.locY = locY;
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

    public String getPathToAsset() {
        return pathToAsset;
    }

    public void setPathToAsset(String pathToAsset) {
        this.pathToAsset = pathToAsset;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}
