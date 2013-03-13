package edu.utdallas.gamegenerator.LearningObjective.Screen;

import edu.utdallas.gamegenerator.LearningObjective.Challenge.ChallengeOption;

import java.util.List;

/**
 * User: clocke
 * Date: 2/17/13
 * Time: 4:12 PM
 */
public class LearningObjectiveChallenge extends LearningObjectiveScreen {
    private List<ChallengeOption> challengeOptions;
    private int timer;

    @Override
    public ScreenType getType() {
        return ScreenType.CHALLENGE;
    }

    public List<ChallengeOption> getChallengeOptions() {
        return challengeOptions;
    }

    public void setChallengeOptions(List<ChallengeOption> challengeOptions) {
        this.challengeOptions = challengeOptions;
    }

    public int getTimer() {
        return timer;
    }

    public void setTimer(int timer) {
        this.timer = timer;
    }
}
