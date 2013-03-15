package edu.utdallas.gamegenerator.Characters;

/**
 * Company: Porpoise Software
 * User: Terminus Est
 * Date: 3/12/13
 * Time: 11:15 PM
 */
public enum CharacterAssetType {
    STAND_SMILE_CLOSED("StandSmileClosed");

    private String value;

    CharacterAssetType(String value) {
        this.value = value;
    }

    public String toString() {
        return value;
    }
}
