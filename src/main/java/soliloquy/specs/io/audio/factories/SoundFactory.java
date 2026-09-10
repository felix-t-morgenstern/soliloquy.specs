package soliloquy.specs.io.audio.factories;

import soliloquy.specs.io.audio.entities.Sound;
import soliloquy.specs.io.graphics.renderables.providers.ProviderAtTime;

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
     * @param soundTypeId    The id of the type of Sound to make
     * @param volumeProvider The initial volume provider
     * @return The Sound made
     * @throws IllegalArgumentException If and only if soundTypeId is null or empty, or there exists
     *                                  no Sound with the specified soundTypeId, or volumeProvider
     *                                  is null
     */
    Sound make(String soundTypeId, ProviderAtTime<Float> volumeProvider)
            throws IllegalArgumentException;
}
