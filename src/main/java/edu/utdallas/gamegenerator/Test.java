package edu.utdallas.gamegenerator;

import edu.utdallas.gamegenerator.Characters.NPCCharacter;
import edu.utdallas.gamegenerator.Characters.PlayerCharacter;
import edu.utdallas.gamegenerator.LearningObjective.LearningObjective;
import edu.utdallas.gamegenerator.Locale.Locale;
import edu.utdallas.gamegenerator.Structure.Scene;
import edu.utdallas.gamegenerator.Subject.Subject;
import edu.utdallas.gamegenerator.Theme.Theme;

import javax.xml.bind.*;
import java.io.File;
import java.io.IOException;
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

        try {
            createXsd();
//            createXml(testObjects);
//            test();
        } catch (Exception e) {
            e.printStackTrace();
        }

        System.out.println();
    }

    private static void createXsd() throws JAXBException, IOException {
        JAXBContext jaxbContext = JAXBContext.newInstance(NPCCharacter.class);
        SchemaOutputResolver sor = new MySchemaOutputResolver("NPCCharacter.xsd");
        jaxbContext.generateSchema(sor);

        jaxbContext = JAXBContext.newInstance(PlayerCharacter.class);
        sor = new MySchemaOutputResolver("PlayerCharacter.xsd");
        jaxbContext.generateSchema(sor);

        jaxbContext = JAXBContext.newInstance(Theme.class);
        sor = new MySchemaOutputResolver("Theme.xsd");
        jaxbContext.generateSchema(sor);

        jaxbContext = JAXBContext.newInstance(LearningObjective.class);
        sor = new MySchemaOutputResolver("LearningObjective.xsd");
        jaxbContext.generateSchema(sor);

        jaxbContext = JAXBContext.newInstance(Locale.class);
        sor = new MySchemaOutputResolver("Locale.xsd");
        jaxbContext.generateSchema(sor);

        jaxbContext = JAXBContext.newInstance(Subject.class);
        sor = new MySchemaOutputResolver("Subject.xsd");
        jaxbContext.generateSchema(sor);

//        jaxbContext = JAXBContext.newInstance(Structure.class);
//        sor = new MySchemaOutputResolver("PlayerCharacter.xsd");
//        jaxbContext.generateSchema(sor);

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

        file = new File("E:\\Development\\Java\\GameGenerator\\xml\\Theme.xml");
        jaxbContext = JAXBContext.newInstance(Theme.class);
        marshaller = jaxbContext.createMarshaller();
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
        marshaller.marshal(testObjects.getTheme(), file);

        file = new File("E:\\Development\\Java\\GameGenerator\\xml\\Locale.xml");
        jaxbContext = JAXBContext.newInstance(Locale.class);
        marshaller = jaxbContext.createMarshaller();
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
        marshaller.marshal(testObjects.getLocale(), file);
    }
}
