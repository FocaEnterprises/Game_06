package net.dinastiafoca.window;

import javax.swing.*;

public class Window {
    private String title;
    private int width;
    private int height;

    private JFrame frame;

    private Window(String title, int width, int height) {
        this.title = title;
        this.width = width;
        this.height = height;

        this.frame = new JFrame(title);
        this.frame.setSize(width, height);
        this.frame.setLocationRelativeTo(null);
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
