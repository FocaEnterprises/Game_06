package net.dinastiafoca.entity;

import net.dinastiafoca.window.renderer.Renderer;
import net.dinastiafoca.window.renderer.Sprite;
import net.dinastiafoca.world.World;

import java.awt.Rectangle;

public abstract class Entity {

    protected World world;

    protected int width;
    protected int height;

    protected int x;
    protected int y;

    protected int maskX;
    protected int maskY;
    protected int maskWidth;
    protected int maskHeight;

    protected Sprite sprite;

    public Entity(World world, int x, int y, int width, int height, Sprite sprite) {
        this.world = world;
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.sprite = sprite;
    }

    public void update() {

    }

    public void render(Renderer renderer) {

    }

    public boolean isColliding(Entity entity)
    {
        return getHitBox().intersects(entity.getHitBox());
    }

    public Rectangle getHitBox()
    {
        return new Rectangle(x + maskX, y + maskX, width - maskWidth, height - maskHeight);
    }

    public void setWorld(World world)
    {
        this.world = world;
    }

    public World getWorld()
    {
        return world;
    }

    public int getWidth()
    {
        return width;
    }

    public void setWidth(int width)
    {
        this.width = width;
    }

    public int getHeight()
    {
        return height;
    }

    public void setHeight(int height)
    {
        this.height = height;
    }

    public int getX()
    {
        return x;
    }

    public void setX(int x)
    {
        this.x = x;
    }

    public int getY()
    {
        return y;
    }

    public void setY(int y)
    {
        this.y = y;
    }

    public int getMaskX()
    {
        return maskX;
    }

    public void setMaskX(int maskX)
    {
        this.maskX = maskX;
    }

    public int getMaskY()
    {
        return maskY;
    }

    public void setMaskY(int maskY)
    {
        this.maskY = maskY;
    }

    public int getMaskWidth()
    {
        return maskWidth;
    }

    public void setMaskWidth(int maskWidth)
    {
        this.maskWidth = maskWidth;
    }

    public int getMaskHeight()
    {
        return maskHeight;
    }

    public void setMaskHeight(int maskHeight)
    {
        this.maskHeight = maskHeight;
    }
}
