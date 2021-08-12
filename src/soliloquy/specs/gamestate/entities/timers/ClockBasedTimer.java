package soliloquy.specs.gamestate.entities.timers;

import soliloquy.specs.common.entities.Action;
import soliloquy.specs.common.shared.PausableAtTime;
import soliloquy.specs.graphics.shared.HasMostRecentTimestamp;

// TODO: Draft class summary
public interface ClockBasedTimer extends PausableAtTime, HasMostRecentTimestamp {
    /**
     * @return The Id of the {@link Action} which runs when this ClockBasedTimer is fired
     */
    String actionId();

    /**
     * @param timestamp The timestamp at which to fire this Timer
     * @throws UnsupportedOperationException If and only if timestamp is greater than or equal to
     * the current paused timestamp
     * @throws IllegalArgumentException If and only if timestamp is before most recent timestamp
     * provided to this class
     */
    void fire(long timestamp) throws UnsupportedOperationException, IllegalArgumentException;
}
