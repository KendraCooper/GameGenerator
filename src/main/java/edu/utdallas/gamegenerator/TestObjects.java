package edu.utdallas.gamegenerator;

import edu.utdallas.gamegenerator.Characters.*;
import edu.utdallas.gamegenerator.Characters.Characters;
import edu.utdallas.gamegenerator.LearningObjective.Challenge.ChallengeOption;
import edu.utdallas.gamegenerator.LearningObjective.Challenge.ChallengeOptionType;
import edu.utdallas.gamegenerator.LearningObjective.Challenge.Reward;
import edu.utdallas.gamegenerator.LearningObjective.Character.LearningObjectiveCharacter;
import edu.utdallas.gamegenerator.LearningObjective.Character.LearningObjectiveCharacterType;
import edu.utdallas.gamegenerator.LearningObjective.LearningObjective;
import edu.utdallas.gamegenerator.LearningObjective.Lesson;
import edu.utdallas.gamegenerator.LearningObjective.Prop.GameButton;
import edu.utdallas.gamegenerator.LearningObjective.Prop.GameText;
import edu.utdallas.gamegenerator.LearningObjective.Prop.TextType;
import edu.utdallas.gamegenerator.LearningObjective.Screen.*;
import edu.utdallas.gamegenerator.Locale.Locale;
import edu.utdallas.gamegenerator.Locale.LocaleScreen;
import edu.utdallas.gamegenerator.Locale.ObjectMovement;
import edu.utdallas.gamegenerator.Locale.ObjectMovementType;
import edu.utdallas.gamegenerator.Shared.*;
import edu.utdallas.gamegenerator.Structure.Structure;
import edu.utdallas.gamegenerator.Subject.Subject;
import edu.utdallas.gamegenerator.Theme.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * User: clocke
 * Date: 2/28/13
 * Time: 7:56 PM
 */
public class TestObjects {
    private Characters characters;
    private LearningObjective learningObjective;
    private Locale locale;
    private Structure structure;
    private Subject subject;
    private Theme theme;

    public TestObjects() {
        createNPC();
        createLearningObjective();
        createSubject();
        createTheme();
        createLocale();
        createStructure();
    }

    private void createLocale() {
        Map<ScreenType, LocaleScreen> localeScreenMap = new HashMap<ScreenType, LocaleScreen>();
        LocaleScreen localeScreen = new LocaleScreen();

        localeScreenMap.put(ScreenType.LESSON_STORY_INTRO, localeScreen);
        localeScreenMap.put(ScreenType.LESSON_STORY_OUTRO, localeScreen);
        localeScreenMap.put(ScreenType.LESSON, localeScreen);
        localeScreenMap.put(ScreenType.CHALLENGE, localeScreen);
        localeScreenMap.put(ScreenType.FAILURE, localeScreen);

        localeScreen.setBackground("locale screen background");



        locale = new Locale();
        Map<ScreenType, String> backgrounds = new HashMap<ScreenType, String>();
        backgrounds.put(ScreenType.CHALLENGE, "");
        backgrounds.put(ScreenType.NEUTRAL, "");
        backgrounds.put(ScreenType.FAILURE, "");
        backgrounds.put(ScreenType.LESSON, "");
        backgrounds.put(ScreenType.SUCCESS, "");
        backgrounds.put(ScreenType.LESSON_STORY_INTRO, "");
        backgrounds.put(ScreenType.LESSON_STORY_OUTRO, "");

        Map<ScreenType, Map<ButtonLocationType, SharedButton>> buttons = new HashMap<ScreenType, Map<ButtonLocationType, SharedButton>>();
        Map<ButtonLocationType, SharedButton> buttonButtons = new HashMap<ButtonLocationType, SharedButton>();
        buttonButtons.put(ButtonLocationType.NEXT, new SharedButton("",10,10,10,10, null));
        buttonButtons.put(ButtonLocationType.CHALLENGE_1, new SharedButton("",10,10,10,10, null));
        buttonButtons.put(ButtonLocationType.CHALLENGE_2, new SharedButton("",10,10,10,10, null));
        buttons.put(ScreenType.CHALLENGE, buttonButtons);
        Map<ScreenType, List<GameObject>> gameObjectsMap = new HashMap<ScreenType, List<GameObject>>();

        List<GameObject> gameObjects = getGameObjects();
        gameObjectsMap.put(ScreenType.CHALLENGE, gameObjects);


        List<LearningObjective> learningObjectives = new ArrayList<LearningObjective>();
        learningObjectives.add(learningObjective);
        locale.setLearningObjectives(learningObjectives);

        Map<ScreenType, Map<LearningObjectiveCharacterType, SharedCharacter>> localeCharactersMap = new HashMap<ScreenType, Map<LearningObjectiveCharacterType, SharedCharacter>>();
        Map<LearningObjectiveCharacterType, SharedCharacter> localeCharacters = new HashMap<LearningObjectiveCharacterType, SharedCharacter>();
        List<ObjectMovement> movements = new ArrayList<ObjectMovement>();
        movements.add(new ObjectMovement(ObjectMovementType.WALK_ONTO_SCREEN, 1, 1, 5, 5));
        localeCharacters.put(LearningObjectiveCharacterType.HERO, new SharedCharacter(200, 200, 100, 100, null, LearningObjectiveCharacterType.HERO,
                movements));
        movements = new ArrayList<ObjectMovement>();
        movements.add(new ObjectMovement(ObjectMovementType.WALK_ONTO_SCREEN, 1, 1, 5, 5));
        localeCharacters.put(LearningObjectiveCharacterType.VILLIAN, new SharedCharacter(200, 200, 100, 100, null, LearningObjectiveCharacterType.VILLIAN,
                movements));
        movements = new ArrayList<ObjectMovement>();
        movements.add(new ObjectMovement(ObjectMovementType.WALK_ONTO_SCREEN, 1, 1, 5, 5));
        localeCharacters.put(LearningObjectiveCharacterType.ALT, new SharedCharacter(200, 200, 100, 100, null, LearningObjectiveCharacterType.ALT,
                movements));
        localeCharactersMap.put(ScreenType.LESSON, localeCharacters);

        Map<TextType, SharedInformationBox> informationBoxMap = new HashMap<TextType, SharedInformationBox>();
        SharedInformationBox informationBox = new SharedInformationBox(100, 100, 100, 100, "", "hero");
        informationBoxMap.put(TextType.HERO, informationBox);


        locale.setCharacters(characters);
        locale.setTheme(theme);

        localeScreen.setButtons(buttonButtons);
        localeScreen.setCharacters(localeCharacters);
        localeScreen.setGameObjects(gameObjects);


        localeScreen.setInformationBoxes(informationBoxMap);

        locale.setLocaleScreens(localeScreenMap);
    }

    private List<GameObject> getGameObjects() {
        List<GameObject> gameObjects = new ArrayList<GameObject>();
        gameObjects.add(new GameObject(100,100,100,100,""));
        return gameObjects;
    }

    private void createLearningObjective() {
        learningObjective = new LearningObjective();
        List<Lesson> lessons = new ArrayList<Lesson>();
        Lesson lesson = new Lesson();
        List<LearningObjectiveLesson> learningObjectiveScreens = new ArrayList<LearningObjectiveLesson>();
        LearningObjectiveLesson learningObjectiveLesson = new LearningObjectiveLesson();
        learningObjectiveLesson.setInformationBoxes(getGameTexts());
        learningObjectiveLesson.setButtons(getGameButtons());
        learningObjectiveLesson.setCharacters(getLearningObjectiveCharacters());
        learningObjectiveScreens.add(learningObjectiveLesson);
        learningObjectiveScreens.add(learningObjectiveLesson);
        lesson.setLessonScreens(learningObjectiveScreens);
        lessons.add(lesson);

        List<LearningObjectiveChallenge> challenges = new ArrayList<LearningObjectiveChallenge>();
        LearningObjectiveChallenge challenge = new LearningObjectiveChallenge();
        challenge.setButtons(null);
        challenge.setCharacters(getLearningObjectiveCharacters());
        challenge.setInformationBoxes(getGameTexts());
        challenge.setTimer(0);
        LearningObjectiveScreen screen = new LearningObjectiveFailure();
        screen.setCharacters(getLearningObjectiveCharacters());
        screen.setButtons(getGameButtons());
        screen.setInformationBoxes(getGameTexts());
        List<LearningObjectiveScreen> learningObjectiveScreens1 = new ArrayList<LearningObjectiveScreen>();
        learningObjectiveScreens1.add(screen);
        LearningObjectiveScreen screen1 = screen.clone();
        screen1.getButtons().get(0).setTransitionType(TransitionType.NEXT_CHALLENGE);
        learningObjectiveScreens1.add(screen);
        List<ChallengeOption> challengeOptions = new ArrayList<ChallengeOption>();
        challengeOptions.add(new ChallengeOption(ChallengeOptionType.BUTTON, "additional screens", new Reward(), TransitionType.ADDITIONAL, learningObjectiveScreens1, ButtonLocationType.CHALLENGE_1));
        challengeOptions.add(new ChallengeOption(ChallengeOptionType.BUTTON, "end of story", null, TransitionType.END_OF_STORY, null, ButtonLocationType.CHALLENGE_2));
        challenge.setChallengeOptions(challengeOptions);
        challenge.setButtons(getGameButtons());
        challenges.add(challenge);
        challenges.add(challenge);
        lesson.setLessonChallenges(challenges);
        learningObjective.setLessons(lessons);

    }

    private void createTheme() {
        theme = new Theme();
        List<ThemeScreen> themeScreens = new ArrayList<ThemeScreen>();
        ThemeScreen screen = new ThemeScreen();
        screen.setBackground("");
        Map<ButtonLocationType, SharedButton> buttons = new HashMap<ButtonLocationType, SharedButton>();
        Behavior behavior = new Behavior();
        buttons.put(ButtonLocationType.NEXT, new SharedButton("button intro 1",10, 30, 350, 350, new Behavior(BehaviorType.TRANSITION_BEHAVIOR)));
        screen.setButtons(buttons);
        List<GameObject> gameObjects = getGameObjects();
        screen.setGameObjects(gameObjects);
        Map<LearningObjectiveCharacterType, SharedCharacter> themeCharacters = new HashMap<LearningObjectiveCharacterType, SharedCharacter>();
        List<ObjectMovement> movements = new ArrayList<ObjectMovement>();
        movements.add(new ObjectMovement(ObjectMovementType.WALK_ONTO_SCREEN, 1, 1, 5, 5));
        themeCharacters.put(LearningObjectiveCharacterType.HERO, new SharedCharacter(200, 200, 100, 100, null, LearningObjectiveCharacterType.HERO,
                movements));
        movements = new ArrayList<ObjectMovement>();
        movements.add(new ObjectMovement(ObjectMovementType.WALK_OFF_SCREEN, 1, 1, 5, 5));
        themeCharacters.put(LearningObjectiveCharacterType.VILLIAN, new SharedCharacter(200, 200, 100, 100, null, LearningObjectiveCharacterType.HERO,
                movements));
        movements = new ArrayList<ObjectMovement>();
        movements.add(new ObjectMovement(ObjectMovementType.WALK_ONTO_SCREEN, 1, 1, 5, 5));
        themeCharacters.put(LearningObjectiveCharacterType.ALT, new SharedCharacter(200, 200, 100, 100, null, LearningObjectiveCharacterType.HERO,
                movements));
        screen.setThemeCharacters(themeCharacters);
        themeScreens.add(screen);

        List<ThemeStory> themeStories = new ArrayList<ThemeStory>();
        ThemeStory themeStory = new ThemeStory();
        List<ThemeStoryScreenIntro> themeStoryScreenIntros = new ArrayList<ThemeStoryScreenIntro>();
        ThemeStoryScreenIntro screenIntro = new ThemeStoryScreenIntro();

        List<LearningObjectiveCharacter> learningObjectiveCharacters = getLearningObjectiveCharacters();
        screenIntro.setCharacters(learningObjectiveCharacters);

        List<GameButton> gameButtons = getGameButtons();
        screenIntro.setButtons(gameButtons);

        List<GameText> gameTexts = getGameTexts();
        screenIntro.setInformationBoxes(gameTexts);

        themeStoryScreenIntros.add(screenIntro);
        themeStoryScreenIntros.add(screenIntro);
        themeStory.setIntro(themeStoryScreenIntros);

        gameButtons = getGameButtons();
        gameButtons.get(0).setTransitionType(TransitionType.NEXT_ACT);
        List<ThemeStoryScreenOutro> themeStoryScreenOutros = new ArrayList<ThemeStoryScreenOutro>();
        ThemeStoryScreenOutro themeStoryScreenOutro = new ThemeStoryScreenOutro();
        themeStoryScreenOutro.setCharacters(learningObjectiveCharacters);
        themeStoryScreenOutro.setButtons(gameButtons);
        themeStoryScreenOutro.setInformationBoxes(gameTexts);
        themeStoryScreenOutros.add(themeStoryScreenOutro);
        themeStory.setOutro(themeStoryScreenOutros);

        themeStories.add(themeStory);
        theme.setThemeStories(themeStories);
        theme.setIntroScreens(themeScreens);
        theme.setOutroScreens(themeScreens);
        theme.setSubject(subject);
        theme.setCharacters(characters);
    }

    private List<GameText> getGameTexts() {
        List<GameText> gameTexts = new ArrayList<GameText>();
        GameText gameText = new GameText();
        gameText.setTextType(TextType.HERO);
        gameText.setText("Hi");

        gameTexts.add(gameText);
        return gameTexts;
    }

    private List<GameButton> getGameButtons() {
        List<GameButton> gameButtons = new ArrayList<GameButton>();
        GameButton gameButton = new GameButton();
        gameButton.setReward(new Reward(500));
        gameButton.setButtonLocationType(ButtonLocationType.NEXT);
        gameButton.setText("Next");
        gameButton.setTransitionType(TransitionType.NEXT_SCREEN);

        gameButtons.add(gameButton);
        return gameButtons;
    }

    private List<LearningObjectiveCharacter> getLearningObjectiveCharacters() {
        List<LearningObjectiveCharacter> learningObjectiveCharacters = new ArrayList<LearningObjectiveCharacter>();
        LearningObjectiveCharacter character = new LearningObjectiveCharacter();
        character.setCharacterType(LearningObjectiveCharacterType.HERO);
        character.setMovementType(ObjectMovementType.WALK_ONTO_SCREEN);
        character.setTimer(100);
        learningObjectiveCharacters.add(character);
        return learningObjectiveCharacters;
    }

    private void createStructure() {
        structure = new Structure();
        structure.setLocale(locale);
        structure.setTheme(theme);
    }

    private void createNPC() {
        characters = new Characters();
        GameCharacter hero = new GameCharacter();
        hero.setName("Sir Solvesalot");
        hero.setDirectory("character_22");
        hero.setPrefix("char22");
        hero.getCharacterAsset(CharacterAssetType.STAND_SMILE_CLOSED);

        GameCharacter villian = new GameCharacter();
        villian.setName("Calcatron");
        villian.setDirectory("character_21");
        villian.setPrefix("char21");
        villian.getCharacterAsset(CharacterAssetType.STAND_SMILE_CLOSED);

        GameCharacter alt = new GameCharacter();
        alt.setName("TI-83+");
        alt.setDirectory("character_15");
        alt.setPrefix("char15");
        alt.getCharacterAsset(CharacterAssetType.STAND_SMILE_CLOSED);

        characters.setHero(hero);
        characters.setVillain(villian);
        characters.setAlt(alt);
    }

    private void createSubject() {
        subject = new Subject();
        subject.setSubject("Algebra");
        subject.setIntroText("Algebra Adventure");
    }

    public Characters getCharacters() {
        return characters;
    }

    public void setCharacters(Characters characters) {
        this.characters = characters;
    }

    public LearningObjective getLearningObjective() {
        return learningObjective;
    }

    public void setLearningObjective(LearningObjective learningObjective) {
        this.learningObjective = learningObjective;
    }

    public Locale getLocale() {
        return locale;
    }

    public void setLocale(Locale locale) {
        this.locale = locale;
    }

    public Structure getStructure() {
        return structure;
    }

    public void setStructure(Structure structure) {
        this.structure = structure;
    }

    public Subject getSubject() {
        return subject;
    }

    public void setSubject(Subject subject) {
        this.subject = subject;
    }

    public Theme getTheme() {
        return theme;
    }

    public void setTheme(Theme theme) {
        this.theme = theme;
    }
}
