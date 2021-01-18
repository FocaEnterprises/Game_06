package net.dinastiafoca.world.blocks;

import net.dinastiafoca.window.renderer.Spritesheet;
import net.dinastiafoca.world.Block;

public class DirtBlock extends Block {
  public DirtBlock() {
    super(3, Spritesheet.getBlockSprite("dirt"));
  }
}
