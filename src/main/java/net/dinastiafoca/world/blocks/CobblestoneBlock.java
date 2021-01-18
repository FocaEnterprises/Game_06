package net.dinastiafoca.world.blocks;

import net.dinastiafoca.window.renderer.Spritesheet;
import net.dinastiafoca.world.Block;

public class CobblestoneBlock extends Block {
  public CobblestoneBlock() {
    super(4, Spritesheet.getBlockSprite("cobblestone"));
  }
}
