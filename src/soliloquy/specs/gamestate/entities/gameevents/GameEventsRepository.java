package soliloquy.specs.gamestate.entities.gameevents;

import soliloquy.specs.common.shared.SoliloquyClass;

/**
 * <b>GameEventsRepository</b>
 * <p>
 * This class is a repository of {@link GameEvent}s, which may be assigned to various
 * {@link soliloquy.specs.gamestate.entities.Tile}s or
 * {@link soliloquy.specs.gamestate.entities.TileFixture}s.
 *
 * @author felix.t.morgenstern
 * @version 0.0.1
 */
public interface GameEventsRepository extends SoliloquyClass {
    /**
     * @param gameEvent - The {@link GameEvent} to register
     * @throws IllegalArgumentException If and only if gameEvent is null
     */
    void register(GameEvent gameEvent) throws IllegalArgumentException;

    /**
     * @param gameEventId - The Id of the {@link GameEvent} to retrieve
     * @return The {@link GameEvent} of the specified id; if no such GameEvent exists, then returns
     * null
     * @throws IllegalArgumentException If and only if gameEventId is null or empty
     */
    GameEvent get(String gameEventId) throws IllegalArgumentException;
}
