package edu.utdallas.gamegenerator;

import edu.utdallas.gamegenerator.Characters.NPCCharacter;
import edu.utdallas.gamegenerator.Characters.PlayerCharacter;
import edu.utdallas.gamegenerator.Characters.GameCharacter;
import edu.utdallas.gamegenerator.LearningObjective.Challenge.ChallengeOption;
import edu.utdallas.gamegenerator.LearningObjective.Challenge.ChallengeOptionType;
import edu.utdallas.gamegenerator.LearningObjective.Challenge.Reward;
import edu.utdallas.gamegenerator.LearningObjective.Character.LearningObjectiveCharacterType;
import edu.utdallas.gamegenerator.LearningObjective.LearningObjective;
import edu.utdallas.gamegenerator.LearningObjective.Lesson;
import edu.utdallas.gamegenerator.LearningObjective.Screen.LearningObjectiveChallenge;
import edu.utdallas.gamegenerator.LearningObjective.Screen.ScreenType;
import edu.utdallas.gamegenerator.LearningObjective.Screen.TransitionType;
import edu.utdallas.gamegenerator.Locale.*;
import edu.utdallas.gamegenerator.Shared.SharedButton;
import edu.utdallas.gamegenerator.Shared.SharedCharacter;
import edu.utdallas.gamegenerator.Shared.GameObject;
import edu.utdallas.gamegenerator.Structure.Structure;
import edu.utdallas.gamegenerator.Subject.Subject;
import edu.utdallas.gamegenerator.Theme.Theme;
import edu.utdallas.gamegenerator.Theme.ThemeScreen;

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
    private PlayerCharacter playerCharacter;
    private NPCCharacter npcCharacter;
    private LearningObjective learningObjective;
    private Locale locale;
    private Structure structure;
    private Subject subject;
    private Theme theme;

    public TestObjects() {
        createPlayer();
        createNPC();
        createLearningObjective();
        createSubject();
        createTheme();
        createLocale();
        createStructure();
    }

    private void createLocale() {
        locale = new Locale();
        Map<ScreenType, String> backgrounds = new HashMap<ScreenType, String>();
        backgrounds.put(ScreenType.CHALLENGE, "");
        backgrounds.put(ScreenType.NEUTRAL, "");
        backgrounds.put(ScreenType.FAILURE, "");
        backgrounds.put(ScreenType.LESSON, "");
        backgrounds.put(ScreenType.SUCCESS, "");
        locale.setBackgrounds(backgrounds);

        Map<ScreenType, Map<String, GameObject>> buttons = new HashMap<ScreenType, Map<String, GameObject>>();
        Map<String, GameObject> buttonButtons = new HashMap<String, GameObject>();
        buttonButtons.put("option1", new GameObject(10,10,10,10,""));
        buttons.put(ScreenType.CHALLENGE, buttonButtons);
        locale.setButtons(buttons);
        Map<ScreenType, List<GameObject>> gameObjectsMap = new HashMap<ScreenType, List<GameObject>>();

        List<GameObject> gameObjects = new ArrayList<GameObject>();
        gameObjects.add(new GameObject(100,100,100,100,""));
        gameObjectsMap.put(ScreenType.CHALLENGE, gameObjects);

        locale.setGameObjects(gameObjectsMap);

        List<LearningObjective> learningObjectives = new ArrayList<LearningObjective>();
        learningObjectives.add(learningObjective);
        locale.setLearningObjectives(learningObjectives);

        Map<ScreenType, Map<String, SharedCharacter>> localeCharactersMap = new HashMap<ScreenType, Map<String, SharedCharacter>>();
        Map<String, SharedCharacter> localeCharacters = new HashMap<String, SharedCharacter>();
        List<ObjectMovement> movements = new ArrayList<ObjectMovement>();
        movements.add(new ObjectMovement(ObjectMovementType.WALK, 1, 1, 5, 5));
        localeCharacters.put("hero", new SharedCharacter(200, 200, 100, 100, null, LearningObjectiveCharacterType.HERO,
                movements));
        movements = new ArrayList<ObjectMovement>();
        movements.add(new ObjectMovement(ObjectMovementType.WALK, 1, 1, 5, 5));
        localeCharacters.put("villian", new SharedCharacter(200, 200, 100, 100, null, LearningObjectiveCharacterType.HERO,
                movements));
        movements = new ArrayList<ObjectMovement>();
        movements.add(new ObjectMovement(ObjectMovementType.WALK, 1, 1, 5, 5));
        localeCharacters.put("alt", new SharedCharacter(200, 200, 100, 100, null, LearningObjectiveCharacterType.HERO,
                movements));
        locale.setLocaleCharacters(localeCharactersMap);

        locale.setNpcCharacters(npcCharacter);
        locale.setPlayerCharacter(playerCharacter);
        locale.setTheme(theme);
    }

    private void createLearningObjective() {
        learningObjective = new LearningObjective();
        List<Lesson> lessons = new ArrayList<Lesson>();
        Lesson lesson = new Lesson();
        List<LearningObjectiveChallenge> challenges = new ArrayList<LearningObjectiveChallenge>();
        LearningObjectiveChallenge challenge = new LearningObjectiveChallenge();
        challenge.setButtons(null);
        challenge.setCharacters(null);
        challenge.setTexts(null);
        challenge.setTimer(0);
        List<ChallengeOption> challengeOptions = new ArrayList<ChallengeOption>();
        challengeOptions.add(new ChallengeOption(ChallengeOptionType.BUTTON, "option 1", new Reward(), TransitionType.NEXT_ACT, null));
        challenge.setChallengeOptions(challengeOptions);
        challenges.add(challenge);
        challenges.add(challenge);
        lesson.setLessonChallenges(challenges);
        lessons.add(lesson);
        lessons.add(lesson);
        learningObjective.setLessons(lessons);

    }

    private void createTheme() {
        theme = new Theme();
        List<ThemeScreen> themeScreens = new ArrayList<ThemeScreen>();
        ThemeScreen screen = new ThemeScreen();
        screen.setBackground("");
        Map<String,SharedButton> buttons = new HashMap<String, SharedButton>();
        buttons.put("intro1_next", new SharedButton("button intro 1",10, 30, 350, 350, ""));
        screen.setButtons(buttons);
        List<GameObject> gameObjects = new ArrayList<GameObject>();
        gameObjects.add(new GameObject(100, 100, 100, 100, ""));
        screen.setGameObjects(gameObjects);
        Map<String, SharedCharacter> themeCharacters = new HashMap<String, SharedCharacter>();
        List<ObjectMovement> movements = new ArrayList<ObjectMovement>();
        movements.add(new ObjectMovement(ObjectMovementType.WALK, 1, 1, 5, 5));
        themeCharacters.put("hero", new SharedCharacter(200, 200, 100, 100, null, LearningObjectiveCharacterType.HERO,
                movements));
        movements = new ArrayList<ObjectMovement>();
        movements.add(new ObjectMovement(ObjectMovementType.WALK, 1, 1, 5, 5));
        themeCharacters.put("villian", new SharedCharacter(200, 200, 100, 100, null, LearningObjectiveCharacterType.HERO,
                movements));
        movements = new ArrayList<ObjectMovement>();
        movements.add(new ObjectMovement(ObjectMovementType.WALK, 1, 1, 5, 5));
        themeCharacters.put("alt", new SharedCharacter(200, 200, 100, 100, null, LearningObjectiveCharacterType.HERO,
                movements));
        screen.setThemeCharacters(themeCharacters);
        themeScreens.add(screen);

        theme.setIntroScreens(themeScreens);
        theme.setSubject(subject);
        theme.setNpcCharacters(npcCharacter);
        theme.setPlayerCharacter(playerCharacter);
    }

    private void createStructure() {
        structure = new Structure();
        structure.setLocale(locale);
        structure.setTheme(theme);
    }

    private void createNPC() {
        npcCharacter = new NPCCharacter();
        GameCharacter hero = new GameCharacter();
        hero.setName("Sir Solvesalot");
        hero.setDirectory("character_22");
        hero.setPrefix("char22");
        hero.setCharacterAssets(buildCharacterAssets());

        GameCharacter villian = new GameCharacter();
        villian.setName("Calcatron");
        villian.setDirectory("character_21");
        villian.setPrefix("char21");
        villian.setCharacterAssets(buildCharacterAssets());

        GameCharacter alt = new GameCharacter();
        alt.setName("TI-83+");
        alt.setDirectory("character_15");
        alt.setPrefix("char15");
        alt.setCharacterAssets(buildCharacterAssets());

        npcCharacter.setHero(hero);
        npcCharacter.setVillain(villian);
        npcCharacter.setAlt(alt);
    }

    private Map<String, String> buildCharacterAssets() {
        Map<String, String> characterAssets = new HashMap<String, String>();
        characterAssets.put("standing", "REvil.png");
        characterAssets.put("walkright1", "WalkLBehind.png");
        characterAssets.put("walkright2", "WalkROpen.png");
        characterAssets.put("walkleft1", "WalkRBehind.png");
        characterAssets.put("walkleft2", "WalkLOpen.png");
        return characterAssets;
    }

    private void createPlayer() {
        playerCharacter = new PlayerCharacter();
        playerCharacter.setName("Ric");
        playerCharacter.setDirectory("character_1");
        playerCharacter.setPrefix("char1");
        playerCharacter.setCharacterAssets(buildCharacterAssets());
    }

    private void createSubject() {
        subject = new Subject();
        subject.setSubject("Algebra");
        subject.setIntroText("Algebra Adventure");
    }

    public PlayerCharacter getPlayerCharacter() {
        return playerCharacter;
    }

    public void setPlayerCharacter(PlayerCharacter playerCharacter) {
        this.playerCharacter = playerCharacter;
    }

    public NPCCharacter getNpcCharacter() {
        return npcCharacter;
    }

    public void setNpcCharacter(NPCCharacter npcCharacter) {
        this.npcCharacter = npcCharacter;
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
