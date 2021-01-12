package net.dinastiafoca.window.renderer;

import java.awt.image.BufferedImage;

public class Sprite {
    private BufferedImage sprite;

    public BufferedImage getSprite() {
        return sprite;
    }

    public Sprite(BufferedImage sprite) {
        this.sprite = sprite;
    }
}
