package net.dinastiafoca.game;

import net.dinastiafoca.entity.EntityFactory;
import net.dinastiafoca.entity.entities.EntityPlayer;
import net.dinastiafoca.window.Camera;
import net.dinastiafoca.window.Window;
import net.dinastiafoca.window.renderer.Renderer;
import net.dinastiafoca.window.renderer.Spritesheet;
import net.dinastiafoca.world.World;
import net.dinastiafoca.world.impl.SimpleWorld;

public class Game implements BaseGame {
    public Renderer renderer;
    public Camera camera;

    private EntityFactory entityFactory;
    private EntityPlayer player;
    private Spritesheet spritesheet;
    private World world;

    @Override
    public void onCreate() {
        Window window = new Window.WindowBuilder()
                .setTitle("--")
                .setWidth(800)
                .setHeight(600)
                .build();

        spritesheet = new Spritesheet();
        renderer = new Renderer(window);
        world = new SimpleWorld(100, 100);
        entityFactory = new EntityFactory(world, this);
        camera = new Camera();

        player = entityFactory.createPlayer(0, 0);
        world.getDimension(0).addEntity(player);
    }

    @Override
    public void doTick() {
        world.update();
    }

    @Override
    public void doRender() {
        renderer.begin();
        world.render(renderer, camera);
        renderer.end();
    }

    @Override
    public void onDestroy() {

    }

    @Override
    public Spritesheet getSpriteSheet()
    {
        return spritesheet;
    }
}
