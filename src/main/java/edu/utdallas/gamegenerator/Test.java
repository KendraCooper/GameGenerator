package edu.utdallas.gamegenerator;

import edu.utdallas.gamegenerator.Characters.NPCCharacter;
import edu.utdallas.gamegenerator.Characters.PlayerCharacter;
import edu.utdallas.gamegenerator.LearningObjective.LearningObjective;
import edu.utdallas.gamegenerator.Locale.Locale;
import edu.utdallas.gamegenerator.Structure.Game;
import edu.utdallas.gamegenerator.Structure.Scene;
import edu.utdallas.gamegenerator.Structure.Structure;
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
    private static PlayerCharacter playerCharacter;
    private static NPCCharacter npcCharacter;
    private static Subject subject;
    private static LearningObjective learningObjective;
    private static Locale locale;
    private static Theme theme;
    private static Structure structure = new Structure();
    private static Game game;

    public static void main(String[] args) {
//        TestObjects testObjects = new TestObjects();
//        testObjects.getTheme().getIntro();
//        List<ScreenNode> blah2 = testObjects.getTheme().getIntro();
//        testObjects.getLocale().getAct(0);
//        Game game = testObjects.getStructure().createGame();

        try {
            readXml();
//            createXsd();
//            createXml(testObjects);
//            readXmlGenerated();
//            test();
        } catch (Exception e) {
            e.printStackTrace();
        }

        theme.setNpcCharacters(npcCharacter);
        theme.setPlayerCharacter(playerCharacter);
        theme.setSubject(subject);

        List<LearningObjective> learningObjectives = new ArrayList<LearningObjective>();
        learningObjectives.add(learningObjective);

        locale.setNpcCharacters(npcCharacter);
        locale.setLearningObjectives(learningObjectives);
        locale.setTheme(theme);
        locale.setPlayerCharacter(playerCharacter);

        structure.setTheme(theme);
        structure.setLocale(locale);
        game = structure.createGame();

        try {
            writeGameXml();
//            createXsd();
//            createXml(testObjects);
//            readXmlGenerated();
//            test();
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println();
    }

    private static void writeGameXml() throws JAXBException {
        JAXBContext jaxbContext = JAXBContext.newInstance(Game.class);
        Marshaller marshaller = jaxbContext.createMarshaller();
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
        File file = new File("C:\\Users\\Terminus Est\\Dropbox\\SimSYS Development Platform\\IntSemi-automatedGameGenerationComponent\\Layer xsds\\Sample Game XMLs\\Game.xml");
        marshaller.marshal(game, file);

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

    private static void readXml() throws JAXBException {
        JAXBContext jaxbContext = JAXBContext.newInstance(PlayerCharacter.class);
        File file = new File("E:\\Development\\Java\\GameGenerator\\xml\\PlayerCharacter.xml");
        Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
        playerCharacter = (PlayerCharacter) unmarshaller.unmarshal(file);

        jaxbContext = JAXBContext.newInstance(NPCCharacter.class);
        file = new File("E:\\Development\\Java\\GameGenerator\\xml\\NPCCharacter.xml");
        unmarshaller = jaxbContext.createUnmarshaller();
        npcCharacter = (NPCCharacter) unmarshaller.unmarshal(file);

        jaxbContext = JAXBContext.newInstance(Subject.class);
        file = new File("E:\\Development\\Java\\GameGenerator\\xml\\Subject.xml");
        unmarshaller = jaxbContext.createUnmarshaller();
        subject = (Subject) unmarshaller.unmarshal(file);

        jaxbContext = JAXBContext.newInstance(Theme.class);
        file = new File("E:\\Development\\Java\\GameGenerator\\xml\\Theme.xml");
        unmarshaller = jaxbContext.createUnmarshaller();
        theme = (Theme) unmarshaller.unmarshal(file);

        jaxbContext = JAXBContext.newInstance(Locale.class);
        file = new File("E:\\Development\\Java\\GameGenerator\\xml\\Locale.xml");
        unmarshaller = jaxbContext.createUnmarshaller();
        locale = (Locale) unmarshaller.unmarshal(file);

        jaxbContext = JAXBContext.newInstance(LearningObjective.class);
        file = new File("E:\\Development\\Java\\GameGenerator\\xml\\LearningObjective.xml");
        unmarshaller = jaxbContext.createUnmarshaller();
        learningObjective = (LearningObjective) unmarshaller.unmarshal(file);

        System.out.println();
    }

    private static void createXml(TestObjects testObjects) throws JAXBException {
        JAXBContext jaxbContext = JAXBContext.newInstance(NPCCharacter.class);
        Marshaller marshaller = jaxbContext.createMarshaller();
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
        File file = new File("E:\\Development\\Java\\GameGenerator\\xml\\NPCCharacter.xml");
        marshaller.marshal(testObjects.getNpcCharacter(), file);
//
//        file = new File("E:\\Development\\Java\\GameGenerator\\xml\\PlayerCharacter.xml");
//        jaxbContext = JAXBContext.newInstance(PlayerCharacter.class);
//        marshaller = jaxbContext.createMarshaller();
//        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
//        marshaller.marshal(testObjects.getPlayerCharacter(), file);
//
        file = new File("E:\\Development\\Java\\GameGenerator\\xml\\LearningObjectiveOut.xml");
        jaxbContext = JAXBContext.newInstance(LearningObjective.class);
        marshaller = jaxbContext.createMarshaller();
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
        marshaller.marshal(testObjects.getLearningObjective(), file);

        file = new File("E:\\Development\\Java\\GameGenerator\\xml\\ThemeOut.xml");
        jaxbContext = JAXBContext.newInstance(Theme.class);
        marshaller = jaxbContext.createMarshaller();
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
        marshaller.marshal(testObjects.getTheme(), file);

        file = new File("E:\\Development\\Java\\GameGenerator\\xml\\LocaleOut.xml");
        jaxbContext = JAXBContext.newInstance(Locale.class);
        marshaller = jaxbContext.createMarshaller();
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
        marshaller.marshal(testObjects.getLocale(), file);
    }

    private static void readXmlGenerated() throws JAXBException {
        JAXBContext jaxbContext = JAXBContext.newInstance(PlayerCharacter.class);
        File file = new File("E:\\Development\\Java\\GameGenerator\\xml\\PlayerCharacter.xml");
        Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
//        playerCharacter = (PlayerCharacter) unmarshaller.unmarshal(file);
//
//        jaxbContext = JAXBContext.newInstance(NPCCharacter.class);
//        file = new File("E:\\Development\\Java\\GameGenerator\\xml\\NPCCharacter.xml");
//        unmarshaller = jaxbContext.createUnmarshaller();
//        npcCharacter = (NPCCharacter) unmarshaller.unmarshal(file);
//
//        jaxbContext = JAXBContext.newInstance(Subject.class);
//        file = new File("E:\\Development\\Java\\GameGenerator\\xml\\Subject.xml");
//        unmarshaller = jaxbContext.createUnmarshaller();
//        subject = (Subject) unmarshaller.unmarshal(file);

        jaxbContext = JAXBContext.newInstance(Theme.class);
        file = new File("E:\\Development\\Java\\GameGenerator\\xml\\ThemeOut.xml");
        unmarshaller = jaxbContext.createUnmarshaller();
        theme = (Theme) unmarshaller.unmarshal(file);

//        jaxbContext = JAXBContext.newInstance(Locale.class);
//        file = new File("E:\\Development\\Java\\GameGenerator\\xml\\LocaleOut.xml");
//        unmarshaller = jaxbContext.createUnmarshaller();
//        locale = (Locale) unmarshaller.unmarshal(file);
//
//        jaxbContext = JAXBContext.newInstance(LearningObjective.class);
//        file = new File("E:\\Development\\Java\\GameGenerator\\xml\\LearningObjectiveOut.xml");
//        unmarshaller = jaxbContext.createUnmarshaller();
//        learningObjective = (LearningObjective) unmarshaller.unmarshal(file);

        System.out.println();
    }
}
