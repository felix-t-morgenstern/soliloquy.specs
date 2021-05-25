package soliloquy.specs.graphics.renderables.providers.factories;

import soliloquy.specs.common.shared.SoliloquyClass;
import soliloquy.specs.graphics.renderables.providers.ProviderAtTime;
import soliloquy.specs.graphics.renderables.providers.StaticProvider;

/**
 * <b>FloatBoxFactory</b>
 * <p>
 * Creates {@link ProviderAtTime}s which return the same value regardless of the timestamp.
 *
 * @author felix.t.morgenstern
 * @version 0.0.1
 *
 */
public interface StaticProviderFactory extends SoliloquyClass {
    /**
     * @param value The value to provide, can be null
     * @param archetype An archetype of the value type
     * @param <T> The type of value provided
     * @return A static provider, which provides the value fed into the factory, regardless of
     * timestamp.
     * @throws IllegalArgumentException If and only if archetype is null
     */
    <T> StaticProvider<T> make(T value, T archetype) throws IllegalArgumentException;
}
