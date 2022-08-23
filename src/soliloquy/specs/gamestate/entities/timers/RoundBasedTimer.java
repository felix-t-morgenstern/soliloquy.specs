package soliloquy.specs.gamestate.entities.timers;

import soliloquy.specs.common.entities.Action;
import soliloquy.specs.common.shared.HasId;
import soliloquy.specs.gamestate.entities.Deletable;

/**
 * <b>RoundBasedTimer</b>
 * <p>
 * Shared functionality of {@link OneTimeRoundBasedTimer} and {@link RecurringRoundBasedTimer}.
 * <p>
 * When a RoundBasedTimer is fired, <i>it is assumed to be a timer for a game event.</i> Therefore,
 * when each Timer's round arrives, it is expected that it will be registered with {@link
 * soliloquy.specs.gamestate.entities.gameevents.GameEventFiring#registerEvent}.
 *
 * @author felix.t.morgenstern
 * @version 0.0.1
 */
public interface RoundBasedTimer extends HasId, Deletable, Runnable {
    /**
     * @return The priority for this event, with higher value implying higher priority; when
     *         multiple events are fired, events with higher priority are fired first. (If multiple
     *         events have the same priority, no assurances are made as to which will fire first!)
     */
    int priority();

    /**
     * @return The Id of the {@link Action} which runs when this RoundBasedTimer is fired
     */
    String actionId();
}
