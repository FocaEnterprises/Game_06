package net.dinastiafoca.threads;

import net.dinastiafoca.game.BaseGame;

public class GameLooping implements Runnable, Looping {

    private final int TPS;

    private BaseGame baseGame;

    private Thread thread;
    private boolean isRunning;

    public GameLooping(BaseGame game, int tps) {
        this.baseGame = game;
        this.TPS = tps;
    }

    @Override
    public void start() {
        thread = new Thread(this);
        isRunning = true;
        thread.start();
    }

    @Override
    public void stop() {
        try {
            isRunning = false;
            thread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Override
    public boolean isRunning() {
        return false;
    }

    @Override
    public void run() {
        long timer = System.currentTimeMillis();
        long lastTime = System.nanoTime();
        long now;

        double nsPerTick = 1_000_000_000 / this.TPS;
        double unprocessed = 0.0D;

        int currentTps = 0;
        int currentFps = 0;

        while(isRunning) { // TODO: colocar boolean running aqui
            now = System.nanoTime();
            unprocessed += (now - lastTime) / nsPerTick;
            lastTime = now;

            while(unprocessed >= 1) {
                // baseGame.tick();
                ++currentTps;
                --unprocessed;
            }

            //baseGame.render();
            ++currentFps;

            if(System.currentTimeMillis() - timer >= 1000){
                System.out.printf("Running at %d ticks and %d frames\n", currentTps, currentFps);
                currentTps = 0;
                currentFps = 0;
                timer += 1000;
            }

            try {
                Thread.sleep(4);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public void setBaseGame(BaseGame game)
    {
        if(this.baseGame == null)
        {
            this.baseGame = game;
        }
    }
}
