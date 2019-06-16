package soliloquy.specs.gamestate.factories;

import soliloquy.specs.gamestate.entities.ICharacterInventory;
import soliloquy.specs.gamestate.entities.ICharacter;
import soliloquy.specs.common.shared.ISoliloquyClass;

/**
 * <b>CharacterInventoryFactory</b>
 * <p>
 * This class creates CharacterInventories for a provided Character
 *
 * @author felix.t.morgenstern
 * @version 0.0.1
 */
public interface ICharacterInventoryFactory extends ISoliloquyClass {
    /**
     * @param character - The Character for whom to make this CharacterInventory
     * @return A new CharacterInventory for the provided Character
     */
    ICharacterInventory make(ICharacter character);
}
