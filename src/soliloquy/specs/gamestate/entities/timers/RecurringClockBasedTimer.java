package soliloquy.specs.gamestate.entities.timers;

/**
 * <b>RecurringClockBasedTimer</b>
 * <p>
 * This class represents a timer for an event which occurs periodically according to the timestamp
 *
 * @author felix.t.morgenstern
 * @version 0.0.1
 */
public interface RecurringClockBasedTimer extends ClockBasedTimer {
    /**
     * @return The number of milliseconds between firings of this event
     */
    int firingTimePeriod();

    /**
     * This method is used to set an offset within the period for when this timer is fired. So, for
     * example, let's say that this timer fires every 1000ms. This implies that the timer will fire
     * when the global timestamp hits 1000, 2000, 3000, etc. If the firingTimeModuloOffset is 250,
     * then this timer will instead fire when the global timestamp hits 1250, 2250, 3250, etc.
     * @return The offset of the periodicity of the firings of this timer
     */
    int firingTimeModuloOffset();

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
