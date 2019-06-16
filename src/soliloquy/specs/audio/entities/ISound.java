package soliloquy.specs.audio.entities;

import soliloquy.specs.common.shared.IHasUuid;

// TODO: Ensure that implementations pass ILogger into any and all generated Runnables

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
 *
 */
public interface ISound extends IHasUuid {
	/**
	 * @return The Id of the SoundType of this Sound
	 */
	String soundTypeId();
	
	/**
	 * Begins playing this sound
	 * @exception UnsupportedOperationException If this Sound has already been stopped
	 */
	void play() throws UnsupportedOperationException;
	
	/**
	 * @return A runnable task to call the play method (which may be queued up with other tasks, to
	 * be performed simultaneously)
	 */
	Runnable playTask();
	
	/**
	 * Pauses this sound
	 * @exception UnsupportedOperationException If this Sound has already been stopped
	 */
	void pause() throws UnsupportedOperationException;

	/**
	 * @return A runnable task to call the pauseTask method (which may be queued up with other
	 * tasks, to be performed simultaneously)
	 */
	Runnable pauseTask();
	
	/**
	 * @return True, if and only if this Sound is paused.
	 * <p>
	 * (If this Sound is muted or its volume is 0, but it has not been paused or stopped, it is not
	 * considered to be paused.)
	 */
	boolean isPaused();
	
	/**
	 * @return True, if and only if this Sound is playing.
	 * <p>
	 * (If this Sound is muted or its volume is 0, but it has not been paused or stopped, it is
	 * still considered to be playing.)
	 */
	boolean isPlaying();
	
	/**
	 * Stops this sound. When it is Stopped, it is removed from SoundsPlaying.
	 * <p>
	 * <i>When a Sound is stopped, all associated resources are disposed of.</i>
	 * @exception UnsupportedOperationException If this Sound has already been stopped
	 */
	void stop() throws UnsupportedOperationException;

	/**
	 * @return A runnable task to call the stopTask method (which may be queued up with other
	 * tasks, to be performed simultaneously)
	 */
	Runnable stopTask();
	
	/**
	 * Sets the Sound's volume to zero, but records the previous volume internally, so the volume
	 * can be reset when it is unmuted.
	 * <p>
	 * If a muted Sound's volume is set manually using setVolume, then the Sound is no longer
	 * considered muted.
	 * @exception UnsupportedOperationException If this Sound has already been stopped
	 */
	void mute() throws UnsupportedOperationException;

	/**
	 * @return A runnable task to call the mute method (which may be queued up with other tasks, to
	 * be performed simultaneously)
	 */
	Runnable muteTask();
	
	/**
	 * Unmutes this Sound
	 * @exception UnsupportedOperationException If this Sound has already been stopped
	 */
	void unmute() throws UnsupportedOperationException;

	/**
	 * @return A runnable task to call the unmute method (which may be queued up with other tasks,
	 * to be performed simultaneously)
	 */
	Runnable unmuteTask();
	
	/**
	 * @return True, if and only if this Sound is muted.
	 * @exception UnsupportedOperationException If this Sound has already been stopped
	 */
	boolean isMuted() throws UnsupportedOperationException;
	
	/**
	 * @return True, if and only if this Sound has been stopped.
	 */
	boolean isStopped();
	
	/**
	 * @return The volume, expressed as a percentage (0-100)
	 * @exception UnsupportedOperationException If this Sound has already been stopped
	 */
	double getVolume() throws UnsupportedOperationException;
	
	/**
	 * @param volume - The volume to which to set the Sound, expressed as a percentage (0.0 - 1.0)
	 * <p>
	 * If this Sound is muted, then setting volume with this call will set this Sound to no longer
	 * be muted, even if the volume is being set to zero. 
	 * @exception IllegalArgumentException If the value provided is not a double between 0.0 and
	 * 1.0.
	 * @exception UnsupportedOperationException If this Sound has already been stopped
	 */
	void setVolume(double volume) throws IllegalArgumentException, UnsupportedOperationException;

	/**
	 * @param volume - The volume to which to set the Sound, expressed as a percentage (0.0 - 1.0)
	 * <p>
	 * If this Sound is muted, then setting volume with this call will set this Sound to no longer
	 * be muted, even if the volume is being set to zero. 
	 * @return A runnable task to call the setVolume method (which may be queued up with other
	 * tasks, to be performed simultaneously)
	 * @exception IllegalArgumentException If the value provided is not a double between 0.0 and
	 * 1.0.
	 */
	Runnable setVolumeTask(double volume) throws IllegalArgumentException;
	
	/**
	 * (NB: If the media has not yet been readied, this method repeatedly takes a miniscule break
	 * and checks again, until the media is ready, and can report its duration.)
	 * @return The total millisecond duration of this Sound 
	 * @throws InterruptedException If and only if this call is not able to defer its execution
	 * until the media is prepared. (This exception is unlikely to ever be thrown.)
	 */
	int getMillisecondLength() throws InterruptedException;
	
	/**
	 * @return The current number of milliseconds elapsed in this Sound.
	 * @throws InterruptedException If and only if this call is not able to defer its execution
	 * until the media is prepared. (This exception is unlikely to ever be thrown.)
	 * @exception UnsupportedOperationException If this Sound has already been stopped
	 */
	int getMillisecondPosition() throws InterruptedException, UnsupportedOperationException;
	
	/**
	 * @param ms - The milliseconds to set this Sound to
	 * @exception IllegalArgumentException If the milliseconds provided is below 0 or greater than
	 * the duration of the Sound
	 * @exception UnsupportedOperationException If this Sound has already been stopped
	 */
	void setMillisecondPosition(int ms) throws IllegalArgumentException, UnsupportedOperationException;

	/**
	 * @param ms - The milliseconds to set this Sound to
	 * @return A runnable task to call the setMillisecondPosition method (which may be queued up
	 * with other tasks, to be performed simultaneously)
	 * @exception IllegalArgumentException If the milliseconds provided is below 0 or greater than
	 * the duration of the Sound
	 */
	Runnable setMillisecondPositionTask(int ms) throws IllegalArgumentException;
	
	/**
	 * @return True, if and only if the Sound is set to loop (e.g. music, atmospheric effects)
	 * @exception UnsupportedOperationException If this Sound has already been stopped
	 */
	boolean getIsLooping() throws UnsupportedOperationException;
	
	/**
	 * @param - isLooping Sets whether the Sound is set to loop (e.g. music, atmospheric effects)
	 * @exception UnsupportedOperationException If this Sound has already been stopped
	 */
	void setIsLooping(boolean isLooping) throws UnsupportedOperationException;

	/**
	 * @param - isLooping Sets whether the Sound is set to loop (e.g. music, atmospheric effects)
	 * @return A runnable task to call the mute method (which may be queued up with other tasks, to
	 * be performed simultaneously)
	 */
	Runnable setIsLoopingTask(boolean isLooping);
}
