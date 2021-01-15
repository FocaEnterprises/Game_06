package net.dinastiafoca.world;

import net.dinastiafoca.window.renderer.Renderer;

public abstract class Block {

  public static final int BLOCK_SIZE = 16;

  private final int ID;

  public Block(int id)
  {
    this.ID = id;
  }

  public abstract void render(Renderer renderer, int x, int y);

  public void update() {

  }

  public int getId()
  {
    return ID;
  }
}
