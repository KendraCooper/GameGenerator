package edu.utdallas.gamegenerator.LearningObjective;

import edu.utdallas.gamegenerator.LearningObjective.Screen.LearningObjectiveChallenge;
import edu.utdallas.gamegenerator.LearningObjective.Screen.LearningObjectiveLesson;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import java.util.List;

/**
 * User: clocke
 * Date: 2/17/13
 * Time: 5:15 PM
 */
public class Lesson {
    private List<LearningObjectiveLesson> lessonScreens;
    private List<LearningObjectiveChallenge> lessonChallenges;

    public List<LearningObjectiveLesson> getLessonScreens() {
        return lessonScreens;
    }

    @XmlElementWrapper(name = "LessonScreens")
    @XmlElement(name = "LessonScreen")
    public void setLessonScreens(List<LearningObjectiveLesson> lessonScreens) {
        this.lessonScreens = lessonScreens;
    }

    public List<LearningObjectiveChallenge> getLessonChallenges() {
        return lessonChallenges;
    }

    @XmlElementWrapper(name = "LessonChallenges")
    @XmlElement(name = "LessonChallenge")
    public void setLessonChallenges(List<LearningObjectiveChallenge> lessonChallenges) {
        this.lessonChallenges = lessonChallenges;
    }
}
