package net.dinastiafoca.world;

public interface Dimension {

    World getWorld();

    Block getBlock(int x, int y);

    void setBlock(int x, int y, Block block);

}
