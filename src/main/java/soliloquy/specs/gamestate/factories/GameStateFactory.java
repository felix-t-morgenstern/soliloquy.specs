package soliloquy.specs.gamestate.factories;

import soliloquy.specs.gamestate.GameState;
import soliloquy.specs.gamestate.entities.Party;

import java.util.Map;

/**
 * <b>GameStateFactory</b>
 * <p>
 * This class creates a {@link GameState}.
 *
 * @author felix.t.morgenstern
 * @version 0.0.1
 */
public interface GameStateFactory {
    /**
     * @param party The Party for the game
     * @param data  The VariableCache for the game
     * @return The newly-created GameState
     * @throws IllegalArgumentException If and only if data is null
     */
    GameState make(Party party, Map<String, Object> data) throws IllegalArgumentException;
}
