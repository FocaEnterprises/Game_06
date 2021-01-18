package net.dinastiafoca.world.blocks;

import net.dinastiafoca.window.renderer.Spritesheet;
import net.dinastiafoca.world.Block;

public class StoneBlock extends Block {
  public StoneBlock() {
    super(1, Spritesheet.getBlockSprite("stone"));
  }
}
