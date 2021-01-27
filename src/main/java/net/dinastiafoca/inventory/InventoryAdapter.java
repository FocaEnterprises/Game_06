package net.dinastiafoca.inventory;

import net.dinastiafoca.inventory.items.AirItem;

public class InventoryAdapter implements Inventory
{
  private final Item[] items;
  private final InventoryHolder holder;
  
  private String title;

  public InventoryAdapter(int size, String title, InventoryHolder holder) {
    this.title = title;
    this.holder = holder;
    this.items = new Item[size];
  }

  public InventoryAdapter(int size, String title) {
    this(size, title, null);
  }

  public InventoryAdapter(int size) {
    this(size, "Inventory", null);
  }

  @Override
  public String getTitle() {
    return title;
  }

  @Override
  public void setTitle(String title) {
    this.title = title;
  }

  @Override
  public InventoryHolder getHolder() {
    return holder;
  }

  @Override
  public Item getItem(int slot) {
    return items[slot];
  }

  @Override
  public void setItem(int slot, Item item) {
    items[slot] = item != null ? item : new AirItem();
  }

  @Override
  public boolean hasItem(ItemID id) {
    for(int slot = 0; slot < items.length; slot++) {
      if(getItem(slot).getItemId() == id) {
        return true;
      }
    }

    return false;
  }

  @Override
  public boolean hasItem(ItemID id, int amount) {
    int count = 0;

    for(int slot = 0; slot < items.length; slot++) {
      Item item = getItem(slot);

      if(item.getItemId() == id) {
        count += item.getAmount();
      }

      if(count >= amount) {
        return true;
      }
    }

    return false;
  }

  @Override
  public int size() {
    return items.length;
  }

  @Override
  public int firstEmpty() {
    for(int slot = 0; slot < items.length; slot++) {
      if(getItem(slot).getItemId() == ItemID.AIR) {
        return slot;
      }
    }

    return -1;
  }

  @Override
  public int add(Item item) {
    int added = 0;
    short left = item.getAmount();

    for(int slot = 0; slot < items.length; slot++) {
      Item slotItem = getItem(slot);

      if(slotItem.getItemId() == ItemID.AIR) {
        item.setAmount(left);
        setItem(slot, item);
        added += left;
        left = 0;
        break;
      }

      if(slotItem.getItemId() == item.getItemId()) {
        int free = slotItem.getMaxStack() - slotItem.getAmount();

        if(free >= left) {
          slotItem.setAmount((short) (slotItem.getAmount() + left));
          left = 0;
          break;
        }

        left -= free;
        slotItem.setAmount(slotItem.getMaxStack());
      }
    }

    return added;
  }

  @Override
  public int clear() {
    int cleared = 0;

    for(int slot = 0; slot < items.length; slot++) {
      cleared += clear(slot);
    }

    return cleared;
  }

  @Override
  public int clear(int slot)
  {
    int cleared = 0;
    Item item = getItem(slot);
    setItem(slot, new AirItem());
    
    if(item != null && !(item.getItemId() == ItemID.AIR)) {
      cleared = item.getAmount();
    }
    
    return cleared;
  }

  @Override
  public int clear(ItemID itemId) {
    int cleared = 0;

    for(int slot = 0; slot < items.length; slot++) {
      if(getItem(slot).getItemId() == itemId) {
        cleared += clear(slot);
      }
    }
    
    return cleared;
  }

  @Override
  public int clear(ItemID itemId, int amount) {
    int cleared = 0;
    int left = amount;

    for(int slot = 0; slot < items.length; slot++) {
      Item item = getItem(slot);

      if(item.getItemId() != itemId) {
        continue;
      }

      if(item.getAmount() <= left) {
        left -= item.getAmount();
        cleared += clear(slot);
      }
      else {
        item.setAmount((short) (item.getAmount() - left));
        left = 0;
      }

      if(left == 0) {
        break;
      }
    }

    return cleared;
  }
}
