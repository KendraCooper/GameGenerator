package edu.utdallas.gamegenerator.Characters;

import com.bluelotussoftware.jaxb.adapter.XmlGenericMapAdapter;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import java.util.Map;

/**
 * User: clocke
 * Date: 2/17/13
 * Time: 6:08 PM
 */
public class GameCharacter {
    private String directory;
    private String prefix;
    private Map<String, String> characterAssets;
    private String name;

    public GameCharacter() {
        //Populate hash map
    }

    public String getCharacter(String characterAction) {
        return characterAssets.get(characterAction);
    }

    public String getDirectory() {
        return directory;
    }

    @XmlElement(name = "Directory")
    public void setDirectory(String directory) {
        this.directory = directory;
    }

    public String getPrefix() {
        return prefix;
    }

    @XmlElement(name = "Prefix")
    public void setPrefix(String prefix) {
        this.prefix = prefix;
    }

    public Map<String, String> getCharacterAssets() {
        return characterAssets;
    }

    @XmlElement(name = "CharacterAssets")
    @XmlJavaTypeAdapter(XmlGenericMapAdapter.class)
    public void setCharacterAssets(Map<String, String> characterAssets) {
        this.characterAssets = characterAssets;
    }

    public String getName() {
        return name;
    }

    @XmlElement(name = "Name")
    public void setName(String name) {
        this.name = name;
    }
}
