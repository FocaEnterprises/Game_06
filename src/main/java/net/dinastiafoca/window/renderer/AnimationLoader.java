package net.dinastiafoca.window.renderer;

import org.json.JSONArray;
import org.json.JSONObject;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;
import java.util.Scanner;

public class AnimationLoader {
    public static Animation getAnimation(String path) {
        JSONObject AnimationJSON = new JSONObject(readFile(path));
        JSONArray spritesJson = AnimationJSON.getJSONArray("frames");

        BufferedImage[] sprites = getSpritesFromJSON(spritesJson);
        float speed = AnimationJSON.getFloat("speed");

        return new Animation(sprites, speed);
    }

    private static BufferedImage[] getSpritesFromJSON(JSONArray jsonArray) {
        BufferedImage[] sprites = new BufferedImage[jsonArray.length()];
        for (int i = 0; i < jsonArray.length(); i++) {
            JSONObject frame = jsonArray.getJSONObject(i);
            String spritePath = frame.getString("path");
            int x = frame.getInt("x");
            int y = frame.getInt("y");
            int width = frame.getInt("width");
            int height = frame.getInt("height");

            sprites[i] = loadImage(spritePath, x, y, width, height);
        }
        return sprites;
    }

    private static String readFile(String path) {
        InputStream myObj = Spritesheet.class.getClass().getResourceAsStream(path);
        Scanner myReader = new Scanner(myObj);
        String text = "";
        while (myReader.hasNextLine()) {
            text += myReader.nextLine();
        }
        myReader.close();

        return text;
    }

    private static BufferedImage loadImage(String path, int x, int y, int width, int height) {
        try {
            return ImageIO.read(Spritesheet.class.getResource(path)).getSubimage(x, y, width, height);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
