package edu.utdallas.gamegenerator;

/**
 * Company: Porpoise Software
 * User: Terminus Est
 * Date: 3/17/13
 * Time: 7:09 PM
 */
public enum BehaviorType {
    REWARD_BEHAVIOR("RewardBehavior"),
    TRANSITION_BEHAVIOR("TransitionBehavior"),
    VISIBILITY_BEHAVIOR("VisibilityBehavior"),
    END_GAME_BEHAVIOR("EndGameBehavior");

    private String value;

    BehaviorType(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

}
