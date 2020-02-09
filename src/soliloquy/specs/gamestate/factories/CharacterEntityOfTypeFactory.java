package soliloquy.specs.gamestate.factories;

import soliloquy.specs.common.shared.HasId;
import soliloquy.specs.common.shared.SoliloquyClass;
import soliloquy.specs.gamestate.entities.Character;
import soliloquy.specs.gamestate.entities.CharacterEntityOfType;

/**
 * <b>CharacterEntityOfTypeFactory</b>
 * <p>
 * Creates an entity for a provided {@link Character} of a given type
 *
 * @author felix.t.morgenstern
 * @version 0.0.1
 */
public interface CharacterEntityOfTypeFactory<TCharacterEntityType extends HasId,
        TCharacterEntityOfType extends CharacterEntityOfType<TCharacterEntityType>>
            extends SoliloquyClass {
    /**
     * @param character - The Character for whom to make the entity
     * @param type - The type of the CharacterStaticStatistic
     * @return The newly-created CharacterStaticStatistic
     * @throws IllegalArgumentException If and only if character is null, or if type is null
     */
    TCharacterEntityOfType make(Character character, TCharacterEntityType type)
            throws IllegalArgumentException;
}
