package edu.utdallas.gamegenerator;

import edu.utdallas.gamegenerator.Characters.GameCharacter;
import edu.utdallas.gamegenerator.LearningObjective.Character.LearningObjectiveCharacter;
import edu.utdallas.gamegenerator.LearningObjective.Prop.GameButton;
import edu.utdallas.gamegenerator.LearningObjective.Prop.GameText;
import edu.utdallas.gamegenerator.Locale.ObjectMovement;
import edu.utdallas.gamegenerator.Shared.*;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/**
 * User: clocke
 * Date: 3/3/13
 * Time: 8:50 PM
 */
public class Asset {
    private String type;
    private UUID id;
    private String name;
    private List<Behavior> behaviors;
    private double opacity;
    private double locX;
    private double locY;
    private double locX2;
    private double locY2;
    private double width;
    private double height;
    private Color backgroundColor;
    private Color foregroundColor;
    private int fontSize;
    private int fontFamily;
    private int experience;
    private int certificates;
    private int promotions;
    private int trophies;
    private int points;
    private int hint;
    private String displayImage;

    public Asset() {
        id = UUID.randomUUID();
    }

    public Asset(GameObject gameObject) {
        id = UUID.randomUUID();
        type = "ImageAsset";
        locX = gameObject.getLocX();
        locY = gameObject.getLocY();
        width = gameObject.getWidth();
        height = gameObject.getHeight();
        locX2 = locX + width;
        locY2 = locY + height;
        displayImage = gameObject.getPathToAsset();
    }

    public Asset(SharedCharacter character, GameCharacter gameCharacter,
                 LearningObjectiveCharacter learningObjectiveCharacter) {
        id = UUID.randomUUID();
        type = "CharacterAsset";
        locX = character.getLocX();
        locY = character.getLocY();
        width = character.getWidth();
        height = character.getHeight();
        locX2 = locX + width;
        locY2 = locY + height;
        displayImage = gameCharacter.getCharacterAsset(character.getCharacterAssetType());
        behaviors = new ArrayList<Behavior>();
        for(ObjectMovement movement : character.getMovements()) {
            if(learningObjectiveCharacter.getMovementType() == movement.getMovementType()) {
                behaviors.add(new Behavior(movement));
            }
        }
    }

    public Asset(SharedButton button) {
        this((GameObject)button);
        this.name = button.getName();
        type = "ButtonAsset";
        this.behaviors = new ArrayList<Behavior>();
        this.behaviors.add(button.getBehavior());
    }

    public Asset(SharedInformationBox informationBox) {
        this((GameObject)informationBox);
        this.name = informationBox.getName();
        type = "InformationBoxAsset";
    }

    public Asset(SharedInformationBox informationBox, GameText gameText) {
        this(informationBox);
        this.name = gameText.getText();
    }

    public Asset(SharedButton sharedButton, GameButton gameButton) {
        this(sharedButton);
        this.name = gameButton.getText();
        behaviors = new ArrayList<Behavior>();
        if(gameButton.getReward() != null) {
            Behavior behavior = new Behavior();
            behavior.setBehaviorType(BehaviorType.REWARD_BEHAVIOR);
            behavior.setPoints(gameButton.getReward().getPoints());
            behaviors.add(behavior);
        }
        if(gameButton.getTransitionType() != null) {
            Behavior behavior = new Behavior();
            behavior.setBehaviorType(BehaviorType.TRANSITION_BEHAVIOR);
            behaviors.add(behavior);
        }
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Behavior> getBehaviors() {
        return behaviors;
    }

    public void setBehaviors(List<Behavior> behaviors) {
        this.behaviors = behaviors;
    }

    public double getOpacity() {
        return opacity;
    }

    public void setOpacity(double opacity) {
        this.opacity = opacity;
    }

    public double getLocX() {
        return locX;
    }

    public void setLocX(double locX) {
        this.locX = locX;
    }

    public double getLocY() {
        return locY;
    }

    public void setLocY(double locY) {
        this.locY = locY;
    }

    public double getLocX2() {
        return locX2;
    }

    public void setLocX2(double locX2) {
        this.locX2 = locX2;
    }

    public double getLocY2() {
        return locY2;
    }

    public void setLocY2(double locY2) {
        this.locY2 = locY2;
    }

    public double getWidth() {
        return width;
    }

    public void setWidth(double width) {
        this.width = width;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public Color getBackgroundColor() {
        return backgroundColor;
    }

    public void setBackgroundColor(Color backgroundColor) {
        this.backgroundColor = backgroundColor;
    }

    public Color getForegroundColor() {
        return foregroundColor;
    }

    public void setForegroundColor(Color foregroundColor) {
        this.foregroundColor = foregroundColor;
    }

    public int getFontSize() {
        return fontSize;
    }

    public void setFontSize(int fontSize) {
        this.fontSize = fontSize;
    }

    public int getFontFamily() {
        return fontFamily;
    }

    public void setFontFamily(int fontFamily) {
        this.fontFamily = fontFamily;
    }

    public int getExperience() {
        return experience;
    }

    public void setExperience(int experience) {
        this.experience = experience;
    }

    public int getCertificates() {
        return certificates;
    }

    public void setCertificates(int certificates) {
        this.certificates = certificates;
    }

    public int getPromotions() {
        return promotions;
    }

    public void setPromotions(int promotions) {
        this.promotions = promotions;
    }

    public int getTrophies() {
        return trophies;
    }

    public void setTrophies(int trophies) {
        this.trophies = trophies;
    }

    public int getPoints() {
        return points;
    }

    public void setPoints(int points) {
        this.points = points;
    }

    public int getHint() {
        return hint;
    }

    public void setHint(int hint) {
        this.hint = hint;
    }

    public String getDisplayImage() {
        return displayImage;
    }

    public void setDisplayImage(String displayImage) {
        this.displayImage = displayImage;
    }
}
