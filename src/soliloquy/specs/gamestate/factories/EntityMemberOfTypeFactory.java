package soliloquy.specs.gamestate.factories;

import soliloquy.specs.common.infrastructure.VariableCache;
import soliloquy.specs.common.shared.HasId;
import soliloquy.specs.common.shared.SoliloquyClass;
import soliloquy.specs.gamestate.entities.Character;
import soliloquy.specs.gamestate.entities.EntityMemberOfType;

/**
 * <b>EntityMemberOfTypeFactory</b>
 * <p>
 * Creates an entity for a provided {@link Character} of a given type
 *
 * @author felix.t.morgenstern
 * @version 0.0.1
 */
public interface EntityMemberOfTypeFactory<TCharacterEntityType extends HasId,
        TCharacterEntityOfType extends EntityMemberOfType<TCharacterEntityType>>
            extends SoliloquyClass {
    /**
     * <i>NB: This method creates a EntityMemberOfType without any data; to provide data, cf
     * {@link #make(Character, HasId, VariableCache)}</i>.
     * @param character - The Character for whom to make the entity
     * @param type - The type of the CharacterEntity of the provided type
     * @return The newly-created CharacterEntity of the provided type
     * @throws IllegalArgumentException If and only if character or type are null
     */
    TCharacterEntityOfType make(Character character, TCharacterEntityType type)
            throws IllegalArgumentException;
    /**
     * @param character - The Character for whom to make the entity
     * @param type - The type of the CharacterEntity of the provided type
     * @param data - The data for the newly-created CharacterEntity of the provided type
     * @return The newly-created CharacterEntity of the provided type
     * @throws IllegalArgumentException If and only if character, type, or data are null
     */
    TCharacterEntityOfType make(Character character, TCharacterEntityType type, VariableCache data)
            throws IllegalArgumentException;
}
