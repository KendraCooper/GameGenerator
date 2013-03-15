package edu.utdallas.gamegenerator.LearningObjective.Character;

import edu.utdallas.gamegenerator.Locale.ObjectMovementType;
import edu.utdallas.gamegenerator.Shared.GameObject;

/**
 * User: clocke
 * Date: 2/17/13
 * Time: 3:29 PM
 */
public class LearningObjectiveCharacter extends GameObject {
    private LearningObjectiveCharacterType characterType;
    private ObjectMovementType movementType;
    private int timer;

    public LearningObjectiveCharacterType getCharacterType() {
        return characterType;
    }

    public void setCharacterType(LearningObjectiveCharacterType characterType) {
        this.characterType = characterType;
    }

    public ObjectMovementType getMovementType() {
        return movementType;
    }

    public void setMovementType(ObjectMovementType movementType) {
        this.movementType = movementType;
    }

    public int getTimer() {
        return timer;
    }

    public void setTimer(int timer) {
        this.timer = timer;
    }
}
