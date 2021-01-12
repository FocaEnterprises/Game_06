package net.dinastiafoca.window.renderer;

import javax.imageio.ImageIO;
import java.io.IOException;

public class Spritesheet {
    public Sprite getSprite(String path, int x, int y, int width, int height) {
        try {
            return new Sprite(ImageIO.read(getClass().getResource(path)).getSubimage(x, y, width, height));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    public Sprite getSprite(String path, int width, int height) {
        return this.getSprite(path, 0, 0, width, height);
    }

    public Sprite getSprite(String path) {
        try {
            return new Sprite(ImageIO.read(getClass().getResource(path)));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
