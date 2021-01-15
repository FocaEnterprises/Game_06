package net.dinastiafoca.window;

import net.dinastiafoca.input.Keyboard;

import javax.swing.*;
import java.awt.*;

public class Window {
    private String title;
    private int width;
    private int height;

    private JFrame frame;
    private Canvas canvas;

    private Window(String title, int width, int height) {
        this.title = title;
        this.width = width;
        this.height = height;

        this.frame = new JFrame(title);
        this.canvas = new Canvas();

        this.frame.setSize(width, height);
        this.canvas.setPreferredSize(new Dimension(width, height));

        this.frame.add(canvas);

        this.frame.setResizable(false);
        this.frame.setLocationRelativeTo(null);
        this.frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.frame.setVisible(true);
    }

    public String getTitle() {
        return title;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public Canvas getCanvas() {
        return canvas;
    }

    public void addKeyboard(Keyboard keyboard) {
        getCanvas().addKeyListener(keyboard);
    }

    public static class WindowBuilder {
        private String title;
        private int width;
        private int height;

        public WindowBuilder() {

        }

        public WindowBuilder setTitle(String title) {
            this.title = title;
            return this;
        }

        public WindowBuilder setWidth(int width) {
            this.width = width;
            return this;
        }

        public WindowBuilder setHeight(int height) {
            this.height = height;
            return this;
        }

        public Window build() {
            return new Window(this.title, this.width, this.height);
        }
    }
}
