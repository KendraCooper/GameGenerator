package edu.utdallas.gamegenerator.Locale;

/**
 * User: clocke
 * Date: 2/17/13
 * Time: 6:33 PM
 */
public class ObjectMovement {
    private ObjectMovementType movementType;
    private double startX;
    private double startY;
    private double endX;
    private double endY;
    private double speed;

    public ObjectMovement() {
    }

    public ObjectMovement(ObjectMovementType movementType, double startX, double startY, double endX, double endY) {
        this.movementType = movementType;
        this.startX = startX;
        this.startY = startY;
        this.endX = endX;
        this.endY = endY;
        this.speed = 1;
    }

    public ObjectMovementType getMovementType() {
        return movementType;
    }

    public void setMovementType(ObjectMovementType movementType) {
        this.movementType = movementType;
    }

    public double getStartX() {
        return startX;
    }

    public void setStartX(double startX) {
        this.startX = startX;
    }

    public double getStartY() {
        return startY;
    }

    public void setStartY(double startY) {
        this.startY = startY;
    }

    public double getEndX() {
        return endX;
    }

    public void setEndX(double endX) {
        this.endX = endX;
    }

    public double getEndY() {
        return endY;
    }

    public void setEndY(double endY) {
        this.endY = endY;
    }

    public double getSpeed() {
        return speed;
    }

    public void setSpeed(double speed) {
        this.speed = speed;
    }
}
