package soliloquy.specs.audio.entities;

import soliloquy.specs.common.shared.HasUuid;

/**
 * <b>Sound</b>
 * <p>
 * Has a sound type Id.
 * <p>
 * Can be played, paused, and stopped.
 * <p>
 * Can have its volume or current millisecond set.
 * <p>
 * Can loop.
 *
 * @author felix.t.morgenstern
 * @version 0.0.1
 */
public interface Sound extends HasUuid {
    /**
     * @return The {@link SoundType} of this Sound
     */
    SoundType soundType();

    /**
     * Begins playing this sound
     *
     * @throws UnsupportedOperationException If this Sound has already been stopped
     */
    void play() throws UnsupportedOperationException;

    /**
     * Pauses this sound
     *
     * @throws UnsupportedOperationException If this Sound has already been stopped
     */
    void pause() throws UnsupportedOperationException;

    /**
     * @return True, if and only if this Sound is paused.
     *         <p>
     *         (If this Sound is muted or its volume is 0, but it has not been paused or
     *         stopped, it
     *         is not
     *         considered to be paused.)
     */
    boolean isPaused();

    /**
     * @return True, if and only if this Sound is playing.
     *         <p>
     *         (If this Sound is muted or its volume is 0, but it has not been paused or
     *         stopped, it
     *         is
     *         still considered to be playing.)
     */
    boolean isPlaying();

    /**
     * Stops this sound. When it is Stopped, it is removed from SoundsPlaying.
     * <p>
     * <i>When a Sound is stopped, all associated resources are disposed of.</i>
     *
     * @throws UnsupportedOperationException If this Sound has already been stopped
     */
    void stop() throws UnsupportedOperationException;

    /**
     * Sets the Sound's volume to zero, but records the previous volume internally, so the volume
     * can be reset when it is unmuted.
     * <p>
     * If a muted Sound's volume is set manually using setVolume, then the Sound is no longer
     * considered muted.
     *
     * @throws UnsupportedOperationException If this Sound has already been stopped
     */
    void mute() throws UnsupportedOperationException;

    /**
     * Unmutes this Sound
     *
     * @throws UnsupportedOperationException If this Sound has already been stopped
     */
    void unmute() throws UnsupportedOperationException;

    /**
     * @return True, if and only if this Sound is muted.
     * @throws UnsupportedOperationException If this Sound has already been stopped
     */
    boolean isMuted() throws UnsupportedOperationException;

    /**
     * @return True, if and only if this Sound has been stopped.
     */
    boolean isStopped();

    /**
     * @return The volume, expressed as a percentage (0-100)
     * @throws UnsupportedOperationException If this Sound has already been stopped
     */
    double getVolume() throws UnsupportedOperationException;

    /**
     * @param volume The volume to which to set the Sound, expressed as a percentage (0.0 1.0)
     *               <p>
     *               If this Sound is muted, then setting volume with this call will set this Sound
     *               to no longer
     *               be muted, even if the volume is being set to zero.
     * @throws IllegalArgumentException      If the value provided is not a double between 0.0 and
     *                                       1.0.
     * @throws UnsupportedOperationException If this Sound has already been stopped
     */
    void setVolume(double volume) throws IllegalArgumentException, UnsupportedOperationException;

    /**
     * (NB: If the media has not yet been readied, this method repeatedly takes a miniscule break
     * and checks again, until the media is ready, and can report its duration.)
     *
     * @return The total millisecond duration of this Sound
     * @throws UnsupportedOperationException If and only if this call is not able to defer its
     *                                       execution until the media is prepared. (This exception
     *                                       is unlikely to ever be thrown.)
     */
    int getMillisecondLength() throws UnsupportedOperationException;

    /**
     * @return The current number of milliseconds elapsed in this Sound.
     * @throws UnsupportedOperationException If this Sound has already been stopped, or if it
     *                                       has not been initialized
     */
    int getMillisecondPosition() throws UnsupportedOperationException;

    /**
     * @param ms The milliseconds to set this Sound to
     * @throws IllegalArgumentException      If the milliseconds provided is below 0 or greater than
     *                                       the duration of the Sound
     * @throws UnsupportedOperationException If this Sound has already been stopped
     */
    void setMillisecondPosition(int ms)
            throws IllegalArgumentException, UnsupportedOperationException;

    /**
     * @return True, if and only if the Sound is set to loop (e.g. music, atmospheric effects)
     * @throws UnsupportedOperationException If this Sound has already been stopped
     */
    boolean getIsLooping() throws UnsupportedOperationException;

    /**
     * @param isLooping Sets whether the Sound is set to loop (e.g. music, atmospheric effects)
     * @throws UnsupportedOperationException If this Sound has already been stopped
     */
    void setIsLooping(boolean isLooping) throws UnsupportedOperationException;

    /**
     * <i>NB: This method exists to handle Sound persistence</i>
     * @return The ms position at which the looping Sound stops and then restarts
     * @throws UnsupportedOperationException If and only if the Sound is not looping
     */
    int getLoopingStopMs() throws UnsupportedOperationException;

    /**
     * (NB: If this Sound is not set to looping, this function can still be called; the looping
     * stop millisecond position will still be set, but will be ignored until looping is turned
     * on.)
     *
     * @param msPosition The millisecond position at which the Sound stops and restarts, if it is
     *                   looping; if null, then this implies that if this Sound is looping, it will
     *                   restart the track at its very end
     * @throws IllegalArgumentException If and only if msPosition is less than or equal to 0,
     *                                  greater than the length of the Sound, or before the looping
     *                                  restart msPosition
     */
    void setLoopingStopMs(Integer msPosition)
            throws IllegalArgumentException;

    /**
     * <i>NB: This method exists to handle Sound persistence</i>
     * @return The ms position at which the Sound restarts when it reaches the end of a loop
     * @throws UnsupportedOperationException If and only if the Sound is not looping
     */
    int getLoopingRestartMs() throws UnsupportedOperationException;

    /**
     * (NB: If this Sound is not set to looping, this function can still be called; the looping
     * stop millisecond position will still be set, but will be ignored until looping is turned
     * on.)
     *
     * @param msPosition The millisecond position at which the Sound restarts, after it stops, if
     *                   it is looping
     * @throws IllegalArgumentException If and only if msPosition is less than or equal to 0,
     *                                  greater than the length of the Sound, or after the looping
     *                                  stop msPosition
     */
    void setLoopingRestartMs(int msPosition)
            throws IllegalArgumentException;
}
