package soliloquy.specs.audio;

import soliloquy.specs.audio.entities.SoundType;
import soliloquy.specs.audio.entities.SoundsPlaying;
import soliloquy.specs.audio.factories.SoundFactory;

import java.util.Map;

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
     * @return A dictionary of available sound types
     */
    Map<String, SoundType> soundTypes();
}
