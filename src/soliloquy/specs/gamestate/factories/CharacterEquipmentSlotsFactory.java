package soliloquy.specs.gamestate.factories;

import soliloquy.specs.gamestate.entities.Character;
import soliloquy.specs.gamestate.entities.CharacterEquipmentSlots;
import soliloquy.specs.common.shared.SoliloquyClass;

/**
 * <b>CharacterEquipmentSlotsFactory</b>
 * <p>
 * This class is a factory which creates a CharacterEquipmentSlots, to be assigned to a Character
 * (i.e. in its constructor).
 *
 * @author felix.t.morgenstern
 * @version 0.0.1
 */
public interface CharacterEquipmentSlotsFactory extends SoliloquyClass {
    /**
     * @param character - The Character for whom to make the CharacterEquipmentSlots
     * @return The new CharacterEquipmentSlots
     * @throws IllegalArgumentException If and only if character is null
     */
    CharacterEquipmentSlots make(Character character) throws IllegalArgumentException;
}
