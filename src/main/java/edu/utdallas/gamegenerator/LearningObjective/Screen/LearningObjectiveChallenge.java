package edu.utdallas.gamegenerator.LearningObjective.Screen;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * User: clocke
 * Date: 2/17/13
 * Time: 4:12 PM
 */
@XmlRootElement(name = "LearningObjectiveChallenge")
public class LearningObjectiveChallenge extends LearningObjectiveScreen {
    private int timer;

    @Override
    public ScreenType getType() {
        return ScreenType.CHALLENGE;
    }

    public int getTimer() {
        return timer;
    }

    @XmlElement(name = "Timer")
    public void setTimer(int timer) {
        this.timer = timer;
    }
}
