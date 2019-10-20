package soliloquy.specs.audio.entities;

import soliloquy.specs.common.infrastructure.Collection;
import soliloquy.specs.common.valueobjects.EntityUuid;
import soliloquy.specs.common.shared.SoliloquyClass;

/**
 * <b>SoundsPlaying</b>
 * <p>
 * A set of all Sounds playing. (Sounds are identified by their EntityUuids.)
 * <p>
 * <i>Note that this includes Sounds which are currently paused or muted, but not Sounds which have
 * been stopped.</i>
 * 
 * @author felix.t.morgenstern
 * @version 0.0.1
 *
 */
public interface SoundsPlaying extends SoliloquyClass {
	/**
	 * @return A collection of all sounds currently being played.
	 */
	Collection<Sound> allSoundsPlaying();
	
	/**
	 * @param soundId - The id to check for
	 * @return True, if and only if the sound specified is currently playing
	 * @throws IllegalArgumentException if and only if soundId is null
	 */
	boolean isPlayingSound(EntityUuid soundId) throws IllegalArgumentException;
	
	/**
	 * @param soundId - The id of the Sound to retrieve
	 * @return The Sound corresponding to soundId, if a Sound of that id is currently playing;
	 * else, null
	 * @throws IllegalArgumentException If and only if soundId is null
	 */
	Sound getSound(EntityUuid soundId) throws IllegalArgumentException;
	
	/**
	 * @param sound - The Sound to register as currently playing
	 * @throws IllegalArgumentException If and only if sound is null, or has a null id
	 */
	void registerSound(Sound sound) throws IllegalArgumentException;
	
	/**
	 * <i>This method is only intended to be called by Sound.stop(), and when used inappropriately,
	 * may end up in memory leaks</i>
	 * <p>
	 * (This method does nothing if soundId corresponds to a nonexistent Sound, in order to avoid
	 * throwing exceptions amidst race conditions.)
	 * @param sound - The Sound to remove
	 * @throws IllegalArgumentException If and only if soundId is null.
	 */
	void removeSound(Sound sound) throws IllegalArgumentException;
}
