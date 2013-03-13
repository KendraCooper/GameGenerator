package edu.utdallas.gamegenerator.LearningObjective;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

/**
 * User: clocke
 * Date: 2/17/13
 * Time: 4:58 PM
 */
@XmlRootElement(name = "LearningObjective")
public class LearningObjective {
    private List<Lesson> lessons;

    public List<Lesson> getLessons() {
        return lessons;
    }

    @XmlElementWrapper(name = "Lessons")
    @XmlElement(name = "Lesson")
    public void setLessons(List<Lesson> lessons) {
        this.lessons = lessons;
    }
}
