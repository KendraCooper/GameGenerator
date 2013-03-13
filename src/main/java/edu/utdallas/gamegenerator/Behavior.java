package edu.utdallas.gamegenerator;

import edu.utdallas.gamegenerator.Locale.ObjectMovement;

import java.util.UUID;

/**
 * User: clocke
 * Date: 3/3/13
 * Time: 8:59 PM
 */
public class Behavior {
    private String trigger;
    private int time;
    private String displayName;
    private Integer points;
    private UUID transitionId;
    private String transition;
    private UUID entityId;
    private String newVisibility;
    private double startLocationX;
    private double startLocationY;
    private double endLocationX;
    private double endLocationY;
    private double speed;


    public Behavior() {
    }

    public Behavior(ObjectMovement movement) {
        startLocationX = movement.getStartX();
        startLocationY = movement.getStartY();
        endLocationX = movement.getEndX();
        endLocationY = movement.getEndY();
        speed = movement.getSpeed();
        transition = movement.getMovementType().toString();
    }

    public String getTrigger() {
        return trigger;
    }

    public void setTrigger(String trigger) {
        this.trigger = trigger;
    }

    public int getTime() {
        return time;
    }

    public void setTime(int time) {
        this.time = time;
    }

    public String getDisplayName() {
        return displayName;
    }

    public void setDisplayName(String displayName) {
        this.displayName = displayName;
    }

    public Integer getPoints() {
        return points;
    }

    public void setPoints(Integer points) {
        this.points = points;
    }

    public UUID getTransitionId() {
        return transitionId;
    }

    public void setTransitionId(UUID transitionId) {
        this.transitionId = transitionId;
    }

    public String getTransition() {
        return transition;
    }

    public void setTransition(String transition) {
        this.transition = transition;
    }

    public UUID getEntityId() {
        return entityId;
    }

    public void setEntityId(UUID entityId) {
        this.entityId = entityId;
    }

    public String getNewVisibility() {
        return newVisibility;
    }

    public void setNewVisibility(String newVisibility) {
        this.newVisibility = newVisibility;
    }

    public double getStartLocationX() {
        return startLocationX;
    }

    public void setStartLocationX(double startLocationX) {
        this.startLocationX = startLocationX;
    }

    public double getStartLocationY() {
        return startLocationY;
    }

    public void setStartLocationY(double startLocationY) {
        this.startLocationY = startLocationY;
    }

    public double getEndLocationX() {
        return endLocationX;
    }

    public void setEndLocationX(double endLocationX) {
        this.endLocationX = endLocationX;
    }

    public double getEndLocationY() {
        return endLocationY;
    }

    public void setEndLocationY(double endLocationY) {
        this.endLocationY = endLocationY;
    }

    public double getSpeed() {
        return speed;
    }

    public void setSpeed(double speed) {
        this.speed = speed;
    }
}
