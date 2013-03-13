package edu.utdallas.gamegenerator.Locale;

import edu.utdallas.gamegenerator.Characters.NPCCharacter;
import edu.utdallas.gamegenerator.Characters.PlayerCharacter;
import edu.utdallas.gamegenerator.LearningObjective.LearningObjective;
import edu.utdallas.gamegenerator.LearningObjective.Screen.ScreenType;
import edu.utdallas.gamegenerator.ScreenNode;
import edu.utdallas.gamegenerator.Shared.*;
import edu.utdallas.gamegenerator.Shared.SharedCharacter;
import edu.utdallas.gamegenerator.Theme.Theme;

import java.util.List;
import java.util.Map;

/**
 * User: clocke
 * Date: 2/17/13
 * Time: 5:54 PM
 */
public class Locale {
    private List<LearningObjective> learningObjectives;
    private PlayerCharacter playerCharacter;
    private NPCCharacter npcCharacters;
    private Theme theme;
    private Map<ScreenType, String> backgrounds;
    private Map<ScreenType, List<GameObject>> gameObjects;
    private Map<ScreenType, Map<String, SharedCharacter>> localeCharacters;
    private Map<ScreenType, Map<String, GameObject>> buttons;

    public List<LearningObjective> getLearningObjectives() {
        return learningObjectives;
    }

    public void setLearningObjectives(List<LearningObjective> learningObjectives) {
        this.learningObjectives = learningObjectives;
    }

    public PlayerCharacter getPlayerCharacter() {
        return playerCharacter;
    }

    public void setPlayerCharacter(PlayerCharacter playerCharacter) {
        this.playerCharacter = playerCharacter;
    }

    public NPCCharacter getNpcCharacters() {
        return npcCharacters;
    }

    public void setNpcCharacters(NPCCharacter npcCharacters) {
        this.npcCharacters = npcCharacters;
    }

    public Theme getTheme() {
        return theme;
    }

    public void setTheme(Theme theme) {
        this.theme = theme;
    }

    public Map<ScreenType, String> getBackgrounds() {
        return backgrounds;
    }

    public void setBackgrounds(Map<ScreenType, String> backgrounds) {
        this.backgrounds = backgrounds;
    }

    public Map<ScreenType, List<GameObject>> getGameObjects() {
        return gameObjects;
    }

    public void setGameObjects(Map<ScreenType, List<GameObject>> gameObjects) {
        this.gameObjects = gameObjects;
    }

    public Map<ScreenType, Map<String, SharedCharacter>> getLocaleCharacters() {
        return localeCharacters;
    }

    public void setLocaleCharacters(Map<ScreenType, Map<String, SharedCharacter>> localeCharacters) {
        this.localeCharacters = localeCharacters;
    }

    public ScreenNode getAct(int learningObjective) {
        //Stub
        return null;
    }

    public Map<ScreenType, Map<String, GameObject>> getButtons() {
        return buttons;
    }

    public void setButtons(Map<ScreenType, Map<String, GameObject>> buttons) {
        this.buttons = buttons;
    }
}
