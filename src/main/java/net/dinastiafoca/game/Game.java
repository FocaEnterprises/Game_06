package net.dinastiafoca.game;

import net.dinastiafoca.window.Window;
import net.dinastiafoca.window.renderer.Renderer;

public class Game implements BaseGame {
    public Renderer renderer;

    @Override
    public void onCreate() {
        Window window = new Window.WindowBuilder()
                .setTitle("--")
                .setWidth(800)
                .setHeight(600)
                .build();
        renderer = new Renderer(window);
    }

    @Override
    public void doTick() {

    }

    @Override
    public void doRender() {
        renderer.begin();

        renderer.end();
    }

    @Override
    public void onDestroy() {

    }
}
