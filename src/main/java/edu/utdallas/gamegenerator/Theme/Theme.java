package edu.utdallas.gamegenerator.Theme;

import edu.utdallas.gamegenerator.Asset;
import edu.utdallas.gamegenerator.Behavior;
import edu.utdallas.gamegenerator.BehaviorType;
import edu.utdallas.gamegenerator.Characters.GameCharacter;
import edu.utdallas.gamegenerator.Characters.NPCCharacter;
import edu.utdallas.gamegenerator.Characters.PlayerCharacter;
import edu.utdallas.gamegenerator.LearningObjective.Character.LearningObjectiveCharacterType;
import edu.utdallas.gamegenerator.LearningObjective.Screen.TransitionType;
import edu.utdallas.gamegenerator.ScreenNode;
import edu.utdallas.gamegenerator.Shared.GameObject;
import edu.utdallas.gamegenerator.Shared.SharedButton;
import edu.utdallas.gamegenerator.Shared.SharedCharacter;
import edu.utdallas.gamegenerator.Shared.SharedInformationBox;
import edu.utdallas.gamegenerator.Subject.Subject;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/**
 * User: clocke
 * Date: 2/17/13
 * Time: 6:04 PM
 */
@XmlRootElement(name = "Theme")
public class Theme {
    private Subject subject;
    private PlayerCharacter playerCharacter;
    private NPCCharacter npcCharacters;
    private List<ThemeScreen> introScreens;
    private List<ThemeScreen> outroScreens;
    private List<ThemeStory> themeStories;

    public List<ScreenNode> getIntro() {
        return (introScreens != null ? getScreens(introScreens) : new ArrayList<ScreenNode>());
    }

    public List<ScreenNode> getOutro() {
        return (outroScreens != null ? getScreens(outroScreens) : new ArrayList<ScreenNode>());
    }

    private List<ScreenNode> getScreens(List<ThemeScreen> screens) {
        List<ScreenNode> screenNodes = new ArrayList<ScreenNode>();
        UUID currentScreen = UUID.randomUUID();
        UUID nextScreen = UUID.randomUUID();
        for(ThemeScreen screen : screens) {
            ScreenNode screenNode = new ScreenNode();
            screenNode.setId(currentScreen);
            screenNode.setBackground(screen.getBackground());
            List<Asset> assets = new ArrayList<Asset>();
            if(screen.getGameObjects() != null) {
                for(GameObject object : screen.getGameObjects()) {
                    assets.add(new Asset(object));
                }
            }
            if(screen.getThemeCharacters() != null) {
                for(SharedCharacter character : screen.getThemeCharacters().values()) {
                    GameCharacter gameCharacter = null;
                    LearningObjectiveCharacterType characterType = character.getCharacterType();
                    if(characterType == LearningObjectiveCharacterType.PLAYER) {
                        gameCharacter = playerCharacter;
                    } else {
                        gameCharacter = npcCharacters.getCharacter(characterType);
                    }

                    assets.add(new Asset(character, gameCharacter));
                }
            }
            if(screen.getInformationBoxes() != null) {
                for(SharedInformationBox informationBox : screen.getInformationBoxes()) {
                    assets.add(new Asset(informationBox));
                }
            }
            if(screen.getButtons() != null) {
                for(SharedButton button : screen.getButtons().values()) {
                    Asset asset = new Asset(button);
                    if(asset.getBehaviors() != null) {
                        for(Behavior behavior : asset.getBehaviors()) {
                            if(BehaviorType.TRANSITION_BEHAVIOR == behavior.getBehaviorType() &&
                                    TransitionType.NEXT_SCREEN == behavior.getTransition()) {
                                behavior.setTransitionId(nextScreen);
                            }
                        }
                    }
                    assets.add(asset);
                }
            }
            screenNode.setAssets(assets);
            screenNodes.add(screenNode);
            currentScreen = nextScreen;
            nextScreen = UUID.randomUUID();
        }
        return screenNodes;
    }

    public Subject getSubject() {
        return subject;
    }

    @XmlTransient
    public void setSubject(Subject subject) {
        this.subject = subject;
    }

    public PlayerCharacter getPlayerCharacter() {
        return playerCharacter;
    }

    @XmlTransient
    public void setPlayerCharacter(PlayerCharacter playerCharacter) {
        this.playerCharacter = playerCharacter;
    }

    public NPCCharacter getNpcCharacters() {
        return npcCharacters;
    }

    @XmlTransient
    public void setNpcCharacters(NPCCharacter npcCharacters) {
        this.npcCharacters = npcCharacters;
    }

    public List<ThemeScreen> getIntroScreens() {
        return introScreens;
    }

    @XmlElementWrapper(name = "IntroScreens")
    @XmlElement(name = "IntroScreen")
    public void setIntroScreens(List<ThemeScreen> introScreens) {
        this.introScreens = introScreens;
    }

    public List<ThemeScreen> getOutroScreens() {
        return outroScreens;
    }

    @XmlElementWrapper(name = "OutroScreens")
    @XmlElement(name = "OutroScreen")
    public void setOutroScreens(List<ThemeScreen> outroScreens) {
        this.outroScreens = outroScreens;
    }

    public List<ThemeStory> getThemeStories() {
        return themeStories;
    }

    @XmlElementWrapper(name = "ThemeStories")
    @XmlElement(name = "ThemeStory")
    public void setThemeStories(List<ThemeStory> themeStories) {
        this.themeStories = themeStories;
    }
}
