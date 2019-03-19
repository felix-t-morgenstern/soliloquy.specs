package soliloquy.gamestate.specs;

import soliloquy.common.specs.ISoliloquyClass;

/**
 * <b>CharacterEquipmentSlot</b>
 * <p>
 * A CharacterEquipmentSlot is of an EquipmentSlotType.
 * <p>
 * It may have an item.
 * <p>
 * You can determine whether or not you can equip an item to it.
 * <p>
 * If you equip an item to it and replace an item, the item you're replacing will be returned to
 * the calling function.
 * <p>
 * You can determine whether you can remove the item in that slot. 
 * 
 * @author felix.t.morgenstern
 * @version 0.0.1
 *
 */

public interface ICharacterEquipmentSlot extends ISoliloquyClass {
	/**
	 * @param character - The Character to which to initialize this CharacterEquipmentSlot
	 * @throws IllegalArgumentException If character is null, or if character's CharacterEquipment
	 * already has a CharacterEquipmentSlot of this equipmentSlotType.
	 * @throws UnsupportedOperationException If the Character for this CharacterEquipmentSlot has
	 * already been initialized
	 */
	void initializeCharacter(ICharacter character) throws IllegalArgumentException, UnsupportedOperationException;
	
	/**
	 * @return The Character to whom this CharacterEquipmentSlot belongs
	 * @throws IllegalStateException If the Item currently in this slot cannot be equipped to this
	 * slot
	 * @throws UnsupportedOperationException If the Item currently in this slot cannot be equipped
	 * to this slot, or the CharacterId of this slot does not point to a Character that has this
	 * slot, or the Character has been deleted
	 */
	ICharacter character() throws IllegalStateException, UnsupportedOperationException;
	
	/**
	 * 
	 * @param equipmentSlotType - The equipmentSlotType to initialize for this
	 * CharacterEquipmentSlot
	 * @throws IllegalArgumentException If equipmentSlotType is blank or null
	 * @throws UnsupportedOperationException If equipmentSlotType has already been initialized
	 */
	void initializeEquipmentSlotType(String equipmentSlotType) throws IllegalArgumentException, UnsupportedOperationException;
	
	/**
	 * @return The name of the type of this equipment slot, e.g. "HELMET", "TORSO", "EARRING"
	 * @throws IllegalStateException If the Item currently in this slot cannot be equipped to this
	 * slot
	 * @throws UnsupportedOperationException If the Item currently in this slot cannot be equipped
	 * to this slot, or the CharacterId of this slot does not point to a Character that has this
	 * slot, or the Character has been deleted
	 */
	String equipmentSlotType() throws IllegalStateException, UnsupportedOperationException;
	
	/**
	 * @return True, if and only if this slot is empty
	 * @throws IllegalStateException If the Item currently in this slot cannot be equipped to this
	 * slot, or if its Character or equipmentSlotType have not been initialized
	 * @throws UnsupportedOperationException If the Item currently in this slot cannot be equipped
	 * to this slot, or the CharacterId of this slot does not point to a Character that has this
	 * slot, or the Character has been deleted
	 */
	boolean isEmpty() throws IllegalStateException, UnsupportedOperationException;

	/**
	 * @return The Item in this slot. (If no Item is present, then this returns null.)
	 * @throws IllegalStateException If the Item currently in this slot cannot be equipped to this
	 * slot, or if its Character or equipmentSlotType have not been initialized
	 * @throws UnsupportedOperationException If the Item currently in this slot cannot be equipped
	 * to this slot, or the CharacterId of this slot does not point to a Character that has this slot, or the Character has been deleted
	 */
	IItem itemInSlot() throws IllegalStateException, UnsupportedOperationException;
	
	/**
	 * @param item - This slot checks this item to see whether this item can be equipped to this
	 * slot
	 * @return True, if and only if this Item can be equipped to this slot
	 * @throws IllegalArgumentException If item is null
	 * @throws IllegalStateException If the Item currently in this slot cannot be equipped to this
	 * slot, or the CharacterId of this slot does not point to a Character that has this slot, or
	 * the Character has been deleted, or if its Character or equipmentSlotType have not been
	 * initialized
	 */
	boolean canEquipItemToSlot(IItem item) throws IllegalStateException, UnsupportedOperationException;
	
	/**
	 * Equips an item to this slot
	 * <p>
	 * (This method is encouraged to call unequipEquipmentFromSlot before equipping an Item to this
	 * slot.)
	 * @param item - The Item to equip to this slot
	 * @throws IllegalArgumentException If item is null, or if item cannot be equipped to this slot
	 * @throws IllegalStateException If the Item currently in this slot cannot be equipped to this
	 * slot, or the CharacterId of this slot does not point to a Character that has this slot, or
	 * the Character has been deleted, or if its Character or equipmentSlotType have not been
	 * initialized
	 */
	IItem equipInventoryItemToSlot(IItem item) throws IllegalStateException, UnsupportedOperationException;
	
	/**
	 * This method is intended to return false for Items that cannot be removed, e.g. Items
	 * magically bound to the Character or grafted onto their body
	 * @return True, if and only if the Item currently equipped to this slot can be removed
	 * @throws IllegalStateException If the Item currently in this slot cannot be equipped to this
	 * slot, or the CharacterId of this slot does not point to a Character that has this slot, or
	 * the Character has been deleted, or if its Character or equipmentSlotType have not been
	 * initialized
	 */
	boolean getCanRemoveEquipmentFromSlot() throws IllegalStateException, UnsupportedOperationException;
	
	/**
	 * @param canRemoveEquipmentFromSlot - Whether the Item currently in this slot can be removed
	 * @throws UnsupportedOperationException If there is no Item in this slot
	 * @throws IllegalStateException If the Item currently in this slot cannot be equipped to this
	 * slot, or the CharacterId of this slot does not point to a Character that has this slot, or
	 * the Character has been deleted, or if its Character or equipmentSlotType have not been
	 * initialized
	 */
	void setCanRemoveEquipmentFromSlot(boolean canRemoveEquipmentFromSlot) throws UnsupportedOperationException, IllegalStateException;
	
	/**
	 * Removes the Item in this slot from this slot
	 * @return The Item currently in this slot, i.e. so it may be returned to Inventory
	 * @throws UnsupportedOperationException If there is no Item in this slot, or the Item
	 * currently in this slot cannot be removed from this slot
	 * @throws IllegalStateException If the Item currently in this slot cannot be equipped to this
	 * slot, or the CharacterId of this slot does not point to a Character that has this slot, or
	 * the Character has been deleted, or if its Character or equipmentSlotType have not been
	 * initialized
	 */
	IItem unequipEquipmentFromSlot() throws UnsupportedOperationException, IllegalStateException;
}
