package net.dinastiafoca.inventory;

public enum ItemID
{
  AIR(0),
  STONE(1),
  GRASS(2),
  DIRT(3),
  COBBLESTONE(4),
  OBSIDIAN(5),
  BEDROCK(6);

  public final int ID;

  ItemID(int id) {
    this.ID = id;
  }
}
