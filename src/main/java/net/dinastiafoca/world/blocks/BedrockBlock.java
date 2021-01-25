package net.dinastiafoca.world.blocks;

import net.dinastiafoca.inventory.ItemID;
import net.dinastiafoca.window.renderer.Spritesheet;
import net.dinastiafoca.world.Block;

public class BedrockBlock extends Block {
  public BedrockBlock() {
    super(ItemID.BEDROCK, Spritesheet.getBlockSprite("bedrock"));
  }
}
