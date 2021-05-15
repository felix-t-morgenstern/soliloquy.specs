package soliloquy.specs.gamestate.entities.timers;

/**
 * <b>ClockBasedTimerManager</b>
 * <p>
 * This class determines which {@link ClockBasedTimer}s are to fire every time
 * {@link soliloquy.specs.graphics.rendering.FrameExecutor#execute} is called, and it handles timer
 * deletion in the case of {@link OneTimeClockBasedTimer}s.
 *
 * @author felix.t.morgenstern
 * @version 0.0.1
 */
public interface ClockBasedTimerManager {
    /**
     * @param timer The Timer to register and manage
     * @throws IllegalArgumentException If and only if timer is null or invalid (e.g. a
     * {@link OneTimeClockBasedTimer} whose firingTime is in the past, or a
     * {@link RecurringClockBasedTimer} whose firingTimeModulo is greater than its
     * firingTimePeriod).
     */
    void registerTimer(ClockBasedTimer timer) throws IllegalArgumentException;

    /**
     * Fires any timers whose time has come, by registering their firing at
     * {@link soliloquy.specs.graphics.rendering.FrameExecutor#registerFrameBlockingEvent}.
     */
    void fireTimers();
}
