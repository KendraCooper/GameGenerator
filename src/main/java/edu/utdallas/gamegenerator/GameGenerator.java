package edu.utdallas.gamegenerator;

import edu.utdallas.gamegenerator.Characters.Characters;
import edu.utdallas.gamegenerator.LearningObjective.LearningObjective;
import edu.utdallas.gamegenerator.Locale.Locale;
import edu.utdallas.gamegenerator.Structure.Game;
import edu.utdallas.gamegenerator.Structure.Structure;
import edu.utdallas.gamegenerator.Subject.Subject;
import edu.utdallas.gamegenerator.Theme.Theme;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static edu.utdallas.gamegenerator.Layers.*;

/**
 * Company: Porpoise Software
 * User: Terminus Est
 * Date: 4/15/13
 * Time: 8:55 PM
 */
public class GameGenerator {
    public static void main(String[] args) {
        if(args.length == 5) {
            Map<String, String> xmlFiles = new HashMap<String, String>();
            xmlFiles.put(CHARACTERS, args[0]);
            xmlFiles.put(LEARNING_OBJECTIVE, args[1]);
            xmlFiles.put(LOCALE, args[2]);
            xmlFiles.put(SUBJECT, args[3]);
            xmlFiles.put(THEME, args[4]);

            GameGenerator gameGenerator = new GameGenerator();

            try {
                Layers layers = gameGenerator.loadXmlComponents(xmlFiles);
                Game game = gameGenerator.buildGame(layers);
                gameGenerator.exportGame(game);
            } catch (JAXBException e) {
                e.printStackTrace();
            }
        } else {
            System.out.println("Please enter the file names of the layers:\n");
            System.out.println(
                    "\tie: GameGenerator characters.xml learningobjective.xml locale.xml subject.xml, theme.xml\n\n");
        }
    }

    public void exportGame(Game game) throws JAXBException {
        JAXBContext jaxbContext = JAXBContext.newInstance(Game.class);
        Marshaller marshaller = jaxbContext.createMarshaller();
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
        File file = new File("C:\\Users\\Terminus Est\\Dropbox\\SimSYS Development Platform\\IntSemi-automatedGameGenerationComponent\\Layer xsds\\Sample Game XMLs\\Game.xml");
        marshaller.marshal(game, file);
    }

    public Game buildGame(Layers layers) {
        return layers.getStructure().createGame();
    }

    public Layers loadXmlComponents(Map<String, String> xmlFiles) throws JAXBException {
        Layers layers = new Layers();

        JAXBContext jaxbContext = null;
        File file = null;
        Unmarshaller unmarshaller = null;

        jaxbContext = JAXBContext.newInstance(Characters.class);
        file = new File(xmlFiles.get(CHARACTERS));
        unmarshaller = jaxbContext.createUnmarshaller();
        layers.setCharacters((Characters) unmarshaller.unmarshal(file));

        jaxbContext = JAXBContext.newInstance(Subject.class);
        file = new File(xmlFiles.get(SUBJECT));
        unmarshaller = jaxbContext.createUnmarshaller();
        layers.setSubject((Subject) unmarshaller.unmarshal(file));

        jaxbContext = JAXBContext.newInstance(Theme.class);
        file = new File(xmlFiles.get(THEME));
        unmarshaller = jaxbContext.createUnmarshaller();
        layers.setTheme((Theme) unmarshaller.unmarshal(file));

        jaxbContext = JAXBContext.newInstance(Locale.class);
        file = new File(xmlFiles.get(LOCALE));
        unmarshaller = jaxbContext.createUnmarshaller();
        layers.setLocale((Locale) unmarshaller.unmarshal(file));

        String[] learningObjectiveFiles = xmlFiles.get(LEARNING_OBJECTIVE).split(",");

        jaxbContext = JAXBContext.newInstance(LearningObjective.class);
        unmarshaller = jaxbContext.createUnmarshaller();
        List<LearningObjective> learningObjectives = new ArrayList<LearningObjective>();
        for(int i = 0; i < learningObjectiveFiles.length; i++) {
            file = new File(learningObjectiveFiles[i]);
            LearningObjective learningObjective = ((LearningObjective) unmarshaller.unmarshal(file));
            learningObjectives.add(learningObjective);
        }
        layers.setLearningObjectives(learningObjectives);

        layers.setStructure(new Structure());
        wireUpLayers(layers);

        return layers;
    }

    private void wireUpLayers(Layers layers) {
        layers.getLocale().setTheme(layers.getTheme());
        layers.getLocale().setLearningObjectives(layers.getLearningObjectives());
        layers.getLocale().setCharacters(layers.getCharacters());
        layers.getTheme().setSubject(layers.getSubject());
        layers.getTheme().setCharacters(layers.getCharacters());
        layers.getStructure().setLocale(layers.getLocale());
        layers.getStructure().setTheme(layers.getTheme());
    }


}
