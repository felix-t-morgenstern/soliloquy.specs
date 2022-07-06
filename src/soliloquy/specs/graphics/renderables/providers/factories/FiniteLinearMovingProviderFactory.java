package soliloquy.specs.graphics.renderables.providers.factories;

import soliloquy.specs.common.shared.SoliloquyClass;
import soliloquy.specs.graphics.renderables.providers.FiniteLinearMovingProvider;

import java.util.Map;
import java.util.UUID;

/**
 * <b>FiniteLinearMovingProviderFactory</b>
 * <p>
 * A factory which creates {@link FiniteLinearMovingProvider}s
 *
 * @author felix.t.morgenstern
 * @version 0.0.1
 *
 */
public interface FiniteLinearMovingProviderFactory extends SoliloquyClass {
    /**
     * @param uuid The uuid of this ProviderAtTime
     * @param valuesAtTimestamps The valuesAtTimestamps to provide (c.f.
     * {@link FiniteLinearMovingProvider#valuesAtTimestampsRepresentation})
     * @param pausedTimestamp The time at which this Provider was paused; can be null, implying the
     *                        Provider is not paused
     * @param mostRecentTimestamp The most recent timestamp for which a value was provided; can be
     *                            null, implying no value provided
     * @param <T> The type this Provider will provide
     * @return The newly-created FiniteLinearMovingProvider
     * @throws IllegalArgumentException If and only if uuid is null; or valuesAtTimestamps is null,
     * or contains fewer than two key-value pairs
     */
    <T> FiniteLinearMovingProvider<T> make(UUID uuid, Map<Long, T> valuesAtTimestamps,
                                           Long pausedTimestamp, Long mostRecentTimestamp)
            throws IllegalArgumentException;
}
