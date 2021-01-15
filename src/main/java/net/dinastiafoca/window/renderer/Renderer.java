package net.dinastiafoca.window.renderer;

import net.dinastiafoca.window.Window;

import java.awt.*;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;
import java.awt.image.ImageObserver;
import java.text.AttributedCharacterIterator;

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
        g = image.getGraphics();
        g.setColor(Color.black);
        g.fillRect(0, 0, 255, 255);
    }

    public void end() {
        g.dispose();
        g = bs.getDrawGraphics();
        g.drawImage(image, 0, 0,image.getWidth(),image.getHeight(),null);
        bs.show();
    }

    public void translate(int x, int y) {g.translate(x, y);}

    public Color getColor() {return g.getColor();}

    public void setColor(Color c) {g.setColor(c);}

    public void setPaintMode() {g.setPaintMode();}

    public void setXORMode(Color c1) {g.setXORMode(c1);}

    public Font getFont() {return g.getFont();}

    public void setFont(Font font) {g.setFont(font);}

    public FontMetrics getFontMetrics() {return g.getFontMetrics();}

    public FontMetrics getFontMetrics(Font f) {return g.getFontMetrics(f);}

    public Rectangle getClipBounds() {return g.getClipBounds();}

    public void clipRect(int x, int y, int width, int height) {g.clipRect(x, y, width, height);}

    public void setClip(int x, int y, int width, int height) {g.setClip(x, y, width, height);}

    public Shape getClip() {return g.getClip();}

    public void setClip(Shape clip) {g.setClip(clip);}

    public void copyArea(int x, int y, int width, int height, int dx, int dy) {g.copyArea(x, y, width, height, dx, dy);}

    public void drawLine(int x1, int y1, int x2, int y2) {g.drawLine(x1, y1, x2, y2);}

    public void fillRect(int x, int y, int width, int height) {g.fillRect(x, y, width, height);}

    public void drawRect(int x, int y, int width, int height) {g.drawRect(x, y, width, height);}

    public void clearRect(int x, int y, int width, int height) {g.clearRect(x, y, width, height);}

    public void drawRoundRect(int x, int y, int width, int height, int arcWidth, int arcHeight) {g.drawRoundRect(x, y, width, height, arcWidth, arcHeight);}

    public void fillRoundRect(int x, int y, int width, int height, int arcWidth, int arcHeight) {g.fillRoundRect(x, y, width, height, arcWidth, arcHeight);}

    public void draw3DRect(int x, int y, int width, int height, boolean raised) {g.draw3DRect(x, y, width, height, raised);}

    public void fill3DRect(int x, int y, int width, int height, boolean raised) {g.fill3DRect(x, y, width, height, raised);}

    public void drawOval(int x, int y, int width, int height) {g.drawOval(x, y, width, height);}

    public void fillOval(int x, int y, int width, int height) {g.fillOval(x, y, width, height);}

    public void drawArc(int x, int y, int width, int height, int startAngle, int arcAngle) {g.drawArc(x, y, width, height, startAngle, arcAngle);}

    public void fillArc(int x, int y, int width, int height, int startAngle, int arcAngle) {g.fillArc(x, y, width, height, startAngle, arcAngle);}

    public void drawPolyline(int[] xPoints, int[] yPoints, int nPoints) {g.drawPolyline(xPoints, yPoints, nPoints);}

    public void drawPolygon(int[] xPoints, int[] yPoints, int nPoints) {g.drawPolygon(xPoints, yPoints, nPoints);}

    public void drawPolygon(Polygon p) {g.drawPolygon(p);}

    public void fillPolygon(int[] xPoints, int[] yPoints, int nPoints) {g.fillPolygon(xPoints, yPoints, nPoints);}

    public void fillPolygon(Polygon p) {g.fillPolygon(p);}

    public void drawString(String str, int x, int y) {g.drawString(str, x, y);}

    public void drawString(AttributedCharacterIterator iterator, int x, int y) {g.drawString(iterator, x, y);}

    public void drawChars(char[] data, int offset, int length, int x, int y) {g.drawChars(data, offset, length, x, y);}

    public void drawBytes(byte[] data, int offset, int length, int x, int y) {g.drawBytes(data, offset, length, x, y);}

    public boolean drawImage(Image img, int x, int y, ImageObserver observer) {return g.drawImage(img, x, y, observer);}

    public boolean drawImage(Image img, int x, int y, int width, int height, ImageObserver observer) {return g.drawImage(img, x, y, width, height, observer);}

    public boolean drawImage(Image img, int x, int y, Color bgcolor, ImageObserver observer) {return g.drawImage(img, x, y, bgcolor, observer);}

    public boolean drawImage(Image img, int x, int y, int width, int height, Color bgcolor, ImageObserver observer) {return g.drawImage(img, x, y, width, height, bgcolor, observer);}

    public boolean drawImage(Image img, int dx1, int dy1, int dx2, int dy2, int sx1, int sy1, int sx2, int sy2, ImageObserver observer) {return g.drawImage(img, dx1, dy1, dx2, dy2, sx1, sy1, sx2, sy2, observer);}

    public boolean drawImage(Image img, int dx1, int dy1, int dx2, int dy2, int sx1, int sy1, int sx2, int sy2, Color bgcolor, ImageObserver observer) {return g.drawImage(img, dx1, dy1, dx2, dy2, sx1, sy1, sx2, sy2, bgcolor, observer);}

    public void dispose() {g.dispose();}

    public boolean hitClip(int x, int y, int width, int height) {return g.hitClip(x, y, width, height);}

    public Rectangle getClipBounds(Rectangle r) {return g.getClipBounds(r);}
}
