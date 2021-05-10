package soliloquy.specs.gamestate.entities.timers;

import soliloquy.specs.common.shared.HasId;
import soliloquy.specs.gamestate.entities.gameevents.firings.TriggeredEvent;

/**
 * <b>TurnBasedTimer</b>
 * <p>
 * Shared functionality of OneTimeTurnBasedTimer and RecurringTurnBasedTimer
 *
 * @author felix.t.morgenstern
 * @version 0.0.1
 *
 */
public interface TurnBasedTimer extends HasId, Timer, TriggeredEvent {
    /**
     * Fires the TurnBasedTimer. For {@link OneTimeTurnBasedTimer}s, this also calls
     * {@link OneTimeTurnBasedTimer#delete}.
     */
    void fire();
}
