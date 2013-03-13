package edu.utdallas.gamegenerator;

import edu.utdallas.gamegenerator.Characters.NPCCharacter;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import java.io.File;
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
        List<ScreenNode> blah2 = testObjects.getTheme().getOutro();

        try {
            File file = new File("E:\\Development\\Java\\GameGenerator\\xml\\NPCCharacter.xml");
            JAXBContext jaxbContext = JAXBContext.newInstance(NPCCharacter.class);
            Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
            NPCCharacter npcCharacter = (NPCCharacter) unmarshaller.unmarshal(file);
            System.out.println(npcCharacter);

            file = new File("E:\\Development\\Java\\GameGenerator\\xml\\NPCCharacter2.xml");
            Marshaller marshaller = jaxbContext.createMarshaller();
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
            marshaller.marshal(testObjects.getNpcCharacter(), System.out);
        } catch (JAXBException e) {
            e.printStackTrace();
        }

        System.out.println();
    }
}
