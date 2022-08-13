package soliloquy.specs.gamestate.factories;

import soliloquy.specs.common.shared.SoliloquyClass;
import soliloquy.specs.gamestate.entities.Character;
import soliloquy.specs.gamestate.entities.CharacterInventory;

/**
 * <b>CharacterInventoryFactory</b>
 * <p>
 * This class creates CharacterInventories for a provided Character
 *
 * @author felix.t.morgenstern
 * @version 0.0.1
 */
public interface CharacterInventoryFactory extends SoliloquyClass {
    /**
     * @param character The Character for whom to make this CharacterInventory
     * @return A new CharacterInventory for the provided Character
     */
    CharacterInventory make(Character character);
}
