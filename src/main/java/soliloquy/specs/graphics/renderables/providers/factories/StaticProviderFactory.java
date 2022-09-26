package soliloquy.specs.graphics.renderables.providers.factories;

import soliloquy.specs.common.shared.SoliloquyClass;
import soliloquy.specs.graphics.renderables.providers.ProviderAtTime;
import soliloquy.specs.graphics.renderables.providers.StaticProvider;

import java.util.UUID;

/**
 * <b>FloatBoxFactory</b>
 * <p>
 * Creates {@link ProviderAtTime}s which return the same value regardless of the timestamp.
 *
 * @author felix.t.morgenstern
 * @version 0.0.1
 */
public interface StaticProviderFactory extends SoliloquyClass {
    /**
     * @param id                  The id of this ProviderAtTime
     * @param value               The value to provide, can be null
     * @param archetype           An archetype of the value type
     * @param mostRecentTimestamp The most recent timestamp for which a value was provided; can be
     *                            null, implying no value provided
     * @param <T>                 The type of value provided
     * @return A static provider, which provides the value fed into the factory, regardless of
     *         timestamp.
     * @throws IllegalArgumentException If and only if id or archetype is null
     */
    <T> StaticProvider<T> make(UUID id, T value, T archetype, Long mostRecentTimestamp)
            throws IllegalArgumentException;
}
