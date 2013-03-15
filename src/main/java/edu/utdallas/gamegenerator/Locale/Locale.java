package edu.utdallas.gamegenerator.Locale;

import edu.utdallas.gamegenerator.Asset;
import edu.utdallas.gamegenerator.Characters.NPCCharacter;
import edu.utdallas.gamegenerator.Characters.PlayerCharacter;
import edu.utdallas.gamegenerator.LearningObjective.Character.LearningObjectiveCharacter;
import edu.utdallas.gamegenerator.LearningObjective.Character.LearningObjectiveCharacterType;
import edu.utdallas.gamegenerator.LearningObjective.LearningObjective;
import edu.utdallas.gamegenerator.LearningObjective.Prop.GameButton;
import edu.utdallas.gamegenerator.LearningObjective.Prop.GameText;
import edu.utdallas.gamegenerator.LearningObjective.Prop.TextType;
import edu.utdallas.gamegenerator.LearningObjective.Screen.LearningObjectiveScreen;
import edu.utdallas.gamegenerator.LearningObjective.Screen.ScreenType;
import edu.utdallas.gamegenerator.ScreenNode;
import edu.utdallas.gamegenerator.Shared.*;
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
    private Map<ScreenType, Map<LearningObjectiveCharacterType, SharedCharacter>> localeCharacters;
    private Map<ScreenType, Map<TextType, SharedInformationBox>> informationBoxes;
    private Map<ScreenType, Map<ButtonLocationType, SharedButton>> buttons;

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

    public Map<ScreenType, Map<LearningObjectiveCharacterType, SharedCharacter>> getLocaleCharacters() {
        return localeCharacters;
    }

    public void setLocaleCharacters(Map<ScreenType, Map<LearningObjectiveCharacterType, SharedCharacter>> localeCharacters) {
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

        List<Asset> assets = new ArrayList<Asset>();
        List<GameObject> localeObjects = gameObjects.get(screenType);
        if(localeObjects != null) {
            for(GameObject object : localeObjects) {
                assets.add(new Asset(object));
            }
        }
        List<LearningObjectiveCharacter> themeCharacters = themeStoryScreen.getCharacters();
        if(themeCharacters != null) {
            for(LearningObjectiveCharacter themeCharacter : themeCharacters) {
                LearningObjectiveCharacterType characterType = themeCharacter.getCharacterType();
                SharedCharacter localeCharacter = localeCharacters.get(screenType).get(characterType);
                assets.add(new Asset(localeCharacter, npcCharacters.getCharacter(characterType),
                        themeCharacter));
            }
        }

        List<GameText> themeGameTexts = themeStoryScreen.getTexts();
        Map<TextType, SharedInformationBox> screenInformationBoxes = informationBoxes.get(screenType);
        if(themeGameTexts != null) {
            for(GameText gameText : themeGameTexts) {
                assets.add(new Asset(screenInformationBoxes.get(gameText.getTextType()), gameText));
            }
        }

        List<GameButton> themeGameButtons = themeStoryScreen.getButtons();
        Map<ButtonLocationType, SharedButton> localeButtons = buttons.get(screenType);
        if(themeGameButtons != null) {
            for(GameButton gameButton : themeGameButtons) {
                assets.add(new Asset(localeButtons.get(gameButton.getButtonLocationType()), gameButton));
            }
        }




        return screenNode;
    }

    public Map<ScreenType, Map<ButtonLocationType, SharedButton>> getButtons() {
        return buttons;
    }

    public void setButtons(Map<ScreenType, Map<ButtonLocationType, SharedButton>> buttons) {
        this.buttons = buttons;
    }

    public Map<ScreenType, Map<TextType, SharedInformationBox>> getInformationBoxes() {
        return informationBoxes;
    }

    public void setInformationBoxes(Map<ScreenType, Map<TextType, SharedInformationBox>> informationBoxes) {
        this.informationBoxes = informationBoxes;
    }
}
