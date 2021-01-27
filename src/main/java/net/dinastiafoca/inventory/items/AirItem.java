package net.dinastiafoca.inventory.items;

import net.dinastiafoca.inventory.Item;
import net.dinastiafoca.inventory.ItemID;

public class AirItem extends Item {
  public AirItem() {
    super(ItemID.AIR, "Air", null, (short) 1, (short) 1, (short) 1, (short) 1);
  }
}
