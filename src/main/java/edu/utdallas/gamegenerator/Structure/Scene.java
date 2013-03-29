package edu.utdallas.gamegenerator.Structure;

import edu.utdallas.gamegenerator.Asset;
import edu.utdallas.gamegenerator.Behavior;
import edu.utdallas.gamegenerator.ScreenNode;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;
import java.util.UUID;

/**
 * User: clocke
 * Date: 2/24/13
 * Time: 8:58 PM
 */
@XmlRootElement(name = "Scene")
public class Scene {
    List<ScreenNode> screens;
    String background;
    String name;
    UUID id = UUID.randomUUID();
    List<Behavior> behaviorList;
    List<Asset> assets;

    public List<ScreenNode> getScreens() {
        return screens;
    }

    @XmlElement(name = "Screens")
    public void setScreens(List<ScreenNode> screens) {
        this.screens = screens;
    }

    public String getBackground() {
        return background;
    }

    public void setBackground(String background) {
        this.background = background;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public List<Behavior> getBehaviorList() {
        return behaviorList;
    }

    public void setBehaviorList(List<Behavior> behaviorList) {
        this.behaviorList = behaviorList;
    }

    public List<Asset> getAssets() {
        return assets;
    }

    public void setAssets(List<Asset> assets) {
        this.assets = assets;
    }
}
