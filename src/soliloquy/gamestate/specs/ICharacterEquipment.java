package soliloquy.gamestate.specs;

import soliloquy.common.specs.IMap;

/**
 * <b>CharacterEquipment</b>
 * <p>
 * CharacterEquipment is a set of CharacterEquipmentSlots.
 * <p>
 * The index to this set is the Id of the Equipment Slot type.
 * 
 * @author felix.t.morgenstern
 * @version 0.0.1
 *
 */

public interface ICharacterEquipment extends IMap<String,ICharacterEquipmentSlot> {
}
