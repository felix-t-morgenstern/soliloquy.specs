package soliloquy.specs.gamestate.infrastructure;

import soliloquy.specs.common.shared.SoliloquyClass;
import soliloquy.specs.gamestate.entities.gameevents.TriggeredEvent;

/**
 * <b>GameSaveBlocker</b>
 * <p>
 * This class determines whether or not saving the gamestate is, at any point, allowed or
 * prohibited. The assumption of this class is that the gamestate may not be saved while any event
 * is firing; also, manual blocks on saving the gamestate can be placed (e.g. when combat
 * initiates or during cutscenes).
 *
 * @author felix.t.morgenstern
 * @version 0.0.1
 */
public interface GameSaveBlocker extends SoliloquyClass {
    /**
     * This call is expected to be made when an event first fires
     *
     * @param triggeredEvent The TriggeredEvent for which to place a block on saving the gamestate
     * @throws IllegalArgumentException If and only if triggeredEvent is null
     */
    void placeTriggeredEventBlock(TriggeredEvent triggeredEvent) throws IllegalArgumentException;

    /**
     * This call is expected to be made when an event has finished firing
     *
     * @param triggeredEvent The TriggeredEvent for whose block on saving the gamestate to remove
     * @throws IllegalArgumentException If and only if triggeredEvent is null
     */
    void releaseTriggeredEventBlock(TriggeredEvent triggeredEvent) throws IllegalArgumentException;

    /**
     * Places the manual block on saving the game. (If this block has already been placed, then
     * this call has no effect.)
     */
    void placeManualBlock();

    /**
     * Releases the manual block on saving the game. (If this block has already been placed, then
     * this call has no effect.)
     */
    void releaseManualBlock();

    /**
     * @return True, if and only if the gamestate can be saved; i.e., if and only if there are no
     *         TriggeredEvents placing blocks on saving the game, and if there is no manual block
     *         placed on
     *         saving the game.
     */
    boolean canSaveGame();
}
