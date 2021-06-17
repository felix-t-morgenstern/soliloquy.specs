package soliloquy.specs.gamestate.entities.timers;

import soliloquy.specs.common.entities.Action;
import soliloquy.specs.common.shared.HasId;
import soliloquy.specs.gamestate.entities.Deletable;
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
public interface TurnBasedTimer extends HasId, TriggeredEvent, Deletable {
    /**
     * @return The {@link Action} which runs when this TurnBasedTimer is fired
     */
    Action action();
}
