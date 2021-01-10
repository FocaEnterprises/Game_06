package net.dinastiafoca.world;

/**
 * Represents a World
 */
public interface World {

    /**
     * Called each BaseGame.doTick()
     */
    void update();

    /**
     * Get all dimensions on this world
     * @return clone of dimentions array
     */
    Dimension[] getDimensions();

    /**
     * Get world width
     * @return world width in blocks
     */
    int getWidth();

    /**
     *Get world height
     * @return world height in blocks
     */
    int getHeight();
}
