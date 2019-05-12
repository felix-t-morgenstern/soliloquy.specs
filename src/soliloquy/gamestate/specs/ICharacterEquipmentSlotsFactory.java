package soliloquy.gamestate.specs;

import soliloquy.common.specs.ISoliloquyClass;

/**
 * <b>CharacterEquipmentSlotsFactory</b>
 * <p>
 * This class is a factory which creates a CharacterEquipmentSlots, to be assigned to a Character
 * (i.e. in its constructor).
 *
 * @author felix.t.morgenstern
 * @version 0.0.1
 */
public interface ICharacterEquipmentSlotsFactory extends ISoliloquyClass {
    /**
     * @param character - The Character for whom to make the CharacterEquipmentSlots
     * @return The new CharacterEquipmentSlots
     * @throws IllegalArgumentException If and only if character is null
     */
    ICharacterEquipmentSlots make(ICharacter character) throws IllegalArgumentException;
}
