package edu.utdallas.gamegenerator.Lesson;

import edu.utdallas.gamegenerator.LearningObjective.Screen.LearningObjectiveLesson;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

/**
 * User: clocke
 * Date: 4/28/13
 * Time: 7:49 PM
 */
@XmlRootElement(name = "Lesson")
public class Lesson {
    private List<LearningObjectiveLesson> lessonScreens;

    public List<LearningObjectiveLesson> getLessonScreens() {
        return lessonScreens;
    }

    @XmlElementWrapper(name = "LessonScreens")
    @XmlElement(name = "LessonScreen")
    public void setLessonScreens(List<LearningObjectiveLesson> lessonScreens) {
        this.lessonScreens = lessonScreens;
    }
}
