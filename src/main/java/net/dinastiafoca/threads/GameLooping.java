package net.dinastiafoca.threads;

import net.dinastiafoca.game.BaseGame;

public class GameLooping implements Runnable, Looping {

    private final BaseGame baseGame;
    private final int TPS;

    private Thread thread;
    private volatile boolean isRunning;

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
        return isRunning;
    }

    @Override
    public void run() {
        long timer = System.currentTimeMillis();
        long lastTime = System.nanoTime();
        long now;

        double nsPerTick = 1_000_000_000D / this.TPS;
        double unprocessed = 0.0D;

        int currentFps = 0;

        while(isRunning) {
            now = System.nanoTime();
            unprocessed += (now - lastTime) / nsPerTick;
            lastTime = now;

            while(unprocessed >= 1) {
                baseGame.doTick();
                baseGame.doRender();
                ++currentFps;
                --unprocessed;
            }


            if(System.currentTimeMillis() - timer >= 1000){
                System.out.printf("Running at %d frames\n", currentFps);
                currentFps = 0;
                timer += 1000;
            }

            try {
                Thread.sleep(5);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
