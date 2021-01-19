package net.dinastiafoca.registry;

import net.dinastiafoca.world.Block;
import net.dinastiafoca.world.blocks.*;

import java.util.HashMap;

public class Blocks {

  private static final HashMap<Integer, Block> blocks = new HashMap<>();

  public static final Block AIR         = register(new AirBlock());
  public static final Block STONE       = register(new StoneBlock());
  public static final Block GRASS       = register(new GrassBlock());
  public static final Block DIRT        = register(new DirtBlock());
  public static final Block COBBLESTONE = register(new CobblestoneBlock());
  public static final Block OBSIDIAN    = register(new ObsidianBlock());
  public static final Block BEDROCK     = register(new BedrockBlock());

  public static Block getById(int id) {
    Block block = blocks.get(id);

    return block != null ? block : AIR;
  }

  private static Block register(Block block) {
    blocks.put(block.getId(), block);
    return block;
  }
}
