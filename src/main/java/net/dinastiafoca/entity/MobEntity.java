package net.dinastiafoca.entity;

import net.dinastiafoca.window.renderer.Sprite;
import net.dinastiafoca.world.World;

public abstract class MobEntity extends LivingEntity
{
  protected int speed;

  public MobEntity(World world, int x, int y, int width, int height, Sprite sprite, int life, int maxLife)
  {
    super(world, x, y, width, height, sprite, life, maxLife);
  }

  public MobEntity(World world, int x, int y, int width, int height, Sprite sprite, int maxLife)
  {
    this(world, x, y, width, height, sprite, maxLife, maxLife);
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
}
