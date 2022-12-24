package soliloquy.specs.gamestate.entities.timers;

/**
 * <b>OneTimeClockBasedTimer</b>
 * <p>
 * This class represents a timer for an event which occurs once at a specific timestamp.
 *
 * @author felix.t.morgenstern
 * @version 0.0.1
 */
public interface OneTimeClockBasedTimer extends ClockBasedTimer {
    /**
     * <i>NB: This time is updated whenever {@link #reportUnpause} is called, adding on the amount
     * of time spent paused.</i>
     *
     * @return The time at which to fire
     */
    long firingTime();

    /**
     * @param timestamp The time at which the pause has begun
     * @throws IllegalArgumentException      If and only if timestamp is before the most recent
     *                                       timestamp at which a value was requested, a pause was
     *                                       reported, or an unpause was reported
     * @throws UnsupportedOperationException If and only if this timer was already paused, or it
     *                                       has already fired
     */
    void reportPause(long timestamp) throws IllegalArgumentException, UnsupportedOperationException;

    /**
     * @param timestamp The time at which the pause has ended
     * @throws IllegalArgumentException      If and only if timestamp is before the most recent
     *                                       timestamp at which a value was requested, a pause was
     *                                       reported, or an unpause was reported
     * @throws UnsupportedOperationException If and only if this timer was not already paused, or
     *                                       it has already fired
     */
    void reportUnpause(long timestamp)
            throws IllegalArgumentException, UnsupportedOperationException;
}
