package edu.utdallas.gamegenerator.Theme;

/**
 * Company: Porpoise Software
 * User: Terminus Est
 * Date: 3/12/13
 * Time: 9:23 PM
 */
public class ThemeStory {
    private ThemeStoryScreenIntro intro;
    private ThemeStoryScreenOutro outro;

    public ThemeStoryScreenIntro getIntro() {
        return intro;
    }

    public void setIntro(ThemeStoryScreenIntro intro) {
        this.intro = intro;
    }

    public ThemeStoryScreenOutro getOutro() {
        return outro;
    }

    public void setOutro(ThemeStoryScreenOutro outro) {
        this.outro = outro;
    }
}
