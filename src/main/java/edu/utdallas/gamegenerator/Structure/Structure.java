package edu.utdallas.gamegenerator.Structure;

import edu.utdallas.gamegenerator.Asset;
import edu.utdallas.gamegenerator.Behavior;
import edu.utdallas.gamegenerator.BehaviorType;
import edu.utdallas.gamegenerator.Locale.Locale;
import edu.utdallas.gamegenerator.ScreenNode;
import edu.utdallas.gamegenerator.Theme.Theme;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/**
 * User: clocke
 * Date: 2/17/13
 * Time: 6:52 PM
 */
public class Structure {
    private Theme theme;
    private Locale locale;
    private List<Act> acts;
    private Game game;

    public Game createGame() {
        acts = new ArrayList<Act>();
        acts.add(createActFromScreens(theme.getIntro()));
        for(int i = 0; i < locale.getLearningObjectives().size(); i++) {
            acts.add(createActFromScreens(locale.getAct(i)));
        }
        acts.add(createActFromScreens(theme.getOutro()));
        game = new Game();
        game.setActs(acts);

        wireUpActs(acts);
        //Generate xml for game
        return null;
    }

    private void wireUpActs(List<Act> acts) {
        for(int i = 0; i < acts.size() - 1; i++) {
            Act act = acts.get(i);
            UUID nextActId = acts.get(i+1).getScenes().get(0).getScreens().get(0).getId();
            for(Scene scene : act.getScenes()) {
                ScreenNode screenNode = scene.getScreens().get(0);
                if(screenNode.getAssets() != null) {
                    for(Asset asset : screenNode.getAssets()) {
                        if(asset.getBehaviors() != null) {
                            for(Behavior behavior : asset.getBehaviors()) {
                                if(BehaviorType.TRANSITION_BEHAVIOR.equals(behavior.getBehaviorType()) &&
                                        behavior.getTransitionId() == null) {
                                    behavior.setTransitionId(nextActId);
                                }
                            }
                        }
                    }
                }
            }
        }
    }

    private Act createActFromScreens(List<ScreenNode> screenNodes) {
        Act act = new Act();
        List<Scene> scenes = new ArrayList<Scene>();
        for(int i = 0; i < screenNodes.size(); i++) {
            Scene scene = new Scene();
            scene.setScreens(screenNodes.subList(i,i+1));
            scene.setBackground(screenNodes.get(i).getBackground());
            scenes.add(scene);
        }
        act.setScenes(scenes);
        return act;
    }

    public Theme getTheme() {
        return theme;
    }

    public void setTheme(Theme theme) {
        this.theme = theme;
    }

    public Locale getLocale() {
        return locale;
    }

    public void setLocale(Locale locale) {
        this.locale = locale;
    }

    public List<Act> getActs() {
        return acts;
    }

    public void setActs(List<Act> acts) {
        this.acts = acts;
    }
}
