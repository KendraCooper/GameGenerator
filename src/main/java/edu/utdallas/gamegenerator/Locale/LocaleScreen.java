package edu.utdallas.gamegenerator.Locale;

import edu.utdallas.gamegenerator.LearningObjective.Character.LearningObjectiveCharacterType;
import edu.utdallas.gamegenerator.LearningObjective.Prop.TextType;
import edu.utdallas.gamegenerator.Shared.*;

import java.util.List;
import java.util.Map;

/**
 * Company: Porpoise Software
 * User: Terminus Est
 * Date: 3/17/13
 * Time: 9:28 PM
 */
public class LocaleScreen {
    private String background;
    private List<GameObject> gameObjects;
    private Map<LearningObjectiveCharacterType, SharedCharacter> characters;
    private Map<TextType, SharedInformationBox> informationBoxes;
    private Map<ButtonLocationType, SharedButton> buttons;

    public String getBackground() {
        return background;
    }

    public void setBackground(String background) {
        this.background = background;
    }

    public List<GameObject> getGameObjects() {
        return gameObjects;
    }

    public void setGameObjects(List<GameObject> gameObjects) {
        this.gameObjects = gameObjects;
    }

    public Map<LearningObjectiveCharacterType, SharedCharacter> getCharacters() {
        return characters;
    }

    public void setCharacters(Map<LearningObjectiveCharacterType, SharedCharacter> characters) {
        this.characters = characters;
    }

    public Map<TextType, SharedInformationBox> getInformationBoxes() {
        return informationBoxes;
    }

    public void setInformationBoxes(Map<TextType, SharedInformationBox> informationBoxes) {
        this.informationBoxes = informationBoxes;
    }

    public Map<ButtonLocationType, SharedButton> getButtons() {
        return buttons;
    }

    public void setButtons(Map<ButtonLocationType, SharedButton> buttons) {
        this.buttons = buttons;
    }
}
