package net.dinastiafoca.entity.entities;

import net.dinastiafoca.entity.MobEntity;
import net.dinastiafoca.window.Camera;
import net.dinastiafoca.window.renderer.Renderer;
import net.dinastiafoca.window.renderer.Sprite;
import net.dinastiafoca.world.Block;
import net.dinastiafoca.world.World;

import java.awt.Color;

public class EntityPlayer extends MobEntity
{
  public EntityPlayer(World world, int x, int y, Sprite sprite)
  {
    super(world, x, y, Block.BLOCK_SIZE, Block.BLOCK_SIZE, sprite, 10);
  }

  @Override
  public void update()
  {

  }

  @Override
  public void render(Renderer renderer, Camera camera)
  {
    renderer.drawImage(
            sprite.getSprite(),
            camera.translateX(x),
            camera.translateY(y),
            width,
            height,
            null);
  }
}
