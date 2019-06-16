package soliloquy.specs.ruleset.entities;

import soliloquy.specs.common.shared.IHasId;
import soliloquy.specs.common.shared.IHasPluralName;
import soliloquy.specs.gamestate.entities.IItem;
import soliloquy.specs.gamestate.entities.ICharacterEquipmentSlots;

/**
 * <b>EquipmentType</b>
 * <p>
 * This class is a property of {@link IItemType}s. It is intended to be used by
 * {@link ICharacterEquipmentSlots#canEquipItemToSlot(String, IItem)}, to
 * determine whether an ItemType of this EquipmentType can be equipped to a CharacterEquipmentSlot.
 * <p>
 * Examples include helmets, necklaces, mystical auras, makeup, etc.
 * 
 * @author felix.t.morgenstern
 * @version 0.0.1
 *
 */
public interface IEquipmentType extends IHasId, IHasPluralName {
    /**
     * @param equipmentSlotType - The type of equipment slot to see whether Items of this
     *                          EquipmentType can be placed within it
     * @return True, if and only if an Item whose ItemType is of this EquipmentType can be equipped
     * to an equipment slot of equipmentSlotType
     * @throws IllegalArgumentException If and only if equipmentSlotType is null or empty
     */
    boolean canEquipToSlotType(String equipmentSlotType) throws IllegalArgumentException;
}
