package soliloquy.specs.io.graphics.renderables.providers.factories;

import soliloquy.specs.io.graphics.renderables.providers.ProviderAtTime;
import soliloquy.specs.io.graphics.renderables.providers.StaticProvider;

import java.util.UUID;

/**
 * <b>FloatBoxFactory</b>
 * <p>
 * Creates {@link ProviderAtTime}s which return the same value regardless of the timestamp.
 *
 * @author felix.t.morgenstern
 * @version 0.0.1
 */
public interface StaticProviderFactory {
    /**
     * @param id                  The id of this ProviderAtTime
     * @param value               The value to provide, can be null
     * @param mostRecentTimestamp The most recent timestamp for which a value was provided; can be
     *                            null, implying no value provided
     * @param <T>                 The type of value provided
     * @return A static provider, which provides the value fed into the factory, regardless of
     *         timestamp.
     * @throws IllegalArgumentException If and only if id is null
     */
    <T> StaticProvider<T> make(UUID id, T value, Long mostRecentTimestamp)
            throws IllegalArgumentException;
}
