package soliloquy.specs.gamestate.entities;

import soliloquy.specs.common.infrastructure.Map;

/**
 * <b>CharacterEquipmentSlots</b>
 * <p>
 * This class handles CharacterEquipmentSlots present on a Character. It exists to handle
 * invariants which must be enforced, since a Character should know its CharacterEquipmentSlots,
 * and CharacterEquipmentSlots should know their Character. To be more specific, every
 * CharacterEquipmentSlot on a Character should know that it belongs to that Character, and
 * vice-versa.
 * <p>
 * This class also supports providing a <i>representation</i> of the CharacterEquipmentSlots on
 * this Character; i.e., a Map containing all of those CharacterEquipmentSlots. <u>Editing the Map
 * provided by getCharacterEquipmentSlotsRepresentation will not change the CharacterEquipmentSlots
 * on the Character.</u> To do that, use the add and remove methods, also provided.
 *
 * @author felix.t.morgenstern
 * @version 0.0.1
 */
public interface CharacterEquipmentSlots extends Deletable {
    /**
     * <i>NB: This is only supposed to be a REPRESENTATION of the Items equipped by this Character.
     * To add or remove CharacterEquipmentSlots, use the other methods specified.</i>
     *
     * @return A Map of Items equipped by this Character, where the keys are the equipment slot
     *         types.
     * @throws IllegalStateException If this Character does not have a GameZone, or if this
     *                               Character has been deleted
     */
    Map<String, Item> representation() throws IllegalStateException;

    /**
     * @param equipmentSlotType The equipment slot type to add for this Character
     * @throws IllegalArgumentException If and only if equipmentSlotType is null or empty
     * @throws IllegalStateException    If this Character does not have a GameZone, or if this
     *                                  Character has been deleted
     */
    void addCharacterEquipmentSlot(String equipmentSlotType)
            throws IllegalArgumentException, IllegalStateException;

    /**
     * @param equipmentSlotType The equipment slot type whose presence to check
     * @return True, if and only if this Character has an equipment slot of the type specified
     * @throws IllegalArgumentException If and only if equipmentSlotType is null or empty, or if
     *                                  equipmentSlotType does not exist for this Character
     * @throws IllegalStateException    If this Character does not have a GameZone, or if this
     *                                  Character has been deleted
     */
    boolean equipmentSlotExists(String equipmentSlotType)
            throws IllegalArgumentException, IllegalStateException;

    /**
     * @param equipmentSlotType The type of the equipment slot to remove
     * @return The Item present in this slot; null, if no Item was present
     * @throws IllegalArgumentException If and only if equipmentSlotType is null or empty, or if
     *                                  equipmentSlotType does not exist for this Character
     * @throws IllegalStateException    If this Character does not have a GameZone, or if this
     *                                  Character has been deleted
     */
    Item removeCharacterEquipmentSlot(String equipmentSlotType)
            throws IllegalArgumentException, IllegalStateException;

    /**
     * <i>NB: Deleting the Item is an acceptable way to remove it from its slot</i>
     *
     * @param equipmentSlotType The CharacterEquipmentSlot whose Item to return
     * @return The Item present in this slot; null, if no Item was present
     * @throws IllegalArgumentException If and only if equipmentSlotType is null or empty, or if
     *                                  equipmentSlotType does not exist for this Character
     * @throws IllegalStateException    If this Character does not have a GameZone, or if this
     *                                  Character has been deleted
     */
    Item itemInSlot(String equipmentSlotType)
            throws IllegalArgumentException, IllegalStateException;

    /**
     * @param item This slot checks this item to see whether this item can be equipped to this
     *             slot
     * @return True, if and only if this Item can be equipped to this slot
     * @throws IllegalArgumentException If and only if equipmentSlotType is null or empty, or if
     *                                  equipmentSlotType does not exist for this Character, or if
     *                                  item is null
     * @throws IllegalStateException    If this Character does not have a GameZone, or if this
     *                                  Character has been deleted
     */
    boolean canEquipItemToSlot(String equipmentSlotType, Item item)
            throws IllegalArgumentException, IllegalStateException;

    /**
     * <b>To unequip items from slots, set item to be null.</b>
     *
     * @param equipmentSlotType The equipment slot in which to equip item
     * @param item              The Item to equip to this slot. <b>This may be null, in the case
     *                          where an Item
     *                          is being unequipped from the slot.</b>
     * @return The Item previously equipped to this slot (if any)
     * @throws IllegalArgumentException      If and only if equipmentSlotType is null or empty, or
     *                                       if
     *                                       equipmentSlotType does not exist for this Character, or
     *                                       if item is null, or if item cannot
     *                                       be equipped to this slot
     * @throws IllegalStateException         If this Character does not have a GameZone, or if this
     *                                       Character has been deleted
     * @throws UnsupportedOperationException If and only if equipmentSlotType is set to not allow
     *                                       altering its Equipped item
     */
    Item equipItemToSlot(String equipmentSlotType, Item item)
            throws IllegalArgumentException, IllegalStateException, UnsupportedOperationException;

    /**
     * This method is intended to return false for Items that cannot be removed, e.g. Items
     * magically bound to the Character or grafted onto their body
     *
     * @return True, if and only if the Item currently equipped to this slot can be removed
     * @throws IllegalArgumentException If and only if equipmentSlotType is null or empty, or if
     *                                  equipmentSlotType does not exist for this Character
     * @throws IllegalStateException    If the Item currently in this slot cannot be equipped to
     *                                  this
     *                                  slot, or if the Character for this CharacterEquipmentSlot
     *                                  has been deleted
     */
    boolean getCanAlterEquipmentInSlot(String equipmentSlotType)
            throws IllegalArgumentException, IllegalStateException;

    /**
     * @param canAlterEquipmentInSlot Whether the Item currently in this slot can be removed
     * @throws UnsupportedOperationException If there is no Item in this slot
     * @throws IllegalArgumentException      If and only if equipmentSlotType is null or empty, or
     *                                       if
     *                                       equipmentSlotType does not exist for this Character
     * @throws IllegalStateException         If the Item currently in this slot cannot be equipped
     *                                       to this
     *                                       slot, or if the Character for this
     *                                       CharacterEquipmentSlot
     *                                       has been deleted
     */
    void setCanAlterEquipmentInSlot(String equipmentSlotType, boolean canAlterEquipmentInSlot)
            throws IllegalArgumentException, IllegalStateException;
}
