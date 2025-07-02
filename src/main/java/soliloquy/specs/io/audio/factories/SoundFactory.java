package soliloquy.specs.io.audio.factories;

import soliloquy.specs.io.audio.entities.Sound;

import java.util.UUID;

/**
 * <b>SoundFactory</b>
 * <p>
 * Makes a Sound of a given type.
 *
 * @author felix.t.morgenstern
 * @version 0.0.1
 */
public interface SoundFactory {
    /**
     * @param soundTypeId The id of the type of Sound to make
     * @return The Sound made
     * @throws IllegalArgumentException If and only if there exists no Sound with the specified
     *                                  soundTypeId
     */
    Sound make(String soundTypeId) throws IllegalArgumentException;
}
