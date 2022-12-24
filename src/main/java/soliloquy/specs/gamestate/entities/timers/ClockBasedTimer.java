package soliloquy.specs.gamestate.entities.timers;

import soliloquy.specs.common.shared.HasId;
import soliloquy.specs.common.shared.PausableAtTime;
import soliloquy.specs.graphics.shared.HasMostRecentTimestamp;

/**
 * <b>ClockBasedTimer</b>
 * <p>
 * This class is a timer, which fires not based on how many turns have elapsed, but based on how
 * many milliseconds have elapsed. It exposes the id of the
 * {@link soliloquy.specs.common.entities.Action} which runs when the timer is fired, so that it
 * can be persisted.
 *
 * @author felix.t.morgenstern
 * @version 0.0.1
 */
public interface ClockBasedTimer extends HasId, PausableAtTime, HasMostRecentTimestamp {
    /**
     * @return The Id of the {@link soliloquy.specs.common.entities.Action} which runs when this
     *         ClockBasedTimer is fired
     */
    String actionId();

    /**
     * @param timestamp The timestamp at which to fire this Timer
     * @throws UnsupportedOperationException If and only if timestamp is greater than or equal to
     *                                       the current paused timestamp
     * @throws IllegalArgumentException      If and only if timestamp is before most recent
     *                                       timestamp provided to this class
     */
    void fire(long timestamp) throws UnsupportedOperationException, IllegalArgumentException;
}
