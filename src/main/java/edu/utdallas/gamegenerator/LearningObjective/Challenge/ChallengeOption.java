package edu.utdallas.gamegenerator.LearningObjective.Challenge;

import edu.utdallas.gamegenerator.LearningObjective.Prop.GameButton;
import edu.utdallas.gamegenerator.LearningObjective.Screen.LearningObjectiveScreen;
import edu.utdallas.gamegenerator.LearningObjective.Screen.TransitionType;
import edu.utdallas.gamegenerator.Shared.ButtonLocationType;

import javax.xml.bind.annotation.XmlElement;
import java.util.List;

/**
 * User: clocke
 * Date: 2/17/13
 * Time: 3:13 PM
 */
public class ChallengeOption extends GameButton {
    private ChallengeOptionType challengeOptionType;
    private List<LearningObjectiveScreen> additionalScreens;

    public ChallengeOption() {
    }

    public ChallengeOption(ChallengeOptionType challengeOptionType, String text, Reward reward,
                           TransitionType transitionType, List<LearningObjectiveScreen> additionalScreens,
                           ButtonLocationType buttonLocationType) {
        this.challengeOptionType = challengeOptionType;
        setText(text);
        setReward(reward);
        setTransitionType(transitionType);
        setButtonLocationType(buttonLocationType);
        this.additionalScreens = additionalScreens;
    }

    public ChallengeOptionType getChallengeOptionType() {
        return challengeOptionType;
    }

    @XmlElement(name = "ChallengeOptionType")
    public void setChallengeOptionType(ChallengeOptionType challengeOptionType) {
        this.challengeOptionType = challengeOptionType;
    }

    public List<LearningObjectiveScreen> getAdditionalScreens() {
        return additionalScreens;
    }

    @XmlElement(name = "AdditionalScreens")
    public void setAdditionalScreens(List<LearningObjectiveScreen> additionalScreens) {
        this.additionalScreens = additionalScreens;
    }
}
