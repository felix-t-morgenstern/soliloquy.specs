package soliloquy.specs.gamestate.entities.timers;

import soliloquy.specs.common.entities.Action;
import soliloquy.specs.common.shared.HasId;
import soliloquy.specs.gamestate.entities.Deletable;
import soliloquy.specs.gamestate.entities.gameevents.TriggeredEvent;

/**
 * <b>RoundBasedTimer</b>
 * <p>
 * Shared functionality of OneTimeRoundBasedTimer and RecurringRoundBasedTimer
 *
 * @author felix.t.morgenstern
 * @version 0.0.1
 */
public interface RoundBasedTimer extends HasId, TriggeredEvent, Deletable {
    /**
     * @return The Id of the {@link Action} which runs when this RoundBasedTimer is fired
     */
    String actionId();
}
