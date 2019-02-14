package soliloquy.audio.specs;

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
public interface ISound {
	/**
	 * @return The Id of this Sound
	 */
	int id();
	
	/**
	 * @return The Id of the SoundType of this Sound
	 */
	String soundTypeId();
	
	/**
	 * Begins playing this sound
	 */
	void play();
	
	/**
	 * @return A runnable task to call the play method (which may be queued up with other tasks, to be performed simultaneously)
	 */
	Runnable playTask();
	
	/**
	 * Plays this sound, all at once; cannot be stopped, interrupted, or altered, once started. (Intended for brief sound effects.)
	 */
	void playAsClip();
	
	/**
	 * @return A runnable task to call the playAsClipTask method (which may be queued up with other tasks, to be performed simultaneously)
	 */
	Runnable playAsClipTask();
	
	/**
	 * Pauses this sound
	 */
	void pause();

	/**
	 * @return A runnable task to call the pauseTask method (which may be queued up with other tasks, to be performed simultaneously)
	 */
	Runnable pauseTask();
	
	/**
	 * @return True, if and only if this Sound is playing.
	 * <p>
	 * (If this Sound is muted or its volume is 0, but it has not been paused or stopped, it is still considered to be playing.)
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
	 * @return A runnable task to call the stopTask method (which may be queued up with other tasks, to be performed simultaneously)
	 */
	Runnable stopTask();
	
	/**
	 * Sets the Sound's volume to zero, but records the previous volume internally, so the volume can be reset when it is unmuted.
	 * <p>
	 * If a muted Sound's volume is set manually using setVolume, then the Sound is no longer considered muted. 
	 */
	void mute();

	/**
	 * @return A runnable task to call the mute method (which may be queued up with other tasks, to be performed simultaneously)
	 */
	Runnable muteTask();
	
	/**
	 * Unmutes this Sound
	 * @throws UnsupportedOperationException If and only if this Sound is not muted
	 */
	void unmute() throws UnsupportedOperationException;

	/**
	 * @return A runnable task to call the unmute method (which may be queued up with other tasks, to be performed simultaneously)
	 */
	Runnable unmuteTask();
	
	/**
	 * @return True, if and only if this Sound is muted
	 */
	boolean isMuted();
	
	/**
	 * @return True, if and only if this Sound has been stopped.
	 */
	boolean isStopped();
	
	/**
	 * @return The volume, expressed as a percentage (0-100)
	 */
	double getVolume();
	
	/**
	 * @param volume - The volume to which to set the Sound, expressed as a percentage (0.0 - 1.0)
	 * <p>
	 * If this Sound is muted, then setting volume with this call will set this Sound to no longer be muted, even if the volume is being set to zero. 
	 * @exception IllegalArgumentException If the value provided is not a double between 0.0 and 1.0.
	 */
	void setVolume(double volume) throws IllegalArgumentException;

	/**
	 * @param volume - The volume to which to set the Sound, expressed as a percentage (0.0 - 1.0)
	 * <p>
	 * If this Sound is muted, then setting volume with this call will set this Sound to no longer be muted, even if the volume is being set to zero. 
	 * @return A runnable task to call the setVolume method (which may be queued up with other tasks, to be performed simultaneously)
	 * @exception IllegalArgumentException If the value provided is not a double between 0.0 and 1.0.
	 */
	Runnable setVolumeTask(double volume) throws IllegalArgumentException;
	
	/**
	 * @return The total millisecond duration of this Sound 
	 */
	int getMillisecondLength();
	
	/**
	 * @return The current number of milliseconds elapsed in this Sound
	 */
	int getMillisecondPosition();
	
	/**
	 * @param ms - The milliseconds to set this Sound to
	 * @exception IllegalArgumentException If the milliseconds provided is below 0 or greater than the duration of the Sound
	 */
	void setMillisecondPosition(int ms) throws IllegalArgumentException;

	/**
	 * @param ms - The milliseconds to set this Sound to
	 * @return A runnable task to call the setMillisecondPosition method (which may be queued up with other tasks, to be performed simultaneously)
	 * @exception IllegalArgumentException If the milliseconds provided is below 0 or greater than the duration of the Sound
	 */
	Runnable setMillisecondPositionTask(int ms) throws IllegalArgumentException;
	
	/**
	 * @return True, if and only if the Sound is set to loop (e.g. music, atmospheric effects)
	 */
	boolean isLooping();
	
	/**
	 * @param - isLooping Sets whether the Sound is set to loop (e.g. music, atmospheric effects)
	 */
	void setIsLooping(boolean isLooping);

	/**
	 * @param - isLooping Sets whether the Sound is set to loop (e.g. music, atmospheric effects)
	 * @return A runnable task to call the mute method (which may be queued up with other tasks, to be performed simultaneously)
	 */
	Runnable setIsLoopingTask(boolean isLooping);
}
