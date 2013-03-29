package edu.utdallas.gamegenerator;

import edu.utdallas.gamegenerator.Characters.NPCCharacter;
import edu.utdallas.gamegenerator.Characters.PlayerCharacter;
import edu.utdallas.gamegenerator.LearningObjective.LearningObjective;
import edu.utdallas.gamegenerator.Structure.Scene;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

/**
 * Company: Porpoise Software
 * User: Terminus Est
 * Date: 3/3/13
 * Time: 10:10 PM
 */
public class Test {
    public static void main(String[] args) {
        TestObjects testObjects = new TestObjects();
        testObjects.getTheme().getIntro();
        List<ScreenNode> blah2 = testObjects.getTheme().getIntro();
        testObjects.getLocale().getAct(0);
        testObjects.getStructure().createGame();

//        try {
//            createXml(testObjects);
//            test();
//        } catch (JAXBException e) {
//            e.printStackTrace();
//        }

        System.out.println();
    }

    private static void test() throws JAXBException {
        Scene scene = new Scene();
        List<ScreenNode> screens = new ArrayList<ScreenNode>();
        scene.setScreens(screens);

        JAXBContext jaxbContext = JAXBContext.newInstance(Scene.class);
        Marshaller marshaller = jaxbContext.createMarshaller();
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
        File file = new File("E:\\Development\\Java\\GameGenerator\\xml\\Scene.xml");
        marshaller.marshal(scene, file);

        file = new File("E:\\Development\\Java\\GameGenerator\\xml\\Scene.xml");
        Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
        Scene scene2 = (Scene) unmarshaller.unmarshal(file);
        System.out.println(scene2);
    }

    private static void createXml(TestObjects testObjects) throws JAXBException {
        JAXBContext jaxbContext = JAXBContext.newInstance(NPCCharacter.class);
        Marshaller marshaller = jaxbContext.createMarshaller();
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
        File file = new File("E:\\Development\\Java\\GameGenerator\\xml\\NPCCharacter.xml");
        marshaller.marshal(testObjects.getNpcCharacter(), file);

        file = new File("E:\\Development\\Java\\GameGenerator\\xml\\PlayerCharacter.xml");
        jaxbContext = JAXBContext.newInstance(PlayerCharacter.class);
        marshaller = jaxbContext.createMarshaller();
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
        marshaller.marshal(testObjects.getPlayerCharacter(), file);

        file = new File("E:\\Development\\Java\\GameGenerator\\xml\\LearningObjective.xml");
        jaxbContext = JAXBContext.newInstance(LearningObjective.class);
        marshaller = jaxbContext.createMarshaller();
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
        marshaller.marshal(testObjects.getLearningObjective(), file);
    }
}
