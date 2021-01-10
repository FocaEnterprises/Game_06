package net.dinastiafoca.Program;

import net.dinastiafoca.window.Window;

public class Program {

    public static void main(String[] args) {
        final GameManager manager = new GameManager();
        manager.startGame();

        Runtime.getRuntime().addShutdownHook(new Thread(manager::stopGame));
    }
}