package soliloquy.specs.gamestate.factories;

import soliloquy.specs.gamestate.entities.Character;
import soliloquy.specs.ruleset.entities.character.CharacterType;

import java.util.Map;
import java.util.UUID;

/**
 * <b>CharacterFactory</b>
 * <p>
 * This class is responsible for taking a {@link CharacterType} and generating a blank
 * {@link Character} of that type.
 * <p>
 * <i>NB: {@link CharacterType} is responsible for calling {@link #make}, and then setting values
 * such as base characterStatisticTypes, equipment slots, inventory items, etc. This is necessary to
 * allow
 * CharacterTypes to be generated dynamically, without forcing a specific pattern of  value
 * generation.</i>
 *
 * @author felix.t.morgenstern
 * @version 0.0.1
 */
public interface CharacterFactory {
    /**
     * This method creates a {@link Character} with a randomly-generated UUID.
     *
     * @param characterType The {@link CharacterType} of which to make a new {@link Character}
     * @return The newly-created {@link Character}
     * @throws IllegalArgumentException If and only if characterType is null
     */
    Character make(CharacterType characterType) throws IllegalArgumentException;

    /**
     * @param characterType The {@link CharacterType} of which to make a new {@link Character}
     * @param uuid          The UUID for the newly-created {@link Character}
     * @param data          The data for the newly-created {@link Character}
     * @return The newly-created {@link Character}
     * @throws IllegalArgumentException If and only if characterType or uuid is null
     */
    Character make(CharacterType characterType, UUID uuid, Map<String, Object> data)
            throws IllegalArgumentException;
}
