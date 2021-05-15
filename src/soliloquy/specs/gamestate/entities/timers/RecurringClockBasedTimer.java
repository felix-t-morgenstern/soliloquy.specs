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
     * @return The modulo value used to determine the offset of the periodicity of the firings of
     * this event
     */
    int firingTimeModulo();
}
