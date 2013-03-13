package edu.utdallas.gamegenerator.Structure;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

/**
 * User: clocke
 * Date: 2/24/13
 * Time: 8:58 PM
 */
@XmlRootElement(name = "Scene")
public class Scene {
    List<Screen> screens;

    public List<Screen> getScreens() {
        return screens;
    }

    @XmlElement(name = "Screens")
    public void setScreens(List<Screen> screens) {
        this.screens = screens;
    }
}
