package edu.utdallas.gamegenerator.Locale;

import edu.utdallas.gamegenerator.Asset;
import edu.utdallas.gamegenerator.Behavior;
import edu.utdallas.gamegenerator.BehaviorType;
import edu.utdallas.gamegenerator.Characters.NPCCharacter;
import edu.utdallas.gamegenerator.Characters.PlayerCharacter;
import edu.utdallas.gamegenerator.LearningObjective.Challenge.ChallengeOption;
import edu.utdallas.gamegenerator.LearningObjective.Character.LearningObjectiveCharacter;
import edu.utdallas.gamegenerator.LearningObjective.Character.LearningObjectiveCharacterType;
import edu.utdallas.gamegenerator.LearningObjective.LearningObjective;
import edu.utdallas.gamegenerator.LearningObjective.Lesson;
import edu.utdallas.gamegenerator.LearningObjective.Prop.GameButton;
import edu.utdallas.gamegenerator.LearningObjective.Prop.GameText;
import edu.utdallas.gamegenerator.LearningObjective.Prop.TextType;
import edu.utdallas.gamegenerator.LearningObjective.Screen.LearningObjectiveChallenge;
import edu.utdallas.gamegenerator.LearningObjective.Screen.LearningObjectiveScreen;
import edu.utdallas.gamegenerator.LearningObjective.Screen.ScreenType;
import edu.utdallas.gamegenerator.LearningObjective.Screen.TransitionType;
import edu.utdallas.gamegenerator.ScreenNode;
import edu.utdallas.gamegenerator.Shared.*;
import edu.utdallas.gamegenerator.Theme.Theme;
import edu.utdallas.gamegenerator.Theme.ThemeStory;

import java.util.*;

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
    private Map<ScreenType, LocaleScreen> localeScreens;

    private Map<TransitionType, UUID> screenTransitions = new HashMap<TransitionType, UUID>();;

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

    public List<ScreenNode> getAct(int learningObjective) {
        List<ScreenNode> actScreens = new ArrayList<ScreenNode>();
        actScreens.addAll(buildStoryScreens(learningObjective, ScreenType.LESSON_STORY_INTRO));
        actScreens.addAll(buildLesson(learningObjective));
        actScreens.addAll(buildChallenge(learningObjective, 0));

//        buildStoryScreens(learningObjective, ScreenType.LESSON_STORY_OUTRO);
        return actScreens;
    }

    private List<ScreenNode> buildChallenge(int learningObjective, int challengeNum) {
        UUID currentScreen = screenTransitions.get(TransitionType.BEGINNING_OF_CHALLENGE);
        UUID nextScreen = UUID.randomUUID();
        Lesson lesson = learningObjectives.get(learningObjective).getLessons().get(0);
        LearningObjectiveChallenge challenge = lesson.getLessonChallenges().get(challengeNum);
        List<ScreenNode> screenNodes = new ArrayList<ScreenNode>();
        screenNodes.addAll(buildStoryScreen(learningObjective, challenge, localeScreens.get(ScreenType.CHALLENGE), currentScreen, nextScreen));
        return screenNodes;
    }

    private List<ScreenNode> buildStoryScreens(int learningObjective, ScreenType screenType) {
        List<ScreenNode> lessonScreens = new ArrayList<ScreenNode>();
        UUID currentScreen = UUID.randomUUID();
        UUID nextScreen = null;
        ThemeStory themeStory = theme.getThemeStories().get(learningObjective);
        List<LearningObjectiveScreen> themeStoryScreen;
        if(screenType.equals(ScreenType.LESSON_STORY_INTRO)) {
            themeStoryScreen = themeStory.getIntro();
        } else {
            themeStoryScreen = themeStory.getOutro();
        }

        for(LearningObjectiveScreen screen : themeStoryScreen) {
            nextScreen = UUID.randomUUID();
            lessonScreens.addAll(buildStoryScreen(learningObjective, screen, localeScreens.get(screenType), currentScreen, nextScreen));
            currentScreen = nextScreen;
        }

        screenTransitions.put(TransitionType.BEGINNING_OF_LESSON, nextScreen);

        return lessonScreens;
    }

    private List<ScreenNode> buildLesson(int learningObjective) {
        List<ScreenNode> lessonScreens = new ArrayList<ScreenNode>();
        UUID currentScreen = screenTransitions.get(TransitionType.BEGINNING_OF_LESSON);
        UUID nextScreen = null;
        Lesson lesson = learningObjectives.get(learningObjective).getLessons().get(0);
        List<? extends LearningObjectiveScreen> screens = lesson.getLessonScreens();
        for(LearningObjectiveScreen screen : screens) {
            nextScreen = UUID.randomUUID();
            lessonScreens.addAll(buildStoryScreen(learningObjective, screen, localeScreens.get(screen.getType()), currentScreen, nextScreen));
            currentScreen = nextScreen;
        }

        screenTransitions.put(TransitionType.BEGINNING_OF_CHALLENGE, nextScreen);


        return lessonScreens;
    }

    private List<ScreenNode> buildStoryScreen(int learningObjective, LearningObjectiveScreen themeStoryScreen,
                                        LocaleScreen localeScreen, UUID screenId, UUID nextScreenId) {
        List<ScreenNode> screenNodes = new ArrayList<ScreenNode>();
        ScreenNode screenNode = new ScreenNode();
        screenNodes.add(screenNode);
        screenNode.setId(screenId);
        screenNode.setBackground(localeScreen.getBackground());
        screenNode.setName("LESSON_" + learningObjective + " - ");

        List<Asset> assets = new ArrayList<Asset>();
        screenNode.setAssets(assets);
        List<GameObject> localeObjects = localeScreen.getGameObjects();
        if(localeObjects != null) {
            for(GameObject object : localeObjects) {
                assets.add(new Asset(object));
            }
        }
        List<LearningObjectiveCharacter> themeCharacters = themeStoryScreen.getCharacters();
        if(themeCharacters != null) {
            for(LearningObjectiveCharacter themeCharacter : themeCharacters) {
                LearningObjectiveCharacterType characterType = themeCharacter.getCharacterType();
                SharedCharacter localeCharacter = localeScreen.getCharacters().get(characterType);
                assets.add(new Asset(localeCharacter, npcCharacters.getCharacter(characterType),
                        themeCharacter));
            }
        }

        List<GameText> themeInformationBoxes = themeStoryScreen.getInformationBoxes();
        Map<TextType, SharedInformationBox> screenInformationBoxes = localeScreen.getInformationBoxes();
        if(themeInformationBoxes != null) {
            for(GameText gameText : themeInformationBoxes) {
                assets.add(new Asset(screenInformationBoxes.get(gameText.getTextType()), gameText));
            }
        }

        List<GameButton> themeGameButtons = themeStoryScreen.getButtons();
        Map<ButtonLocationType, SharedButton> localeButtons = localeScreen.getButtons();
        if(themeGameButtons != null) {
            for(GameButton gameButton : themeGameButtons) {
                Asset asset = new Asset(localeButtons.get(gameButton.getButtonLocationType()), gameButton);
                Behavior behavior = null;
                for(Behavior b : asset.getBehaviors()) {
                    if(b.getBehaviorType() == BehaviorType.TRANSITION_BEHAVIOR) {
                        behavior = b;
                    }
                }
                if(behavior != null) {
                    switch (gameButton.getTransitionType()) {
                        case BEGINNING_OF_LESSON:
                            behavior.setTransitionId(screenTransitions.get(TransitionType.BEGINNING_OF_LESSON));
                            break;
                        case NEXT_SCREEN:
                            behavior.setTransitionId(nextScreenId);
                            break;
                        case BEGINNING_OF_CHALLENGE:
                            behavior.setTransitionId(screenTransitions.get(TransitionType.BEGINNING_OF_CHALLENGE));
                            break;
                        case END_OF_STORY:
                            behavior.setTransitionId(screenTransitions.get(TransitionType.END_OF_STORY));
                            break;
                        case ADDITIONAL:
                            if(gameButton instanceof ChallengeOption) {
                                ChallengeOption challengeOption = (ChallengeOption) gameButton;
                                UUID additionalScreenId = UUID.randomUUID();
                                screenNodes.addAll(buildAdditionalScreens(challengeOption.getAdditionalScreens(), additionalScreenId));
                                behavior.setTransitionId(additionalScreenId);
                            }

                            break;
                    }
                }
                assets.add(asset);
            }
        }


        return screenNodes;
    }

    private List<ScreenNode> buildAdditionalScreens(List<LearningObjectiveScreen> additionalScreens, UUID additionalScreenId) {
        List<ScreenNode> screenNodes = new ArrayList<ScreenNode>();
        UUID nextScreen = UUID.randomUUID();
        for(LearningObjectiveScreen screen : additionalScreens) {
            screenNodes.addAll(buildStoryScreen(0, screen, localeScreens.get(screen.getType()), additionalScreenId, nextScreen));
            additionalScreenId = nextScreen;
            nextScreen = UUID.randomUUID();
        }

        return screenNodes;
    }

    public Map<ScreenType, LocaleScreen> getLocaleScreens() {
        return localeScreens;
    }

    public void setLocaleScreens(Map<ScreenType, LocaleScreen> localeScreens) {
        this.localeScreens = localeScreens;
    }

    public Map<TransitionType, UUID> getScreenTransitions() {
        return screenTransitions;
    }

    public void setScreenTransitions(Map<TransitionType, UUID> screenTransitions) {
        this.screenTransitions = screenTransitions;
    }
}
