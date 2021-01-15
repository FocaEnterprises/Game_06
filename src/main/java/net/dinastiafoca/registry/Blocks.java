package net.dinastiafoca.registry;

import net.dinastiafoca.world.Block;
import net.dinastiafoca.world.blocks.AirBlock;

import java.util.HashMap;

public class Blocks {

  private static final HashMap<Integer, Block> blocks = new HashMap<>();

  public static final Block AIR = register(new AirBlock());

  public static Block getById(int id) {
    Block block = blocks.get(id);

    return block != null ? block : AIR;
  }

  private static Block register(Block block) {
    blocks.put(block.getId(), block);
    return block;
  }
}
