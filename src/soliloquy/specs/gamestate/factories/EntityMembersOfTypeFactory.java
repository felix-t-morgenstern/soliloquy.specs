package soliloquy.specs.gamestate.factories;

import soliloquy.specs.common.infrastructure.VariableCache;
import soliloquy.specs.common.shared.HasId;
import soliloquy.specs.common.shared.SoliloquyClass;
import soliloquy.specs.gamestate.entities.Character;
import soliloquy.specs.gamestate.entities.EntityMemberOfType;
import soliloquy.specs.gamestate.entities.EntityMembersOfType;

import java.util.function.Function;

/**
 * <b>EntityMembersOfTypeFactory</b>
 * <p>
 * Creates a collection of Character entities of a specified type
 *
 * @author felix.t.morgenstern
 * @version 0.0.1
 */
public interface EntityMembersOfTypeFactory extends SoliloquyClass {
    /**
     * @param character - The Character for whom to make an aggregated entity (e.g.
     *                  {@link soliloquy.specs.gamestate.entities.CharacterStatistic})
     * @param archetype - An archetype of the type of CharacterEntity being created
     * @param <TEntityType> The entity type of the CharacterEntity being created
     * @param <TCharacterEntityOfType> The type of the CharacterEntity being created
     * @return The newly-created CharacterEntity
     * @throws IllegalArgumentException If and only if character or archetype are null
     * @throws UnsupportedOperationException If and only if no factory has been registered for the
     *                                       specified types
     */
    @SuppressWarnings("rawtypes")
    <TEntityType extends HasId, TCharacterEntityOfType extends EntityMemberOfType<TEntityType>>
    EntityMembersOfType make(Character character, TCharacterEntityOfType archetype)
            throws IllegalArgumentException, UnsupportedOperationException;

    /**
     * @param archetype - An archetype of the type of CharacterEntity made by the factory
     * @param entityFactory - The factory to make new CharacterEntities of the specified types
     * @param <TEntityType> The entity type of the CharacterEntity made by the factory
     * @param <TCharacterEntityOfType> The type of the CharacterEntity made by the factory
     * @throws IllegalArgumentException If and only if archetype or factory are null
     */
    <TEntityType extends HasId, TCharacterEntityOfType extends EntityMemberOfType<TEntityType>>
    void registerFactory(TCharacterEntityOfType archetype,
                         Function<Character,Function<TEntityType,Function<VariableCache,
                                 TCharacterEntityOfType>>> entityFactory)
            throws IllegalArgumentException;
}
