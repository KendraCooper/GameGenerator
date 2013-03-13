package edu.utdallas.gamegenerator.LearningObjective.Screen;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;

/**
 * User: clocke
 * Date: 2/17/13
 * Time: 3:33 PM
 */
@XmlEnum
@XmlType(name = "TransitionType")
public enum TransitionType {
    BEGINNING_OF_LEARNING_OBJECTIVE,
    BEGINNING_OF_LESSON,
    BEGINNING_OF_STORY,
    BEGINNING_OF_CHALLENGE,
    NEXT_ACT,
    ADDITIONAL,
    NEXT_LESSON,
    NEXT_CHALLENGE;
}
