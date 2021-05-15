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
    long firingTime();
}
