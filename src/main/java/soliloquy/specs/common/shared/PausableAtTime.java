package soliloquy.specs.common.shared;

/**
 * <b>PausableAtTime</b>
 * <p>
 * This class can be paused or unpaused at varying timestamps. This class cannot be paused while
 * already paused, unpaused while already unpaused, or paused or unpaused before it has already
 * been paused or unpaused. Lastly, it exposes the pausedTimestamp, to permit pauses to be
 * persisted.
 *
 * @author felix.t.morgenstern
 * @version 0.0.1
 */
public interface PausableAtTime extends SoliloquyClass {
    /**
     * @param timestamp The time at which the pause has begun
     * @throws IllegalArgumentException      If and only if timestamp is before the most recent
     *                                       timestamp at which a value was requested, a pause was
     *                                       reported, or an unpause was reported
     * @throws UnsupportedOperationException If and only if this object was already paused
     */
    void reportPause(long timestamp) throws IllegalArgumentException, UnsupportedOperationException;

    /**
     * @param timestamp The time at which the pause has ended
     * @throws IllegalArgumentException      If and only if timestamp is before the most recent
     *                                       timestamp at which a value was requested, a pause was
     *                                       reported, or an unpause was reported
     * @throws UnsupportedOperationException If and only if this object was already paused
     */
    void reportUnpause(long timestamp)
            throws IllegalArgumentException, UnsupportedOperationException;

    /**
     * <i>NB: This method exists to support PausableAtTime classes which need to be generated when
     * loading a savefile with their paused times intact.</i>
     *
     * @return If null, this object is not paused; else, he timestamp at which this object has been
     * paused
     */
    Long pausedTimestamp();
}
