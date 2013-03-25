package edu.utdallas.gamegenerator.Theme;

import edu.utdallas.gamegenerator.LearningObjective.Screen.LearningObjectiveScreen;

import java.util.ArrayList;
import java.util.List;

/**
 * User: clocke
 * Date: 3/12/13
 * Time: 9:23 PM
 */
public class ThemeStory {
    private List<ThemeStoryScreenIntro> intro;
    private List<ThemeStoryScreenOutro> outro;

    public List<LearningObjectiveScreen> getIntro() {
        List<LearningObjectiveScreen> screens = new ArrayList<LearningObjectiveScreen>();
        for(ThemeStoryScreenIntro themeScreen : intro) {
            screens.add(themeScreen);
        }
        return screens;
    }

    public void setIntro(List<ThemeStoryScreenIntro> intro) {
        this.intro = intro;
    }

    public List<LearningObjectiveScreen> getOutro() {
        List<LearningObjectiveScreen> screens = new ArrayList<LearningObjectiveScreen>();
        for(ThemeStoryScreenOutro themeScreen : outro) {
            screens.add(themeScreen);
        }
        return screens;
    }

    public void setOutro(List<ThemeStoryScreenOutro> outro) {
        this.outro = outro;
    }
}
