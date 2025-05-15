package soliloquy.specs.graphics.renderables.providers.factories;

import soliloquy.specs.graphics.renderables.providers.FiniteSinusoidMovingProvider;

import java.util.List;
import java.util.Map;
import java.util.UUID;

/**
 * <b>FiniteSinusoidMovingProviderFactory</b>
 * <p>
 * A factory which creates {@link FiniteSinusoidMovingProvider}s
 *
 * @author felix.t.morgenstern
 * @version 0.0.1
 */
public interface FiniteSinusoidMovingProviderFactory {
    /**
     * @param uuid                  The uuid of this ProviderAtTime
     * @param valuesAtTimestamps    The valuesAtTimestamps to provide (c.f. {@link
     *                              FiniteSinusoidMovingProvider#valuesAtTimestampsRepresentation})
     * @param transitionSharpnesses The sharpness of each transition (c.f. {@link
     *                              FiniteSinusoidMovingProvider#transitionSharpnesses}
     * @param pausedTimestamp       The time at which this Provider was paused; can be null,
     *                              implying the Provider is not paused
     * @param mostRecentTimestamp   The most recent timestamp for which a value was provided; can be
     *                              null, implying no value provided
     * @param <T>                   The type this Provider will provide
     * @return The newly-created FiniteSinusoidMovingProviderFactory
     * @throws IllegalArgumentException If and only if uuid is null; or valuesAtTimestamps is null,
     *                                  or contains fewer than two key-value pairs; or if
     *                                  transitionSharpnesses is null, or does not contain one fewer
     *                                  entry than valuesAtTimestamps
     */
    <T> FiniteSinusoidMovingProvider<T> make(UUID uuid, Map<Long, T> valuesAtTimestamps,
                                             List<Float> transitionSharpnesses,
                                             Long pausedTimestamp, Long mostRecentTimestamp)
            throws IllegalArgumentException;
}
