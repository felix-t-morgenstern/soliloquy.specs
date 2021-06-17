package soliloquy.specs.gamestate.entities.timers;

import soliloquy.specs.common.shared.HasPeriodDuration;
import soliloquy.specs.common.shared.HasPeriodModuloOffset;

/**
 * <b>RecurringClockBasedTimer</b>
 * <p>
 * This class represents a timer for an event which occurs periodically according to the timestamp
 *
 * @author felix.t.morgenstern
 * @version 0.0.1
 */
public interface RecurringClockBasedTimer
        extends ClockBasedTimer, HasPeriodDuration, HasPeriodModuloOffset {
    // TODO: Ensure that ClockBasedTimerFactory takes timestamp as a parameter for creating this class
    /**
     * <i>NB: This time is updated whenever {@link #reportUnpause} is called, adding on the amount
     * of time spent paused.</i>
     * @return The last timestamp in which this timer fired; if this timer has not fired before,
     * this method returns the time when this timer was initiated
     */
    long lastFiringTimestamp();

    /**
     * @return True, if and only if this timer should fire multiple times for when multiple periods
     * have elapsed since the last firing
     */
    boolean fireMultipleTimesForMultiplePeriodsElapsed();
}
