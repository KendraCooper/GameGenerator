package edu.utdallas.gamegenerator.Structure;

import edu.utdallas.gamegenerator.Locale.ObjectMovementType;

import javax.xml.bind.annotation.XmlElement;

/**
 * User: clocke
 * Date: 2/24/13
 * Time: 8:59 PM
 */
public class Screen {
    private int a;
    private ObjectMovementType objectMovementType;

    public int getA() {
        return a;
    }

    @XmlElement(name = "A")
    public void setA(int a) {
        this.a = a;
    }

    public ObjectMovementType getObjectMovementType() {
        return objectMovementType;
    }

    @XmlElement(name = "ObjectMovementType")
    public void setObjectMovementType(ObjectMovementType objectMovementType) {
        this.objectMovementType = objectMovementType;
    }
}
