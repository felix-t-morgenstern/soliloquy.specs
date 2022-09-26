package soliloquy.specs.gamestate.factories;

import soliloquy.specs.common.shared.SoliloquyClass;
import soliloquy.specs.gamestate.entities.Character;
import soliloquy.specs.gamestate.entities.CharacterEvents;

/**
 * <b>CharacterEventsFactory</b>
 * <p>
 * This class creates a {@link CharacterEvents} for a given {@link Character}.
 *
 * @author felix.t.morgenstern
 * @version 0.0.1
 */
public interface CharacterEventsFactory extends SoliloquyClass {
    /**
     * @param character The Character for whom to create the CharacterEvents class
     * @return The newly-created CharacterEvents class
     * @throws IllegalArgumentException If and only if character is null
     */
    CharacterEvents make(Character character) throws IllegalArgumentException;
}
