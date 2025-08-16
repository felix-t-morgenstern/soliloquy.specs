package soliloquy.specs.gamestate.factories;

import soliloquy.specs.common.entities.Action;
import soliloquy.specs.common.shared.HasPeriodModuloOffset;
import soliloquy.specs.gamestate.entities.timers.OneTimeClockBasedTimer;
import soliloquy.specs.gamestate.entities.timers.RecurringClockBasedTimer;

public interface ClockBasedTimerFactory {
    /**
     * @param id              The Id of this timer
     * @param firingTimestamp The time at which this Timer will fire
     * @param firingAction    The Action which will fire when this Timer is triggered
     * @param pausedTimestamp The timestamp at which this Timer has been paused; null if it has not been paused. (This parameter largely exists for ClockBasedTimers which may need to be reloaded from a save state.)
     * @return The newly-created Timer
     * @throws IllegalArgumentException If and only if id is empty or null, pausedTimestamp is
     *                                  greater than or equal to firingTimestamp, or firingAction is
     *                                  null
     */
    OneTimeClockBasedTimer make(String id, long firingTimestamp, Action<Long> firingAction,
                                Long pausedTimestamp)
            throws IllegalArgumentException;

    /**
     * @param id                                         The Id of this timer
     * @param periodDuration                             The time in-between Timer firings
     * @param periodModuloOffset                         The offset, in ms, of the period start time
     *                                                   (c.f. {@link HasPeriodModuloOffset})
     * @param firingAction                               The Action which will fire when this Timer
     *                                                   is triggered
     * @param fireMultipleTimesForMultiplePeriodsElapsed Whether this Timer fires multiple times
     *                                                   when more than one period has elapsed
     *                                                   since the last firing time
     * @param pausedTimestamp                            The timestamp at which this Timer has been
     *                                                   paused; null if it has not
     *                                                   been paused. (This parameter largely exists
     *                                                   for ClockBasedTimers
     *                                                   which may need to be reloaded from a save
     *                                                   state.)
     * @param lastFiringTimestamp                        The time at which this Timer has fired most
     *                                                   recently
     * @return The newly-created Timer
     * @throws IllegalArgumentException If and only if id is empty or null, periodDuration is less
     *                                  than or equal to 0, periodModuloOffset is less than or equal
     *                                  to 0 or greater than or equal to periodDuration, fireAction
     *                                  is null
     */
    RecurringClockBasedTimer make(String id, int periodDuration, int periodModuloOffset,
                                  Action<Long> firingAction,
                                  boolean fireMultipleTimesForMultiplePeriodsElapsed,
                                  Long pausedTimestamp, long lastFiringTimestamp)
            throws IllegalArgumentException;
}
