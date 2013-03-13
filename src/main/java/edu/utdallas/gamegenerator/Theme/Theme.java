package edu.utdallas.gamegenerator.Theme;

import edu.utdallas.gamegenerator.Asset;
import edu.utdallas.gamegenerator.Characters.NPCCharacter;
import edu.utdallas.gamegenerator.Characters.PlayerCharacter;
import edu.utdallas.gamegenerator.ScreenNode;
import edu.utdallas.gamegenerator.Shared.GameObject;
import edu.utdallas.gamegenerator.Shared.SharedButton;
import edu.utdallas.gamegenerator.Shared.SharedCharacter;
import edu.utdallas.gamegenerator.Shared.SharedInformationBox;
import edu.utdallas.gamegenerator.Subject.Subject;

import java.util.ArrayList;
import java.util.List;

/**
 * User: clocke
 * Date: 2/17/13
 * Time: 6:04 PM
 */
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
        for(ThemeScreen screen : screens) {
            ScreenNode screenNode = new ScreenNode();
            screenNode.setBackground(screen.getBackground());
            List<Asset> assets = new ArrayList<Asset>();
            if(screen.getGameObjects() != null) {
                for(GameObject object : screen.getGameObjects()) {
                    assets.add(new Asset(object));
                }
            }
            if(screen.getThemeCharacters() != null) {
                for(SharedCharacter character : screen.getThemeCharacters().values()) {
                    assets.add(new Asset(character));
                }
            }
            if(screen.getInformationBoxes() != null) {
                for(SharedInformationBox informationBox : screen.getInformationBoxes()) {
                    assets.add(new Asset(informationBox));
                }
            }
            if(screen.getButtons() != null) {
                for(SharedButton button : screen.getButtons().values()) {
                    assets.add(new Asset(button));
                }
            }
            screenNode.setAssets(assets);
            screenNodes.add(screenNode);
        }
        return screenNodes;
    }

    public Subject getSubject() {
        return subject;
    }

    public void setSubject(Subject subject) {
        this.subject = subject;
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

    public List<ThemeScreen> getIntroScreens() {
        return introScreens;
    }

    public void setIntroScreens(List<ThemeScreen> introScreens) {
        this.introScreens = introScreens;
    }

    public List<ThemeScreen> getOutroScreens() {
        return outroScreens;
    }

    public void setOutroScreens(List<ThemeScreen> outroScreens) {
        this.outroScreens = outroScreens;
    }

    public List<ThemeStory> getThemeStories() {
        return themeStories;
    }

    public void setThemeStories(List<ThemeStory> themeStories) {
        this.themeStories = themeStories;
    }
}
