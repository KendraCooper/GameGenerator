package edu.utdallas.gamegenerator;

import java.util.List;
import java.util.UUID;

/**
 * User: clocke
 * Date: 2/15/13
 * Time: 9:44 PM
 */
public class ScreenNode {
    private UUID id;
    private String background;
    private String name;
    private List<Asset> assets;

    public ScreenNode() {
        id = UUID.randomUUID();
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getBackground() {
        return background;
    }

    public void setBackground(String background) {
        this.background = background;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Asset> getAssets() {
        return assets;
    }

    public void setAssets(List<Asset> assets) {
        this.assets = assets;
    }
}
