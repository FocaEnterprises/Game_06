package net.dinastiafoca.Program;

import net.dinastiafoca.game.BaseGame;
import net.dinastiafoca.game.Game;
import net.dinastiafoca.threads.GameLooping;

public class GameManager {

    private BaseGame game;
    private GameLooping looping;

    public void startGame() {
        game = new Game();
        game.onCreate();

        looping = new GameLooping(game, 60);
        looping.start();
    }

    public void stopGame(){
        looping.stop();
        game.onDestroy();

        game = null;
        looping = null;
    }
}
