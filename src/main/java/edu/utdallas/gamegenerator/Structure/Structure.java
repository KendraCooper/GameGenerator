package edu.utdallas.gamegenerator.Structure;

import edu.utdallas.gamegenerator.Locale.Locale;
import edu.utdallas.gamegenerator.Theme.Theme;

import java.util.List;

/**
 * User: clocke
 * Date: 2/17/13
 * Time: 6:52 PM
 */
public class Structure {
    private Theme theme;
    private Locale locale;
    private List<Act> acts;

    public Game createGame() {

        return null;
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
