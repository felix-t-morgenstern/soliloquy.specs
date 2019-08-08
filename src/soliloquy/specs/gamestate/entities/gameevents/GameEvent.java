package soliloquy.specs.gamestate.entities.gameevents;

import soliloquy.specs.common.shared.HasGlobalAccess;
import soliloquy.specs.common.shared.HasId;

/**
 * <b>GameEvent</b>
 * <p>
 * This class describes an event which can be fired, optionally having a {@link GameEventSource}
 * and a {@link GameEventTarget}.
 * <p>
 * Expected behavior is that {@link #fire} will check whether the entries of the provided
 * {@link GameEventSource} and {@link GameEventTarget} are null before performing any calls against
 * the expected source and/or target.
 *
 * @author felix.t.morgenstern
 * @version 0.0.1
 */
public interface GameEvent extends HasId, HasGlobalAccess {
    /**
     * Fires this GameEvent with the provided source and target
     * @param source - The {@link GameEventSource} firing this GameEvent
     * @param target - The {@link GameEventTarget} of this GameEvent
     * @throws IllegalArgumentException If and only if source or target are null
     */
    void fire(GameEventSource source, GameEventTarget target) throws IllegalArgumentException;
}
