package net.dinastiafoca.world;

import net.dinastiafoca.entities.Entity;
import net.dinastiafoca.window.renderer.Renderer;

import java.util.List;

public interface Dimension {

    /**
     * Called each @{@link World} update
     */
    void update();

    /**
     * Called each @{@link World render()}
     * @param renderer Renderer
     */
    void render(Renderer renderer);

    World getWorld();

    Block getBlock(int x, int y);

    boolean addEntity(Entity entity);

    boolean removeEntity(Entity entity);

    List<Entity> getEntities();

    void setBlock(int x, int y, Block block);
}
