package net.dinastiafoca.world;

import net.dinastiafoca.window.renderer.Renderer;
import net.dinastiafoca.window.renderer.Sprite;

public abstract class Block {

  public static final int BLOCK_SIZE = 16;

  private final Sprite sprite;
  private final int ID;

  public Block(int id, Sprite sprite) {
    this.ID = id;
    this.sprite = sprite;
  }

  public void render(Renderer renderer, int x, int y) {
    if(sprite == null){
      return;
    }

    renderer.drawImage(sprite.getSprite(), x, y, BLOCK_SIZE, BLOCK_SIZE, null);
  }

  public void update() {

  }

  public int getId()
  {
    return ID;
  }
}
