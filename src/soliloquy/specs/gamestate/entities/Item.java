package soliloquy.specs.gamestate.entities;

import soliloquy.specs.common.shared.HasUuid;
import soliloquy.specs.common.infrastructure.Pair;
import soliloquy.specs.ruleset.entities.ItemType;

/**
 * <b>Item</b>
 * <p>
 * An Item is of an ItemType.
 * <p>
 * An Item can have a number of charges.
 * <p>
 * An Item can be located in one of these four locations: Character inventories,
 * CharacterEquipmentSlots, Tiles, and TileContainers.
 * 
 * @author felix.t.morgenstern
 * @version 0.0.1
 *
 */
public interface Item extends GameEntity, HasUuid {
	/**
	 * @return The ItemType of this Item
	 * @throws IllegalStateException If this Item is present in more than one place (i.e. an
	 * Inventory, an EquipmentSlot, a Tile, or a TileContainer), or if it has no Id, or if it has
	 * been deleted. It is legal for an Item to have no locations, e.g. when it has not yet been
	 * placed, or after it has been removed from an EquipmentSlot.
	 */
	ItemType itemType() throws IllegalStateException;
	
	/**
	 * @return The number of charges left in this Item (If this Item does not have charges, this
	 * method will return null.)
	 * @throws IllegalStateException If this Item's ItemType does not allow it to have charges, if
	 * this Item is present in more than one place (i.e. an Inventory, an EquipmentSlot, a Tile, or
	 * a TileContainer), or if it has no Id, or if it has been deleted. It is legal for an Item to
	 * have no locations, e.g. when it has not yet been placed, or after it has been removed from
	 * an EquipmentSlot.
	 */
	Integer getCharges() throws IllegalStateException;

	/**
	 * @param charges - The charges to set for this Item
	 * @throws UnsupportedOperationException If and only if this Item's type does not have charges
	 * @throws IllegalArgumentException - If numberInStack is less than 0
	 * @throws IllegalStateException If this Item's ItemType does not allow it to be stacked, if
	 * this Item is present in more than one place (i.e. an Inventory, an EquipmentSlot, a Tile, or
	 * a TileContainer), or if it has no Id, or if it has been deleted. It is legal for an Item to
	 * have no locations, e.g. when it has not yet been placed, or after it has been removed from
	 * an EquipmentSlot.
	 */
	void setCharges(int charges)
			throws UnsupportedOperationException, IllegalArgumentException, IllegalStateException;
	
	/**
	 * <b>NB: Stackable Items are treated such that one Item is equivalent to one stack. So, a
	 * stack of 15 health potions would be a single Item, which would return 15 when this method is
	 * called.</b>
	 * @return The number of Items of this type currently in this stack.
	 * @throws IllegalStateException If this Item's ItemType does not allow it to be stacked, if
	 * this Item is present in more than one place (i.e. an Inventory, an EquipmentSlot, a Tile, or
	 * a TileContainer), or if it has no Id, or if it has been deleted. It is legal for an Item to
	 * have no locations, e.g. when it has not yet been placed, or after it has been removed from
	 * an EquipmentSlot.
	 */
	Integer getNumberInStack() throws IllegalStateException;

	/**
	 * <b>NB: See {@link #getNumberInStack()} for an explanation of how stacked Items work.</b>
	 * @param numberInStack - The number in this stack to set for this Item
	 * @throws UnsupportedOperationException - If this ItemType cannot be stacked
	 * @throws IllegalArgumentException - If numberInStack is less than 1
	 * @throws IllegalStateException - If this Item is present in more than one place (i.e. an
	 * Inventory, an EquipmentSlot, a Tile, or a TileContainer), or if it has no Id, or if it has
	 * been deleted. It is legal for an Item to have no locations, e.g. when it has not yet been
	 * placed, or after it has been removed from an EquipmentSlot.
	 */
	void setNumberInStack(int numberInStack)
			throws UnsupportedOperationException, IllegalArgumentException, IllegalStateException;
	
	/**
	 * Splits a stackable Item into two Items; returns the new Item with a number taken from the
	 * original Item's stack
	 * <b>NB: See {@link #getNumberInStack()} for an explanation of how stacked Items work.</b>
	 * @param numberToTake - The number of the item to take from the original Item's stack
	 * @return The new Item, of the same ItemType, with numberInStack equal to numberToTake
	 * @throws UnsupportedOperationException - If this ItemType cannot be stacked
	 * @throws IllegalArgumentException - If numberToTake is less than one, or if it is greater
	 * than or equal to getNumberInStack of this (i.e. the original) Item
	 * @throws IllegalStateException - If this Item is present in more than one place (i.e. an
	 * Inventory, an EquipmentSlot, a Tile, or a TileContainer), or if it has no Id, or if it has
	 * been deleted. It is legal for an Item to have no locations, e.g. when it has not yet been
	 * placed, or after it has been removed from an EquipmentSlot.
	 */
	Item takeFromStack(int numberToTake) throws UnsupportedOperationException, IllegalArgumentException, IllegalStateException;
	
	/**
	 * @return The Character in whose inventory this Item exists
	 * @throws IllegalStateException If this Item is present in more than one place (i.e. an
	 * Inventory, an EquipmentSlot, a Tile, or a TileContainer), or if it has no Id, or if it has
	 * been deleted. It is legal for an Item to have no locations, e.g. when it has not yet been
	 * placed, or after it has been removed from an EquipmentSlot.
	 */
	Character getInventoryCharacter() throws IllegalStateException;
	
	/**
	 * @return A Pair containing the Character and the equipment slot type in which this Item is
	 * located
	 * @throws IllegalStateException If this Item is present in more than one place (i.e. an
	 * Inventory, an EquipmentSlot, a Tile, or a TileContainer), or if it has no Id, or if it has
	 * been deleted. It is legal for an Item to have no locations, e.g. when it has not yet been
	 * placed, or after it has been removed from an EquipmentSlot.
	 */
	Pair<Character,String> getCharacterEquipmentSlot() throws IllegalStateException;
	
	/**
	 * @return The Tile on which this Item is stored (Note that this means on the ground, and not
	 * in a container.)
	 * @throws IllegalStateException If this Item is present in more than one place (i.e. an
	 * Inventory, an EquipmentSlot, a Tile, or a TileContainer), or if it has no Id, or if it has
	 * been deleted. It is legal for an Item to have no locations, e.g. when it has not yet been
	 * placed, or after it has been removed from an EquipmentSlot.
	 */
	Tile getTile() throws IllegalStateException;
	
	/**
	 * @return The TileContainer in which this Item is stored
	 * @throws IllegalStateException If this Item is present in more than one place (i.e. an
	 * Inventory, an EquipmentSlot, a Tile, or a TileContainer), or if it has no Id, or if it has
	 * been deleted. It is legal for an Item to have no locations, e.g. when it has not yet been
	 * placed, or after it has been removed from an EquipmentSlot.
	 */
	TileFixture getTileFixture() throws IllegalStateException;

	/**
	 * <b>NB: This method is intended to <u>only</u> be used by
	 * {@link CharacterInventory#add} and
	 * {@link CharacterInventory#remove}; it is intended to check
	 * whether the Character assigned to this Item has this Item in its CharacterInventory.</b>
	 * @param character - The Character to which to assign to this Item
	 * @throws IllegalStateException If the Item currently in this slot cannot be equipped to this
	 * slot, or if the Character for this CharacterEquipmentSlot has been deleted
	 */
	void assignCharacterInventoryToItem(Character character)
			throws IllegalStateException, IllegalArgumentException;

	/**
	 * <b>NB: This method is intended to <u>only</u> be used by
	 * {@link CharacterEquipmentSlots#equipItemToSlot} and
	 * {@link CharacterEquipmentSlots#unequipEquipmentFromSlot}; it is intended to check
	 * whether the CharacterEquipmentSlot assigned to this Item has this Item set as equipped.</b>
	 * @param characterEquipmentSlots - The {@link CharacterEquipmentSlots} to which to assign to
	 *                                this Item
	 * @param equipmentSlotType - The equipment slot type to which to assign this Item
	 * @throws IllegalStateException If the Item currently in this slot cannot be equipped to this
	 * slot, or if the Character for this CharacterEquipmentSlot has been deleted
	 */
	void assignCharacterEquipmentSlotToItem(CharacterEquipmentSlots characterEquipmentSlots,
											String equipmentSlotType)
			throws IllegalStateException, IllegalArgumentException;

	/**
	 * <b>NB: This method is intended to <u>only</u> be used by {@link TileItems#addItem} and
	 * {@link TileItems#removeItem}; it is intended to check whether the Tile assigned to this
	 * Item has this Item in its TileItems, prior to assignment.</b>
	 * @param tile - The Tile to which to assign to this Item
	 * @throws IllegalStateException If the Item currently in this slot cannot be equipped to this
	 * slot, or if the Character for this CharacterEquipmentSlot has been deleted
	 */
	void assignTileToItem(Tile tile)
			throws IllegalStateException, IllegalArgumentException;

	/**
	 * <b>NB: This method is intended to <u>only</u> be used by
	 * {@link TileFixtureItems#addContainedItem} and
	 * {@link TileFixtureItems#removeContainedItem}; it is intended to check whether the
	 * TileFixture assigned to this Item has this Item in its contained items, prior to
	 * assignment.</b>
	 * @param tileFixture - The TileFixture to which to assign to this Item
	 * @throws IllegalArgumentException If and only if tileFixture is null, or tileFixture does not
	 * contain this Item
	 * @throws IllegalStateException If the Item currently in this slot cannot be equipped to this
	 * slot, or if the Character for this CharacterEquipmentSlot has been deleted
	 */
	void assignTileFixtureToItem(TileFixture tileFixture)
			throws IllegalArgumentException, IllegalStateException;
}
