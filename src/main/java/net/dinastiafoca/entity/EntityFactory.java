package net.dinastiafoca.entity;

import net.dinastiafoca.entity.entities.player.EntityPlayer;
import net.dinastiafoca.game.BaseGame;
import net.dinastiafoca.window.renderer.Sprite;
import net.dinastiafoca.window.renderer.Spritesheet;
import net.dinastiafoca.world.World;

public final class EntityFactory
{
  private final World world;
  private final BaseGame game;

  public EntityFactory(World world, BaseGame game)
  {
    this.world = world;
    this.game = game;
  }

  public EntityPlayer createPlayer(int x, int y)
  {
    Sprite sprite = Spritesheet.getSprite("/entity/player.png");
    return new EntityPlayer(world, x, y, sprite);
  }
}
