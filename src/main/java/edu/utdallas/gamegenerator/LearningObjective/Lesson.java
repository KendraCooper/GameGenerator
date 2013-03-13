package edu.utdallas.gamegenerator.LearningObjective;

import edu.utdallas.gamegenerator.LearningObjective.Screen.LearningObjectiveChallenge;
import edu.utdallas.gamegenerator.LearningObjective.Screen.LearningObjectiveLesson;

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

    public void setLessonScreens(List<LearningObjectiveLesson> lessonScreens) {
        this.lessonScreens = lessonScreens;
    }

    public List<LearningObjectiveChallenge> getLessonChallenges() {
        return lessonChallenges;
    }

    public void setLessonChallenges(List<LearningObjectiveChallenge> lessonChallenges) {
        this.lessonChallenges = lessonChallenges;
    }
}
