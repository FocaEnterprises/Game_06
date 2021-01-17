package net.dinastiafoca.entity;

import net.dinastiafoca.window.renderer.Sprite;
import net.dinastiafoca.world.Dimension;
import net.dinastiafoca.world.World;

import static net.dinastiafoca.world.Block.BLOCK_SIZE;

public abstract class MobEntity extends LivingEntity
{
  protected int speed;
  protected float fallSpeed;

  public MobEntity(World world, int x, int y, int width, int height, Sprite sprite, int life, int maxLife)
  {
    super(world, x, y, width, height, sprite, life, maxLife);
  }

  public MobEntity(World world, int x, int y, int width, int height, Sprite sprite, int maxLife)
  {
    this(world, x, y, width, height, sprite, maxLife, maxLife);
  }

  @Override
  public void update()
  {
    fallSpeed += world.getGravity();

    if(!move2(0, (int) fallSpeed)) {
      fallSpeed = 0;
    }
  }

  public void moveX(int x)
  {
    this.x += x;
  }

  public void moveY(int y)
  {
    this.y += y;
  }

  public int getSpeed()
  {
    return speed;
  }

  public void setSpeed(int speed)
  {
    this.speed = speed;
  }

  // https://github.com/skeeto/Minicraft/blob/master/src/com/mojang/ld22/entity/Entity.java
  public boolean move(int xa, int ya) {
    if (xa != 0 || ya != 0) {
      boolean stopped = true;

      if (xa != 0 && move2(xa, 0)) stopped = false;
      if (ya != 0 && move2(0, ya)) stopped = false;

      return !stopped;
    }

    return true;
  }

  // https://github.com/skeeto/Minicraft/blob/master/src/com/mojang/ld22/entity/Entity.java
  protected boolean move2(int xa, int ya)
  {
    if(xa == 0 && ya == 0)
      return false;

    if(xa != 0 && ya != 0)
      throw new IllegalArgumentException("Move2 can only move along one axis at a time!");

    int xto0 = ((x) - width / 2) >> BLOCK_SIZE;
    int yto0 = ((y) - height / 2) >> BLOCK_SIZE;
    int xto1 = ((x) + width / 2) >> BLOCK_SIZE;
    int yto1 = ((y) + height / 2) >> BLOCK_SIZE;

    int xt0 = ((x + xa) - width / 2) / BLOCK_SIZE;
    int yt0 = ((y + ya) - height / 2) / BLOCK_SIZE;
    int xt1 = ((x + xa) + width / 2) / BLOCK_SIZE;
    int yt1 = ((y + ya) + height / 2) / BLOCK_SIZE;

    Dimension level = world.getCurrentDimension();

    for(int yt = yt0; yt <= yt1; yt++) {
      for(int xt = xt0; xt <= xt1; xt++) {
        if(xt >= xto0 && xt <= xto1 && yt >= yto0 && yt <= yto1)
          continue;

        if(!level.getBlock(xt, yt).mayPass())
          return false;
      }
    }

    moveX(xa);
    moveY(ya);
    return true;
  }
}
