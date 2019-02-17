package soliloquy.audio.specs;

/**
 * <b>Audio</b>
 * <p>
 * This is the top-level class for the Audio component.
 * <p>
 * It contains a Collection of the Sounds currently playing, a SoundsLibrary which can create new Sounds, and the audio Settings.
 * 
 * @author felix.t.morgenstern
 * @version 0.0.1
 *
 */
public interface IAudio {
	/**
	 * @return A Collection of the Sounds currently playing
	 * <p>
	 * <i>Note that this includes Sounds which are currently paused, but not Sounds which have been stopped.</i>
	 */
	ISoundsPlaying soundsPlaying();
	
	/**
	 * @return The library of all Sounds in the Game, which can also create those Sounds
	 */
	ISoundFactory soundsLibrary();
}
