package edu.utdallas.gamegenerator.Theme;

import edu.utdallas.gamegenerator.LearningObjective.Screen.LearningObjectiveScreen;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.ArrayList;
import java.util.List;

/**
 * User: clocke
 * Date: 3/12/13
 * Time: 9:23 PM
 */
@XmlRootElement(name = "ThemeStory")
public class ThemeStory {
    private List<ThemeStoryScreenIntro> intro;
    private List<ThemeStoryScreenOutro> outro;

    @XmlElementWrapper(name = "StoryIntroScreens")
    @XmlElement(name = "StoryIntroScreen")
    public List<LearningObjectiveScreen> getIntro() {
        List<LearningObjectiveScreen> screens = new ArrayList<LearningObjectiveScreen>();
        for(ThemeStoryScreenIntro themeScreen : intro) {
            screens.add(themeScreen);
        }
        return screens;
    }

    @XmlElementWrapper(name = "StoryIntroScreens")
    @XmlElement(name = "StoryIntroScreen")
    public void setIntro(List<ThemeStoryScreenIntro> intro) {
        this.intro = intro;
    }

    @XmlElementWrapper(name = "StoryOutroScreens")
    @XmlElement(name = "StoryOutroScreen")
    public List<LearningObjectiveScreen> getOutro() {
        List<LearningObjectiveScreen> screens = new ArrayList<LearningObjectiveScreen>();
        for(ThemeStoryScreenOutro themeScreen : outro) {
            screens.add(themeScreen);
        }
        return screens;
    }

    @XmlElementWrapper(name = "StoryOutroScreens")
    @XmlElement(name = "StoryOutroScreen")
    public void setOutro(List<ThemeStoryScreenOutro> outro) {
        this.outro = outro;
    }
}
