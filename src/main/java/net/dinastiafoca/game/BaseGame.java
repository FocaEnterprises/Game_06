package net.dinastiafoca.game;

import net.dinastiafoca.entity.entities.player.PlayerController;
import net.dinastiafoca.input.Keyboard;
import net.dinastiafoca.window.renderer.Spritesheet;

/**
 * Represents a Game
 */
public interface BaseGame {

    /**
     * Called on game startup
     */
    void onCreate();

    /**
     * Called by a @{@link net.dinastiafoca.threads.Looping} on game update
     */
    void doTick();

    /**
     * Called by a {@link net.dinastiafoca.threads.Looping} on game render
     */
    void doRender();

    /**
     * Called on application shutting down
     */
    void onDestroy();

    /**
     * Get the game sprite sheet
     * @return game sprite sheet instance
     */
    Spritesheet getSpriteSheet();

    /**
     * Get the game keyboard
     * @return game keyboard instance
     */
   Keyboard getKeyboard();
}
