package net.dinastiafoca.window.renderer;

import net.dinastiafoca.window.Window;

import java.awt.*;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;

public class Renderer {
    private Window window;
    private Canvas canvas;

    private BufferedImage image;
    private Graphics g;
    private BufferStrategy bs;

    public Renderer(Window window) {
        this.window = window;
        this.canvas = window.getCanvas();
        this.image = new BufferedImage(window.getWidth(), window.getHeight(), BufferedImage.TYPE_INT_RGB);

        initGraphics();
    }

    private void initGraphics() {
        canvas.createBufferStrategy(3);
        bs = canvas.getBufferStrategy();
        g = image.getGraphics();
    }

    public void begin() {
        g.setColor(Color.black);
        g.fillRect(0, 0, 255, 255);
    }

    public void end() {
        g.dispose();
        g = bs.getDrawGraphics();
        g.drawImage(image, 0, 0,image.getWidth(),image.getHeight(),null);
        bs.show();
    }
}
