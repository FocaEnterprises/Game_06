package net.dinastiafoca.game;

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
}
