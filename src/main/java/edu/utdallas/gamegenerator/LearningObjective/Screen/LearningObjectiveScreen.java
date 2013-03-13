package edu.utdallas.gamegenerator.LearningObjective.Screen;

import edu.utdallas.gamegenerator.LearningObjective.Character.LearningObjectiveCharacter;
import edu.utdallas.gamegenerator.LearningObjective.Prop.GameButton;
import edu.utdallas.gamegenerator.LearningObjective.Prop.GameText;

import java.util.List;

/**
 * User: clocke
 * Date: 2/17/13
 * Time: 3:46 PM
 */
public abstract class LearningObjectiveScreen {
    private List<GameText> texts;
    private List<GameButton> buttons;
    private List<LearningObjectiveCharacter> characters;

    public List<GameText> getTexts() {
        return texts;
    }

    public void setTexts(List<GameText> texts) {
        this.texts = texts;
    }

    public List<GameButton> getButtons() {
        return buttons;
    }

    public void setButtons(List<GameButton> buttons) {
        this.buttons = buttons;
    }

    public List<LearningObjectiveCharacter> getCharacters() {
        return characters;
    }

    public void setCharacters(List<LearningObjectiveCharacter> characters) {
        this.characters = characters;
    }

    public abstract ScreenType getType();
}
