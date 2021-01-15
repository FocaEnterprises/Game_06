package net.dinastiafoca.entity.entities.player;

import net.dinastiafoca.game.Game;

import java.awt.event.KeyEvent;

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
            player.moveX(speed);
        }
        else if(game.getKeyboard().getKeyPressed(KeyEvent.VK_A)) {
            player.moveX(-speed);
        }
    }
}
