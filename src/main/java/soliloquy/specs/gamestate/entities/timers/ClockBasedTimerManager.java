package soliloquy.specs.gamestate.entities.timers;

import java.util.List;

/**
 * <b>ClockBasedTimerManager</b>
 * <p>
 * This class determines which {@link ClockBasedTimer}s are to fire every time
 * {@link soliloquy.specs.io.graphics.rendering.FrameExecutor#execute} is called, and it handles timer
 * deletion in the case of {@link OneTimeClockBasedTimer}s.
 * <p>
 * <i>NB: All ClockBasedTimers are frame-blocking events, whose firings are passed to
 * {@link soliloquy.specs.io.graphics.rendering.FrameExecutor#registerFrameBlockingEvent}; c.f.
 * FrameExecutor.execute, referenced above. If you want to have a ClockBasedTimer trigger a
 * game event, have the triggered ClockBasedTimer generate (and register) a {@link Runnable} with
 * {@link soliloquy.specs.gamestate.entities.gameevents.GameEventFiring#registerEvent}.</i>
 *
 * @author felix.t.morgenstern
 * @version 0.0.1
 */
public interface ClockBasedTimerManager {
    /**
     * @param oneTimeClockBasedTimer The OneTimeClockBasedTimer to register and manage
     * @throws IllegalArgumentException If and only if oneTimeClockBasedTimer is null. <i>(NB: If
     *                                  its firing time is in the past, this is still valid, since
     *                                  there may be a race condition
     *                                  between its intended firing time and when it is registered
     *                                  by this method.)</i>
     */
    void registerOneTimeTimer(OneTimeClockBasedTimer oneTimeClockBasedTimer)
            throws IllegalArgumentException;

    /**
     * @param recurringClockBasedTimer The RecurringClockBasedTimer to register and manage
     * @throws IllegalArgumentException If and only if recurringClockBasedTimer is null or invalid,
     *                                  i.e. if its firingTimeModuloOffset is greater than or equal
     *                                  to its firingTimePeriod
     */
    void registerRecurringTimer(RecurringClockBasedTimer recurringClockBasedTimer)
            throws IllegalArgumentException;

    /**
     * @param id The Id of the OneTimeClockBasedTimer to deregister
     * @throws IllegalArgumentException If and only if id is null or empty
     */
    void deregisterOneTimeTimer(String id) throws IllegalArgumentException;

    /**
     * @param id The Id of the RecurringClockBasedTimer to deregister
     * @throws IllegalArgumentException If and only if id is null or empty
     */
    void deregisterRecurringTimer(String id) throws IllegalArgumentException;

    /**
     * Clears all clock-based timers
     */
    void clear();

    /**
     * Selects all Timers whose time has come be fired, and registers them to be fired at
     * {@link soliloquy.specs.io.graphics.rendering.FrameExecutor#registerFrameBlockingEvent}.
     *
     * @param timestamp The timestamp at which to determine whether the Timers should fire
     * @throws IllegalArgumentException If and only if this method has already been called at or
     *                                  after timestamp
     */
    void fireTimers(long timestamp) throws IllegalArgumentException;

    /**
     * @return A representation of the currently active OneTimeClockBasedTimers
     */
    List<OneTimeClockBasedTimer> oneTimeTimersRepresentation();

    /**
     * @return A representation of the currently active RecurringClockBasedTimers
     */
    List<RecurringClockBasedTimer> recurringTimersRepresentation();
}
