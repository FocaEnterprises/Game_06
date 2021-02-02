package net.dinastiafoca.entity.entities.player;

import net.dinastiafoca.game.Game;
import net.dinastiafoca.window.Window;

import java.awt.event.KeyEvent;

import static net.dinastiafoca.world.Block.BLOCK_SIZE;

public class PlayerController {
    private final EntityPlayer player;
    private final Game game;
    private final int speed = 4;

    public PlayerController(EntityPlayer player, Game game)  {
        this.player = player;
        this.game = game;
    }

    public void update() {
        if(game.getKeyboard().getKeyPressed(KeyEvent.VK_D)) {
            player.moveIfAllowedX(speed);
        }

        if(game.getKeyboard().getKeyPressed(KeyEvent.VK_A)) {
            player.moveIfAllowedX(-speed);
        }

        if(game.getKeyboard().getKeyPressed(KeyEvent.VK_SPACE)) {
            player.jump();
        }

        Window window = game.getWindow();

        game.camera.setClamp(
                player.getX() - window.getWidth() / 2,
                player.getY() - window.getHeight() / 2,
                game.getWorld().getWidth() * BLOCK_SIZE - window.getWidth(),
                game.getWorld().getHeight() * BLOCK_SIZE - window.getHeight()
        );
    }
}
