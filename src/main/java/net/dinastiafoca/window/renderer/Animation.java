package net.dinastiafoca.window.renderer;

import net.dinastiafoca.threads.Looping;
import net.dinastiafoca.window.renderer.Sprite;

import java.awt.image.BufferedImage;

public class Animation extends Sprite implements Looping {
    public BufferedImage[] sprites;
    private int index;
    private int frames;
    public float speed = 1;
    private boolean isRunning;

    public Animation(BufferedImage[] sprites, float speed) {
        super(sprites[0]);
        this.sprites = sprites;
        this.speed = speed;
    }

    public BufferedImage getSprite() {
        if(isRunning) {
            frames++;
            if (frames >= 30 / (speed == 0 ? 1 : speed)) {
                frames = 0;
                index++;
                if (index >= sprites.length) {
                    index = 0;
                }
            }
        }
        return sprites[index];
    }

    @Override
    public void start() {
        isRunning = true;
    }

    @Override
    public void stop() {
        isRunning = false;
    }

    @Override
    public boolean isRunning() {
        return isRunning;
    }
}