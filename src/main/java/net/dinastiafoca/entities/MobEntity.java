package net.dinastiafoca.entities;

import net.dinastiafoca.world.World;

public abstract class MobEntity extends LivingEntity
{
  protected int speed;

  public MobEntity(World world, int x, int y, int width, int height, int life, int maxLife)
  {
    super(world, x, y, width, height, life, maxLife);
  }

  public MobEntity(World world, int x, int y, int width, int height, int maxLife)
  {
    this(world, x, y, width, height, maxLife, maxLife);
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
