package net.dinastiafoca.world.blocks;

import net.dinastiafoca.window.renderer.Spritesheet;
import net.dinastiafoca.world.Block;

public class ObsidianBlock extends Block {
  public ObsidianBlock() {
    super(5, Spritesheet.getBlockSprite("obsidian"));
  }
}
