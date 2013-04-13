package edu.utdallas.gamegenerator;

import javax.xml.bind.annotation.XmlType;

/**
 * Company: Porpoise Software
 * User: Terminus Est
 * Date: 4/13/13
 * Time: 4:20 PM
 */
@XmlType(name = "InformationBoxAsset")
public class InformationBoxAsset extends Asset {
    public InformationBoxAsset() {
    }

    public InformationBoxAsset(Asset asset) {
        super(asset);
    }
}
