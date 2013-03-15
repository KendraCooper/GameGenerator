package edu.utdallas.gamegenerator.Characters;

import edu.utdallas.gamegenerator.LearningObjective.Character.LearningObjectiveCharacterType;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * User: clocke
 * Date: 2/17/13
 * Time: 6:04 PM
 */
@XmlRootElement(name = "NPCCharacter")
public class NPCCharacter {
    private GameCharacter hero;
    private GameCharacter villain;
    private GameCharacter alt;

    public GameCharacter getHero() {
        return hero;
    }

    public GameCharacter getCharacter(LearningObjectiveCharacterType characterType) {
        switch (characterType) {
            case HERO:
                return hero;
            case ALT:
                return alt;
            case VILLIAN:
                return villain;
            default:
                break;
        }
        return null;
    }

    @XmlElement(name = "Hero")
    public void setHero(GameCharacter hero) {
        this.hero = hero;
    }

    public GameCharacter getVillain() {
        return villain;
    }

    @XmlElement(name = "Villain")
    public void setVillain(GameCharacter villain) {
        this.villain = villain;
    }

    public GameCharacter getAlt() {
        return alt;
    }

    @XmlElement(name = "Alt")
    public void setAlt(GameCharacter alt) {
        this.alt = alt;
    }
}
