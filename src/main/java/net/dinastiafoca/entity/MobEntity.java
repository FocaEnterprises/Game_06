package net.dinastiafoca.entity;

import net.dinastiafoca.window.renderer.Sprite;
import net.dinastiafoca.world.Dimension;
import net.dinastiafoca.world.World;

import static net.dinastiafoca.world.Block.BLOCK_SIZE;

public abstract class MobEntity extends LivingEntity
{
  protected boolean jump;
  protected int speed;
  protected float vSpeed;


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
    vSpeed += world.getGravity();

    if (jump)
    {
      jump = false;

      if(!isMoveAllowed(getX(), getY() +1) && isMoveAllowed(getX(), getY() -1))
      {
        vSpeed = -6;
      }
    }

    if (!isMoveAllowed(getX(), (int) (y + vSpeed))) {
      int signVSpeed;

      if (vSpeed >= 0) {
        signVSpeed = 1;
      }
      else {
        signVSpeed = -1;
      }

      while (isMoveAllowed(getX(), y + signVSpeed)){
        y = y + signVSpeed;
      }

      vSpeed = 0;
    }

    moveY((int) vSpeed);
  }

  public void moveX(int x)
  {
    this.x += x;
  }

  public void moveY(int y)
  {
    this.y += y;
  }

  public void moveIfAllowedX(int x) {
    if(isMoveAllowed(getX() + x, getY())) {
      moveX(x);
    }
  }

  public void moveIfAllowedY(int y) {
    if(isMoveAllowed(getX(), getY() + y)) {
      moveY(y);
    }
  }

  public int getSpeed()
  {
    return speed;
  }

  public void setSpeed(int speed)
  {
    this.speed = speed;
  }

  public void jump() {
    jump = true;
  }

  protected boolean isMoveAllowed(int nextX, int nextY) {
    return isMoveAllowed0(
            nextX + getMaskX(),
            nextY + getMaskY(),
            getWidth() - getMaskWidth(),
            getHeight() - getMaskHeight()
    );
  }

  protected boolean isMoveAllowed0(int nextX, int nextY, int width, int height) {
    Dimension dimension = world.getCurrentDimension();

    int x1 = nextX / BLOCK_SIZE;
    int y1 = nextY / BLOCK_SIZE;

    int x2 = (nextX + width -1) / BLOCK_SIZE;
    int y2 = (nextY + height -1) / BLOCK_SIZE;

    int x3 = nextX / BLOCK_SIZE;
    int y3 = nextY / BLOCK_SIZE;

    int x4 = (nextX + width -1) / BLOCK_SIZE;
    int y4 = (nextY + height -1) / BLOCK_SIZE;

    return dimension.getBlock(x1, y1).mayPass()
            && dimension.getBlock(x2, y2).mayPass()
            && dimension.getBlock(x3, y3).mayPass()
            && dimension.getBlock(x4, y4).mayPass();
  }
}
