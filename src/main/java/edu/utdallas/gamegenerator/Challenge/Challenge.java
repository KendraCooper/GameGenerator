package edu.utdallas.gamegenerator.Challenge;

import edu.utdallas.gamegenerator.LearningObjective.Screen.LearningObjectiveChallenge;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

/**
 * User: clocke
 * Date: 4/28/13
 * Time: 7:51 PM
 */
@XmlRootElement(name = "Challenge")
public class Challenge {
    private List<LearningObjectiveChallenge> lessonChallenges;

    public List<LearningObjectiveChallenge> getLessonChallenges() {
        return lessonChallenges;
    }

    @XmlElementWrapper(name = "LessonChallenges")
    @XmlElement(name = "LessonChallenge")
    public void setLessonChallenges(List<LearningObjectiveChallenge> lessonChallenges) {
        this.lessonChallenges = lessonChallenges;
    }
}
