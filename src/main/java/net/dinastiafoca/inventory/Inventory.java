package net.dinastiafoca.inventory;

/**
 * Represents a Inventory
 */
public interface Inventory {

  /**
   * Get the inventory title
   *
   * @return the current inventory title
   */
  String getTitle();

  /**
   * Set the inventory title
   * @param name the new inventory title
   */
  void setTitle(String name);

  /**
   * Get the inventory holder
   *
   * @return the inventory holder or null
   */
  InventoryHolder getHolder();

  /**
   * Get item in specified slot
   *
   * @param slot the slot
   * @return the item in slot
   */
  Item getItem(int slot);

  /**
   * Set item in specified slot
   *
   * @param slot the slot
   * @param item the item
   */
  void setItem(int slot, Item item);

  /**
   * Verify if the inventory has the item
   *
   * @param id the ItemID
   * @return true if the inventory has any item for the specified ItemID
   */
  boolean hasItem(ItemID id);

  /**
   * Verify if the inventory has the item and the amount
   *
   * @param id the ItemID
   * @param amount the required item amount
   * @return true if the inventory has the number of items specified for the id or false if not
   */
  boolean hasItem(ItemID id, int amount);

  /**
   * Get the inventory size
   *
   * @return the size
   */
  int size();

  /**
   * Get the first empty slot
   * @return The first empty slot or -1 if all inventory slots are occupied
   */
  int firstEmpty();

  /**
   * Add item to the inventory
   *
   * @param item the item
   * @return the number of added items
   */
  int add(Item item);

  /**
   * Clear all inventory slots
   *
   * @return the number os cleared items
   */
  int clear();

  /**
   * Clear the item in the specified slot
   * @param slot the slot
   * @return the number of cleared items
   */
  int clear(int slot);

  /**
   * Clear items for the specified id
   *
   * @param itemId the ItemID
   * @return the number of cleared items
   */
  int clear(ItemID itemId);

  /**
   * Clear the specified amount of specified item
   *
   * @param itemId the ItemID
   * @param amount number of items that must be cleaned
   * @return the number of cleared items
   */
  int clear(ItemID itemId, int amount);

}
