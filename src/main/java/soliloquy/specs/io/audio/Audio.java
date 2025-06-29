package soliloquy.specs.io.audio;

import soliloquy.specs.io.audio.entities.SoundType;
import soliloquy.specs.io.audio.entities.SoundsPlaying;
import soliloquy.specs.io.audio.factories.SoundFactory;

import java.util.Set;

/**
 * <b>Audio</b>
 * <p>
 * This is the top-level class for the Audio component.
 * <p>
 * It contains a List of the Sounds currently playing, a SoundsLibrary which can create new
 * Sounds, and the audio Settings.
 *
 * @author felix.t.morgenstern
 * @version 0.0.1
 */
public interface Audio {
    /**
     * @return A List of the Sounds currently playing
     *         <p>
     *         <i>Note that this includes Sounds which are currently paused, but not Sounds which
     *         have been
     *         stopped.</i>
     */
    SoundsPlaying soundsPlaying();

    /**
     * @return The library of all Sounds in the Game, which can also create those Sounds
     */
    SoundFactory soundFactory();

    /**
     * @param id The id of the SoundType to return
     * @return The corresponding SoundType
     * @throws IllegalArgumentException If and only if id is null or empty, or does not correspond
     *                                  to a registered SoundType
     */
    SoundType getSoundType(String id) throws IllegalArgumentException;

    /**
     * @return A set of all SoundTypes
     */
    Set<SoundType> soundTypes();
}
