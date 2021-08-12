package soliloquy.specs.common.shared;

import soliloquy.specs.graphics.shared.HasMostRecentTimestamp;

// TODO: Draft class summary
public interface PausableAtTime extends SoliloquyClass {
    /**
     * @param timestamp The time at which the pause has begun
     * @throws IllegalArgumentException If and only if timestamp is before the most recent
     * timestamp at which a value was requested, or a pause or unpause was reported; or, if this
     * object was already paused
     */
    void reportPause(long timestamp) throws IllegalArgumentException;

    /**
     * @param timestamp The time at which the pause has ended
     * @throws IllegalArgumentException If and only if timestamp is before the most recent
     * timestamp at which a value was requested, or a pause or unpause was reported; or, if this
     * object was already paused
     */
    void reportUnpause(long timestamp) throws IllegalArgumentException;

    /**
     * <i>NB: This method exists to support PausableAtTime classes which need to be generated when
     * loading a savefile with their paused times intact.</i>
     * @return If null, this object is not paused; else, he timestamp at which this object has been
     * paused
     */
    Long pausedTimestamp();
}
