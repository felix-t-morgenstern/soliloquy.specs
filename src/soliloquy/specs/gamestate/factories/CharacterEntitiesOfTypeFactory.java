package soliloquy.specs.gamestate.factories;

import soliloquy.specs.common.shared.HasId;
import soliloquy.specs.common.shared.SoliloquyClass;
import soliloquy.specs.gamestate.entities.Character;
import soliloquy.specs.gamestate.entities.CharacterEntitiesOfType;
import soliloquy.specs.gamestate.entities.CharacterEntityOfType;

import java.util.function.Function;

/**
 * <b>CharacterEntitiesOfTypeFactory</b>
 * <p>
 * Creates a collection of Character entities of a specified type
 *
 * @author felix.t.morgenstern
 * @version 0.0.1
 */
public interface CharacterEntitiesOfTypeFactory extends SoliloquyClass {
    <TEntityType extends HasId, TCharacterEntityOfType extends CharacterEntityOfType<TEntityType>>
    CharacterEntitiesOfType<TEntityType, TCharacterEntityOfType>
        make(Character character, TCharacterEntityOfType archetype)
            throws IllegalArgumentException;

    <TEntityType extends HasId, TCharacterEntityOfType extends CharacterEntityOfType<TEntityType>>
    void registerFactory(TCharacterEntityOfType archetype, Function<TEntityType,Function<Character,
            TCharacterEntityOfType>> entityFactory) throws IllegalArgumentException;
}
