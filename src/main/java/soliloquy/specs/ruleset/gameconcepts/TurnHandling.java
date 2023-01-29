package soliloquy.specs.ruleset.gameconcepts;

import soliloquy.specs.gamestate.entities.Character;

/**
 * <b>TurnHandling</b>
 * <p>
 * This class runs the turn for a provided Character.
 *
 * @author felix.t.morgenstern
 * @version 0.0.1
 */
public interface TurnHandling {
    /**
     * @param character The Character whose turn to run
     * @throws IllegalArgumentException If and only if character is null
     */
    void runTurn(Character character) throws IllegalArgumentException;
}
