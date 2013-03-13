package edu.utdallas.gamegenerator.Locale;

import edu.utdallas.gamegenerator.Characters.NPCCharacter;
import edu.utdallas.gamegenerator.Characters.PlayerCharacter;
import edu.utdallas.gamegenerator.LearningObjective.LearningObjective;
import edu.utdallas.gamegenerator.LearningObjective.Screen.LearningObjectiveScreen;
import edu.utdallas.gamegenerator.LearningObjective.Screen.ScreenType;
import edu.utdallas.gamegenerator.ScreenNode;
import edu.utdallas.gamegenerator.Shared.GameObject;
import edu.utdallas.gamegenerator.Shared.SharedCharacter;
import edu.utdallas.gamegenerator.Theme.Theme;
import edu.utdallas.gamegenerator.Theme.ThemeStory;

import java.util.ArrayList;
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

    public List<ScreenNode> getAct(int learningObjective) {
        List<ScreenNode> actScreens = new ArrayList<ScreenNode>();


        return null;
    }

    private List<ScreenNode> buildLesson(int learningObjective) {
        List<ScreenNode> lessonScreens = new ArrayList<ScreenNode>();


        return null;
    }

    private ScreenNode buildStoryScreen(int learningObjective, ScreenType screenType) {
        ScreenNode screenNode = new ScreenNode();
        ThemeStory themeStory = theme.getThemeStories().get(learningObjective);
        LearningObjectiveScreen themeStoryScreen;
        if(screenType.equals(ScreenType.LESSON_STORY_INTRO)) {
            themeStoryScreen = themeStory.getIntro();
        } else {
            themeStoryScreen = themeStory.getOutro();
        }
        screenNode.setBackground(backgrounds.get(screenType));
        screenNode.setName("LESSON_" + learningObjective + " - " + screenType);




        return null;
    }

    public Map<ScreenType, Map<String, GameObject>> getButtons() {
        return buttons;
    }

    public void setButtons(Map<ScreenType, Map<String, GameObject>> buttons) {
        this.buttons = buttons;
    }
}
