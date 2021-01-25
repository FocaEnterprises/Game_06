package net.dinastiafoca.inventory;

import net.dinastiafoca.window.renderer.Renderer;
import net.dinastiafoca.window.renderer.Sprite;

public abstract class Item {

  public final int SPRITE_SIZE = 48;

  private final Sprite sprite;
  private final ItemID id;

  private final short maxStack;

  private String name;

  private short amount;

  public Item(ItemID itemId, String name, Sprite sprite, short maxStack, short amount, short durability, short maxDurability) {
    this.id = itemId;
    this.name = name;
    this.sprite = sprite;
    this.maxStack = maxStack;
    this.amount = amount;
  }

  public final ItemID getItemId() {
    return this.id;
  }

  public final short getMaxStack() {
    return maxStack;
  }

  public final short getAmount() {
    return amount;
  }

  public final void setAmount(short amount) {
    this.amount = amount;
  }

  public final String getName() {
    return name;
  }

  public final void setName(String name) {
    this.name = name;
  }

  public void render(Renderer renderer, int x, int y) {
    if(sprite != null) {
      renderer.drawImage(sprite.getSprite(), x, y, 48, 48, null);
    }
  }
}
