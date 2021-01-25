package net.dinastiafoca.world.blocks;

import net.dinastiafoca.inventory.ItemID;
import net.dinastiafoca.world.Block;

public class AirBlock extends Block {
  public AirBlock() {
    super(ItemID.AIR, null);
    mayPass = true;
  }
}
