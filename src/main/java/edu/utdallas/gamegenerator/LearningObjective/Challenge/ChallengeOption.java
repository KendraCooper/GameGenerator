package edu.utdallas.gamegenerator.LearningObjective.Challenge;

import edu.utdallas.gamegenerator.LearningObjective.Screen.LearningObjectiveScreen;
import edu.utdallas.gamegenerator.LearningObjective.Screen.TransitionType;

import java.util.List;

/**
 * User: clocke
 * Date: 2/17/13
 * Time: 3:13 PM
 */
public class ChallengeOption {
    private ChallengeOptionType challengeOptionType;
    private String text;
    private Reward reward;
    private TransitionType transitionType;
    private List<LearningObjectiveScreen> additionalScreens;

    public ChallengeOption() {
    }

    public ChallengeOption(ChallengeOptionType challengeOptionType, String text, Reward reward, TransitionType transitionType, List<LearningObjectiveScreen> additionalScreens) {
        this.challengeOptionType = challengeOptionType;
        this.text = text;
        this.reward = reward;
        this.transitionType = transitionType;
        this.additionalScreens = additionalScreens;
    }

    public ChallengeOptionType getChallengeOptionType() {
        return challengeOptionType;
    }

    public void setChallengeOptionType(ChallengeOptionType challengeOptionType) {
        this.challengeOptionType = challengeOptionType;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Reward getReward() {
        return reward;
    }

    public void setReward(Reward reward) {
        this.reward = reward;
    }

    public TransitionType getTransitionType() {
        return transitionType;
    }

    public void setTransitionType(TransitionType transitionType) {
        this.transitionType = transitionType;
    }

    public List<LearningObjectiveScreen> getAdditionalScreens() {
        return additionalScreens;
    }

    public void setAdditionalScreens(List<LearningObjectiveScreen> additionalScreens) {
        this.additionalScreens = additionalScreens;
    }
}
