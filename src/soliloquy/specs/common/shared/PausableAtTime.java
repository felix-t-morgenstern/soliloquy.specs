package soliloquy.specs.common.shared;

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
}
