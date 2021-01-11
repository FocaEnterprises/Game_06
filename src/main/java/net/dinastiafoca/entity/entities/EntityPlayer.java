package net.dinastiafoca.entity.entities;

import net.dinastiafoca.entity.MobEntity;
import net.dinastiafoca.window.renderer.Renderer;
import net.dinastiafoca.world.Block;
import net.dinastiafoca.world.World;

import java.awt.Color;

public class EntityPlayer extends MobEntity
{
  public EntityPlayer(World world, int x, int y)
  {
    super(world, x, y, Block.BLOCK_SIZE, Block.BLOCK_SIZE, 10);
  }

  @Override
  public void update()
  {

  }

  @Override
  public void render(Renderer renderer)
  {
    renderer.setColor(Color.RED);
    renderer.fillRect(getX(), getY(), getWidth(), getHeight());
  }
}
