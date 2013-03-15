package edu.utdallas.gamegenerator.LearningObjective.Prop;

import edu.utdallas.gamegenerator.LearningObjective.Screen.TransitionType;
import edu.utdallas.gamegenerator.Shared.ButtonLocationType;

/**
 * User: clocke
 * Date: 2/17/13
 * Time: 3:55 PM
 */
public class GameButton {
    private ButtonLocationType buttonLocationType;
    private String text;
    private int timer;
    private TransitionType type;

    public ButtonLocationType getButtonLocationType() {
        return buttonLocationType;
    }

    public void setButtonLocationType(ButtonLocationType buttonLocationType) {
        this.buttonLocationType = buttonLocationType;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public int getTimer() {
        return timer;
    }

    public void setTimer(int timer) {
        this.timer = timer;
    }

    public TransitionType getType() {
        return type;
    }

    public void setType(TransitionType type) {
        this.type = type;
    }
}
