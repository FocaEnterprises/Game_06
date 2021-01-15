package net.dinastiafoca.world;

import net.dinastiafoca.window.Camera;
import net.dinastiafoca.window.renderer.Renderer;

/**
 * Represents a World
 */
public interface World {

    /**
     * Called each BaseGame.doTick()
     */
    void update();

    /**
     * Called each BaseGame.doRender()
     *
     * @param renderer rendered that draw the game
     * @param camera the current game camera
     */
    void render(Renderer renderer, Camera camera);

    /**
     * Get all dimensions on this world
     * @return clone of dimentions array
     */
    Dimension[] getDimensions();

    /**
     * Get the Player dimension
     * @return dimension...
     */
    Dimension getCurrentDimension();

    /**
     * Set current dimension
     * @param dimensionIndex the index of dimension
     */
    void setCurrentDimension(int dimensionIndex);

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
