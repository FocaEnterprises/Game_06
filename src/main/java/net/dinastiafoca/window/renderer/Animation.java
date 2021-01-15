package net.dinastiafoca.window.renderer;

import net.dinastiafoca.window.renderer.Sprite;

import java.awt.image.BufferedImage;

public class Animation extends Sprite {
    public BufferedImage[] sprites;
    public int index;
    public int frames;

    public Animation(BufferedImage[] sprites) {
        super(sprites[0]);
        this.sprites = sprites;
    }

    public BufferedImage getSprite() {
        frames++;
        if(frames >= 30){
            frames = 0;
            index++;
            if(index >= sprites.length) {
                index = 0;
            }
        }
        return sprites[index];
    }
}