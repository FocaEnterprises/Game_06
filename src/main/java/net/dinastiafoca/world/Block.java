package net.dinastiafoca.world;

import net.dinastiafoca.window.renderer.Renderer;

public abstract class Block {

  public static final int BLOCK_SIZE = 16;

  private final int ID;

  public Block(int id) {
    this.ID = id;
  }

  public void update(){

  }

  public void render(Renderer renderer, int x, int y) {

  }

  public int getID() {
    return ID;
  }
}
