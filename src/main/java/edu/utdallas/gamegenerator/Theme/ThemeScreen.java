package edu.utdallas.gamegenerator.Theme;

import edu.utdallas.gamegenerator.Shared.*;

import java.util.List;
import java.util.Map;

/**
 * User: clocke
 * Date: 3/3/13
 * Time: 6:29 PM
 */
public class ThemeScreen {
    private String background;
    private Map<String, SharedCharacter> themeCharacters;
    private List<GameObject> gameObjects;
    private Map<ButtonLocationType, SharedButton> buttons;
    private List<SharedInformationBox> informationBoxes;

    public String getBackground() {
        return background;
    }

    public void setBackground(String background) {
        this.background = background;
    }

    public Map<String, SharedCharacter> getThemeCharacters() {
        return themeCharacters;
    }

    public void setThemeCharacters(Map<String, SharedCharacter> themeCharacters) {
        this.themeCharacters = themeCharacters;
    }

    public List<GameObject> getGameObjects() {
        return gameObjects;
    }

    public void setGameObjects(List<GameObject> gameObjects) {
        this.gameObjects = gameObjects;
    }

    public Map<ButtonLocationType, SharedButton> getButtons() {
        return buttons;
    }

    public void setButtons(Map<ButtonLocationType, SharedButton> buttons) {
        this.buttons = buttons;
    }

    public List<SharedInformationBox> getInformationBoxes() {
        return informationBoxes;
    }

    public void setInformationBoxes(List<SharedInformationBox> informationBoxes) {
        this.informationBoxes = informationBoxes;
    }
}
