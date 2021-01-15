package net.dinastiafoca.entity;

import net.dinastiafoca.window.renderer.Sprite;
import net.dinastiafoca.world.World;

public abstract class LivingEntity extends Entity {

    protected int life;
    protected int maxLife;

    public LivingEntity(World world, int x, int y, int width, int height, Sprite sprite, int life, int maxLife) {
        super(world, x, y, width, height, sprite);
        this.life = life;
        this.maxLife = maxLife;
    }

    public LivingEntity(World world, int x, int y, int width, int height, Sprite sprite, int maxLife) {
        this(world, x, y, width, height, sprite, maxLife, maxLife);
    }

    public int getLife()
    {
        return life;
    }

    public void setLife(int life)
    {
        this.life = life;
    }

    public int getMaxLife()
    {
        return maxLife;
    }

    public void setMaxLife(int maxLife)
    {
        this.maxLife = maxLife;
    }
}
