package net.dinastiafoca.game;

import net.dinastiafoca.window.Window;
import net.dinastiafoca.window.renderer.Renderer;
import net.dinastiafoca.world.World;
import net.dinastiafoca.world.impl.SimpleWorld;

public class Game implements BaseGame {
    public Renderer renderer;

    private World world;

    @Override
    public void onCreate() {
        Window window = new Window.WindowBuilder()
                .setTitle("--")
                .setWidth(800)
                .setHeight(600)
                .build();
        renderer = new Renderer(window);
        world = new SimpleWorld(20, 20);
    }

    @Override
    public void doTick() {

    }

    @Override
    public void doRender() {
        renderer.begin();
        world.render(renderer);
        renderer.end();
    }

    @Override
    public void onDestroy() {

    }
}
