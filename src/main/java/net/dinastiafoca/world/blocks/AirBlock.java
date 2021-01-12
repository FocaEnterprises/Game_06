package net.dinastiafoca.world.blocks;

import net.dinastiafoca.window.renderer.Renderer;
import net.dinastiafoca.world.Block;
import net.dinastiafoca.world.Material;

import java.awt.Color;

public class AirBlock extends Block {

  public AirBlock() {
    super(Material.AIR.getId());
  }

  @Override
  public void render(Renderer renderer, int x, int y)
  {
    renderer.setColor(Color.CYAN);
    renderer.drawRect(x, y, Block.BLOCK_SIZE, Block.BLOCK_SIZE);
  }
}
