package net.dinastiafoca.world.gen;

import net.dinastiafoca.registry.Blocks;
import net.dinastiafoca.world.Block;
import net.dinastiafoca.world.Dimension;
import net.dinastiafoca.world.World;

import java.util.Random;

public class WorldGenerator {

  private static final int MAX_HEIGHT = 20;
  private static final int RESOLUTION = 10;

  private final OpenSimplexNoise noise;
  private final Random random;
  private final World world;

  public WorldGenerator(World world) {
    this.noise = new OpenSimplexNoise();
    this.random = new Random(world.getSeed());
    this.world = world;
  }

  public void regenerateOverworld() {
    Dimension dimension = world.getDimension(0);

    for(int x = 0; x < world.getWidth(); x++) {
      double height = MAX_HEIGHT * (1 + noise.eval((x + world.getSeed()) / Math.sqrt(world.getWidth() * RESOLUTION), world.getSeed()) / 2);
      int y = world.getHeight() - (int) ((world.getHeight() / 2) + height);

      fillGround(dimension, x, y, Blocks.STONE);
      generateSurface(dimension, x, y, Blocks.GRASS, Blocks.DIRT);
      generateBedrock(dimension, x);
    }
  }

  private void generateBedrock(Dimension dimension, int x) {
      dimension.setBlock(x, world.getHeight() -1, Blocks.BEDROCK);

      if(random.nextInt(100) < 80)
        dimension.setBlock(x, world.getHeight() -2, Blocks.BEDROCK);
  }

  private void generateSurface(Dimension dimension, int x, int y, Block top, Block bottom) {
    dimension.setBlock(x, y, top);
    double height = 5 * (1 + noise.eval((x + (world.getSeed() * 2)) / Math.sqrt(world.getWidth() * (RESOLUTION * 2)), world.getSeed() * 2) / 2);
    for (int yy = 0; yy < height; yy++) {
      dimension.setBlock(x, y + 1 + yy, bottom);
    }
  }

  private void fillGround(Dimension dimension, int x, int y, Block block) {
      for(int yy = y; yy < world.getHeight(); yy++) {
        dimension.setBlock(x, yy, block);
      }
  }

  public void regenerateNether() {

  }

  public void regenerateTheEnd() {

  }
}
