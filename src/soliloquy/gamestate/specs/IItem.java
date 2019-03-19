package soliloquy.gamestate.specs;

import soliloquy.common.specs.IHasUuid;
import soliloquy.ruleset.gameentities.specs.IGameEntity;
import soliloquy.ruleset.gameentities.specs.IItemType;

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
public interface IItem extends IGameEntity, IHasUuid {
	/**
	 * @return The ItemType of this Item
	 * @throws IllegalStateException If this Item is present in more than one place (i.e. an
	 * Inventory, an EquipmentSlot, a Tile, or a TileContainer), or if it has no Id, or if it has
	 * been deleted. It is legal for an Item to have no locations, e.g. when it has not yet been
	 * placed, or after it has been removed from an EquipmentSlot.
	 */
	IItemType itemType() throws IllegalStateException;
	
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
	 * @return
	 * @throws IllegalStateException If this Item's ItemType does not allow it to be stacked, if
	 * this Item is present in more than one place (i.e. an Inventory, an EquipmentSlot, a Tile, or
	 * a TileContainer), or if it has no Id, or if it has been deleted. It is legal for an Item to
	 * have no locations, e.g. when it has not yet been placed, or after it has been removed from
	 * an EquipmentSlot.
	 */
	Integer getNumberInStack() throws IllegalStateException;
	
	/**
	 * Splits a stackable Item into two Items; returns the new Item with a number taken from the
	 * original Item's stack
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
	IItem takeFromStack(int numberToTake) throws UnsupportedOperationException, IllegalArgumentException, IllegalStateException;
	
	/**
	 * @return The Id of the Character in whose inventory this Item exists
	 * @throws IllegalStateException If this Item is present in more than one place (i.e. an
	 * Inventory, an EquipmentSlot, a Tile, or a TileContainer), or if it has no Id, or if it has
	 * been deleted. It is legal for an Item to have no locations, e.g. when it has not yet been
	 * placed, or after it has been removed from an EquipmentSlot.
	 */
	String getInventoryCharacterId() throws IllegalStateException;
	
	/**
	 * If this Item was in another location previously, it is removed from that location.
	 * @param charId - The Id of the Character in whose Inventory to place this Item
	 * @throws IllegalStateException If this Item is present in more than one place (i.e. an
	 * Inventory, an EquipmentSlot, a Tile, or a TileContainer), or if it has no Id, or if it has
	 * been deleted. It is legal for an Item to have no locations, e.g. when it has not yet been
	 * placed, or after it has been removed from an EquipmentSlot.
	 * @throws UnsupportedOperationException If this Item cannot be removed from its current
	 * location
	 */
	void setInventoryCharacterId(String charId) throws IllegalStateException, UnsupportedOperationException;
	
	/**
	 * @return The CharacterEquipmentSlot in which this Item is stored (If it is not in a
	 * CharacterEquipmentSlot, this returns null.)
	 * @throws IllegalStateException If this Item is present in more than one place (i.e. an
	 * Inventory, an EquipmentSlot, a Tile, or a TileContainer), or if it has no Id, or if it has
	 * been deleted. It is legal for an Item to have no locations, e.g. when it has not yet been
	 * placed, or after it has been removed from an EquipmentSlot.
	 */
	ICharacterEquipmentSlot getCharacterEquipmentSlot() throws IllegalStateException;
	
	/**
	 * If this Item was in another location previously, it is removed from that location.
	 * @param characterEquipmentSlot - The CharacterEquipmentSlot in which to store this Item
	 * @throws IllegalStateException If this Item is present in more than one place (i.e. an
	 * Inventory, an EquipmentSlot, a Tile, or a TileContainer), or if it has no Id, or if it has
	 * been deleted. It is legal for an Item to have no locations, e.g. when it has not yet been
	 * placed, or after it has been removed from an EquipmentSlot.
	 * @throws UnsupportedOperationException If this Item cannot be removed from its current
	 * location
	 */
	void setCharacterEquipmentSlot(ICharacterEquipmentSlot characterEquipmentSlot) throws IllegalStateException, UnsupportedOperationException;
	
	/**
	 * @return The Tile on which this Item is stored (Note that this means on the ground, and not
	 * in a container.)
	 * @throws IllegalStateException If this Item is present in more than one place (i.e. an
	 * Inventory, an EquipmentSlot, a Tile, or a TileContainer), or if it has no Id, or if it has
	 * been deleted. It is legal for an Item to have no locations, e.g. when it has not yet been
	 * placed, or after it has been removed from an EquipmentSlot.
	 */
	ITile getTile() throws IllegalStateException;
	
	/**
	 * If this Item was in another location previously, it is removed from that location.
	 * @param tile - The Tile on which to place this Item
	 * @throws IllegalStateException If this Item is present in more than one place (i.e. an
	 * Inventory, an EquipmentSlot, a Tile, or a TileContainer), or if it has no Id, or if it has
	 * been deleted. It is legal for an Item to have no locations, e.g. when it has not yet been
	 * placed, or after it has been removed from an EquipmentSlot.
	 * @throws UnsupportedOperationException If this Item cannot be removed from its current
	 * location.
	 */
	void setTile(ITile tile) throws IllegalStateException, UnsupportedOperationException;
	
	/**
	 * @return The TileContainer in which this Item is stored
	 * @throws IllegalStateException If this Item is present in more than one place (i.e. an
	 * Inventory, an EquipmentSlot, a Tile, or a TileContainer), or if it has no Id, or if it has
	 * been deleted. It is legal for an Item to have no locations, e.g. when it has not yet been
	 * placed, or after it has been removed from an EquipmentSlot.
	 */
	ITileFixture getTileFixture() throws IllegalStateException;
	
	/**
	 * If this Item was in another location previously, it is removed from that location.
	 * @param tileContainer - The TileContainer in which to store this Item
	 * @throws IllegalStateException If this Item is present in more than one place (i.e. an
	 * Inventory, an EquipmentSlot, a Tile, or a TileContainer), or if it has no Id, or if it has
	 * been deleted. It is legal for an Item to have no locations, e.g. when it has not yet been
	 * placed, or after it has been removed from an EquipmentSlot.
	 * @throws UnsupportedOperationException If this Item cannot be removed from its current
	 * location.
	 */
	void setTileFixture(ITileFixture tileContainer) throws IllegalStateException, UnsupportedOperationException;
}
