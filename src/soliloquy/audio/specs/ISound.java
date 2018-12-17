package soliloquy.audio.specs;

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
	 * Plays this sound
	 */
	void play();
	
	/**
	 * Pauses this sound
	 */
	void pause();
	
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
	 * Sets the Sound's volume to zero, but records the previous volume internally, so the volume can be reset when it is unmuted.
	 * <p>
	 * If a muted Sound's volume is set manually using setVolume, then the Sound is no longer considered muted. 
	 */
	void mute();
	
	/**
	 * Unmutes this Sound
	 * @throws UnsupportedOperationException If and only if this Sound is not muted
	 */
	void unmute() throws UnsupportedOperationException;
	
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
	int getVolume();
	
	/**
	 * @param volume - The volume to which to set the Sound, expressed as a percentage (0-100)
	 * <p>
	 * If this Sound is muted, then setting volume with this call will set this Sound to no longer be muted, even if the volume is being set to zero. 
	 * @exception IllegalArgumentException If the value provided is not an integer between 0 and 100
	 */
	void setVolume(int volume) throws IllegalArgumentException;
	
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
	 * @return True, if and only if the Sound is set to loop (e.g. music, atmospheric effects)
	 */
	boolean isLooping();
	
	/**
	 * @param - isLooping Sets whether the Sound is set to loop (e.g. music, atmospheric effects)
	 */
	void setIsLooping(boolean isLooping);
}
