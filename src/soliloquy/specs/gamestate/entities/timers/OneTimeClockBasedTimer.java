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
     * @return The time at which to fire
     */
    long firingTime();
}
