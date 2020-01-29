package soliloquy.specs.gamestate.factories;

import soliloquy.specs.common.infrastructure.VariableCache;
import soliloquy.specs.common.shared.SoliloquyClass;
import soliloquy.specs.gamestate.entities.GameState;
import soliloquy.specs.gamestate.entities.Party;

/**
 * <b>GameStateFactory</b>
 * <p>
 * This class creates a {@link GameState}.
 *
 * @author felix.t.morgenstern
 * @version 0.0.1
 */
public interface GameStateFactory extends SoliloquyClass {
    /**
     * @param party - The Party for the game
     * @param data - The VariableCache for the game
     * @return The newly-created GameState
     * @throws IllegalArgumentException If and only if data is null
     */
    GameState make(Party party, VariableCache data) throws IllegalArgumentException;
}
