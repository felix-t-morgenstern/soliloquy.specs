package soliloquy.specs.io.audio.factories;

import soliloquy.specs.io.audio.entities.Sound;

import java.util.UUID;

/**
 * <b>SoundFactory</b>
 * <p>
 * Can create a Sound of a given type. Intended use is to contain an internal reference to a
 * {@link soliloquy.specs.common.infrastructure.Registry} of
 * {@link soliloquy.specs.io.audio.entities.SoundType}s.
 *
 * @author felix.t.morgenstern
 * @version 0.0.1
 */
public interface SoundFactory {
    /**
     * @param soundTypeId The Id of the type of Sound to make
     * @return The Sound made, with a randomly-generated UUID
     * @throws IllegalArgumentException If and only if there exists no Sound with the specified
     *                                  soundTypeId
     */
    Sound make(String soundTypeId) throws IllegalArgumentException;

    /**
     * @param soundTypeId The Id of the type of Sound to make
     * @param uuid        The UUID of the Sound to make
     * @return The Sound made, with the specified UUID
     * @throws IllegalArgumentException If and only if there exists no Sound with the specified
     *                                  soundTypeId
     */
    Sound make(String soundTypeId, UUID uuid) throws IllegalArgumentException;
}
