package net.dinastiafoca.world;

public interface Dimension {

    // A parada da dimension é pra ficar igual no Minecraft mesmo
    // Que cada mundo tem três dimensões (em situações normais)
    // Overworld, Nether, The End
    // Fica bom, né? Tomara que sim...
    // Já volto

    Block getBlock(int x, int y);

    void setBlock(int x, int y, Block block);

}
