package edu.utdallas.gamegenerator.Shared;

/**
 * Company: Porpoise Software
 * User: Terminus Est
 * Date: 3/3/13
 * Time: 10:24 PM
 */
public class SharedButton extends GameObject {
    private String name;

    public SharedButton() {
        super();
    }

    public SharedButton(String name, int locX, int locY, int width, int height, String pathToAsset) {
        super(locX, locY, width, height, pathToAsset);
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
