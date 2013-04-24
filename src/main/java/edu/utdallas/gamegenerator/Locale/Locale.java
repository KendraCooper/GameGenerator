package edu.utdallas.gamegenerator.Locale;

import edu.utdallas.gamegenerator.Asset;
import edu.utdallas.gamegenerator.Behavior;
import edu.utdallas.gamegenerator.BehaviorType;
import edu.utdallas.gamegenerator.Characters.GameCharacter;
import edu.utdallas.gamegenerator.Characters.Characters;
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

import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;
import java.util.*;

/**
 * User: clocke
 * Date: 2/17/13
 * Time: 5:54 PM
 */
@XmlRootElement(name = "Locale")
public class Locale {
    private List<LearningObjective> learningObjectives;
    private Characters characters;
    private Theme theme;
    private Map<ScreenType, LocaleScreen> localeScreens;

    private Map<TransitionType, UUID> screenTransitions = new HashMap<TransitionType, UUID>();;

    public List<LearningObjective> getLearningObjectives() {
        return learningObjectives;
    }

    @XmlTransient
    public void setLearningObjectives(List<LearningObjective> learningObjectives) {
        this.learningObjectives = learningObjectives;
    }

    public Characters getCharacters() {
        return characters;
    }

    @XmlTransient
    public void setCharacters(Characters characters) {
        this.characters = characters;
    }

    public Theme getTheme() {
        return theme;
    }

    @XmlTransient
    public void setTheme(Theme theme) {
        this.theme = theme;
    }

    /**
     * Creates a list of ScreenNode representing the act corresponding to the
     * passed in learning objective
     * @param learningObjectiveId the index of the learning objective
     * @return a list of ScreenNode
     */
    public List<ScreenNode> getAct(int learningObjectiveId) {
        List<ScreenNode> actScreens = new ArrayList<ScreenNode>();
        actScreens.addAll(buildScreens(learningObjectiveId, ScreenType.LESSON_STORY_INTRO));
        actScreens.addAll(buildScreens(learningObjectiveId, ScreenType.LESSON_STORY_OUTRO));
        actScreens.addAll(buildLesson(learningObjectiveId));
        actScreens.addAll(buildChallenges(learningObjectiveId));
        return actScreens;
    }

    /**
     * Builds all challenge screens for the learning objective
     * @param learningObjectiveId the id of the learning objective to build
     * @return a list of ScreenNode representing the built challenge screens
     */
    private List<ScreenNode> buildChallenges(int learningObjectiveId) {
        UUID currentScreen = screenTransitions.get(TransitionType.BEGINNING_OF_CHALLENGE);
        Lesson lesson = learningObjectives.get(learningObjectiveId).getLessons().get(0);
        List<ScreenNode> screenNodes = new ArrayList<ScreenNode>();
        List<LearningObjectiveChallenge> challenges = lesson.getLessonChallenges();
        for(LearningObjectiveChallenge challenge : challenges) {
            UUID nextChallenge = UUID.randomUUID();
            screenTransitions.put(TransitionType.NEXT_CHALLENGE, nextChallenge);
            screenTransitions.put(TransitionType.CURRENT_CHALLENGE, currentScreen);
            screenNodes.addAll(buildChallenge(learningObjectiveId, challenge, currentScreen));
            currentScreen = nextChallenge;
        }

        return screenNodes;
    }

    /**
     * Builds a single challenge including any additional screens
     * @param learningObjectiveId the id of the learning objective
     * @param challenge the LearningObjectiveChallenge screen
     * @param currentScreen the UUID of the screen to be built
     * @return a list of ScreenNode containing the challenge
     */
    private List<ScreenNode> buildChallenge(int learningObjectiveId, LearningObjectiveChallenge challenge, UUID currentScreen) {
        UUID nextScreen = UUID.randomUUID();
        List<ScreenNode> screenNodes = new ArrayList<ScreenNode>();
        screenNodes.addAll(buildScreen(learningObjectiveId, challenge, localeScreens.get(ScreenType.CHALLENGE),
                currentScreen, nextScreen));
        return screenNodes;
    }

    /**
     * Builds a list of ScreenNode for the passed learningObjectiveId and ScreenType
     * @param learningObjectiveId the index of the learning objective used to build the screens
     * @param screenType the type of screens to build
     * @return a list of ScreenNode
     */
    private List<ScreenNode> buildScreens(int learningObjectiveId, ScreenType screenType) {
        List<ScreenNode> lessonScreens = new ArrayList<ScreenNode>();
        UUID currentScreen = UUID.randomUUID();
        UUID nextScreen = null;
        ThemeStory themeStory = theme.getThemeStories().get(learningObjectiveId);
        List<LearningObjectiveScreen> themeStoryScreen;
        if(screenType.equals(ScreenType.LESSON_STORY_INTRO)) {
            themeStoryScreen = new ArrayList<LearningObjectiveScreen>(themeStory.getIntro());
        } else {
            screenTransitions.put(TransitionType.END_OF_STORY, currentScreen);
            themeStoryScreen = new ArrayList<LearningObjectiveScreen>(themeStory.getOutro());
        }

        for(LearningObjectiveScreen screen : themeStoryScreen) {
            nextScreen = UUID.randomUUID();
            lessonScreens.addAll(buildScreen(learningObjectiveId, screen, localeScreens.get(screenType),
                    currentScreen, nextScreen));
            currentScreen = nextScreen;
        }

        if(screenType.equals(ScreenType.LESSON_STORY_INTRO)) {
            screenTransitions.put(TransitionType.BEGINNING_OF_LESSON, nextScreen);
        }

        return lessonScreens;
    }

    /**
     * Builds all lesson screens for a learning objective
     * @param learningObjectiveId the id of the learning objective
     * @return a list of ScreenNode containing the built lesson screens
     */
    private List<ScreenNode> buildLesson(int learningObjectiveId) {
        List<ScreenNode> lessonScreens = new ArrayList<ScreenNode>();
        UUID currentScreen = screenTransitions.get(TransitionType.BEGINNING_OF_LESSON);
        UUID nextScreen = null;
        Lesson lesson = learningObjectives.get(learningObjectiveId).getLessons().get(0);
        List<? extends LearningObjectiveScreen> screens = lesson.getLessonScreens();
        for(LearningObjectiveScreen screen : screens) {
            nextScreen = UUID.randomUUID();
            lessonScreens.addAll(buildScreen(learningObjectiveId, screen,
                    localeScreens.get(screen.getType()), currentScreen, nextScreen));
            currentScreen = nextScreen;
        }

        screenTransitions.put(TransitionType.BEGINNING_OF_CHALLENGE, nextScreen);


        return lessonScreens;
    }

    /**
     * Builds a list of ScreenNode from the requested screen.  Will return a single screen unless the screen
     * has additional screens
     * @param learningObjectiveId the id of the learning objective
     * @param screen the screen used to create the ScreenNode
     * @param localeScreen the LocaleScreen used to create the ScreenNode
     * @param screenId the UUID of the current screen
     * @param nextScreenId the UUID of the next screen
     * @return a list of ScreenNode
     */
    private List<ScreenNode> buildScreen(int learningObjectiveId, LearningObjectiveScreen screen,
                                         LocaleScreen localeScreen, UUID screenId, UUID nextScreenId) {
        List<ScreenNode> screenNodes = new ArrayList<ScreenNode>();
        ScreenNode screenNode = new ScreenNode();
        screenNodes.add(screenNode);
        screenNode.setId(screenId);
        screenNode.setBackground(localeScreen.getBackground());
        screenNode.setName("LESSON_" + learningObjectiveId + " - ");

        List<Asset> assets = new ArrayList<Asset>();
        screenNode.setAssets(assets);
        List<GameObject> localeObjects = localeScreen.getGameObjects();
        if(localeObjects != null) {
            for(GameObject object : localeObjects) {
                assets.add(new Asset(object));
            }
        }
        List<LearningObjectiveCharacter> screenCharacters = screen.getCharacters();
        if(screenCharacters != null) {
            for(LearningObjectiveCharacter themeCharacter : screenCharacters) {
                LearningObjectiveCharacterType characterType = themeCharacter.getCharacterType();
                SharedCharacter localeCharacter = localeScreen.getCharacters().get(characterType);
                GameCharacter gameCharacter = characters.getCharacter(characterType);
                assets.add(new Asset(localeCharacter, gameCharacter, themeCharacter));
            }
        }

        List<GameText> screenInformationBoxes = screen.getInformationBoxes();
        Map<TextType, SharedInformationBox> localeInformationBoxes = localeScreen.getInformationBoxes();
        if(screenInformationBoxes != null) {
            for(GameText gameText : screenInformationBoxes) {
                assets.add(new Asset(localeInformationBoxes.get(gameText.getTextType()), gameText));
            }
        }

        List<GameButton> gameButtons = new ArrayList<GameButton>(screen.getButtons());
        if(screen instanceof LearningObjectiveChallenge) {
            LearningObjectiveChallenge challenge = (LearningObjectiveChallenge) screen;
            if(challenge.getChallengeOptions() != null) {
                gameButtons.addAll(challenge.getChallengeOptions());
            }
        }
        Map<ButtonLocationType, SharedButton> localeButtons = localeScreen.getButtons();
        if(gameButtons != null) {
            for(GameButton gameButton : gameButtons) {
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
                        case CURRENT_CHALLENGE:
                            behavior.setTransitionId(screenTransitions.get(TransitionType.CURRENT_CHALLENGE));
                            break;
                        case NEXT_CHALLENGE:
                            behavior.setTransitionId(screenTransitions.get(TransitionType.NEXT_CHALLENGE));
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
                        case NEXT_ACT:
                            behavior.setTransitionId(null);
                            break;
                    }
                }
                assets.add(asset);
            }
        }


        return screenNodes;
    }

    /**
     * Builds the additional screens tied to a challenge option
     * @param additionalScreens a list of additional screens
     * @param additionalScreenId the id of the first screen in the additional screens
     * @return a list of ScreenNode representing the built additional screens
     */
    private List<ScreenNode> buildAdditionalScreens(List<LearningObjectiveScreen> additionalScreens, UUID additionalScreenId) {
        List<ScreenNode> screenNodes = new ArrayList<ScreenNode>();
        UUID nextScreen = UUID.randomUUID();
        for(LearningObjectiveScreen screen : additionalScreens) {
            screenNodes.addAll(buildScreen(0, screen, localeScreens.get(screen.getType()), additionalScreenId, nextScreen));
            additionalScreenId = nextScreen;
            nextScreen = UUID.randomUUID();
        }

        return screenNodes;
    }

    public Map<ScreenType, LocaleScreen> getLocaleScreens() {
        return localeScreens;
    }

    @XmlElementWrapper(name = "LocaleScreens")
    public void setLocaleScreens(Map<ScreenType, LocaleScreen> localeScreens) {
        this.localeScreens = localeScreens;
    }

    public Map<TransitionType, UUID> getScreenTransitions() {
        return screenTransitions;
    }

    @XmlTransient
    public void setScreenTransitions(Map<TransitionType, UUID> screenTransitions) {
        this.screenTransitions = screenTransitions;
    }
}
