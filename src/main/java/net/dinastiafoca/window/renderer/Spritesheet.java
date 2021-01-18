package net.dinastiafoca.window.renderer;

import javax.imageio.ImageIO;
import java.io.IOException;

public class Spritesheet {
    public static Sprite getSprite(String path, int x, int y, int width, int height) {
        try {
            return new Sprite(ImageIO.read(Spritesheet.class.getResource(path)).getSubimage(x, y, width, height));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static Sprite getSprite(String path, int width, int height) {
        return getSprite(path, 0, 0, width, height);
    }

    public static Sprite getSprite(String path) {
        try {
            return new Sprite(ImageIO.read(Spritesheet.class.getResource(path)));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
