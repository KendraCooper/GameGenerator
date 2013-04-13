package edu.utdallas.gamegenerator.LearningObjective.Screen;

import javax.xml.bind.annotation.XmlRootElement;

/**
 * User: clocke
 * Date: 2/17/13
 * Time: 4:37 PM
 */
@XmlRootElement(name = "LessonScreen")
public class LearningObjectiveLesson extends LearningObjectiveScreen {
    @Override
    public ScreenType getType() {
        return ScreenType.LESSON;
    }
}
