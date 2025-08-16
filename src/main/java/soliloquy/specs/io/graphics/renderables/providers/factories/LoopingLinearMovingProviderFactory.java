package soliloquy.specs.io.graphics.renderables.providers.factories;

import soliloquy.specs.io.graphics.renderables.providers.LoopingLinearMovingProvider;

import java.util.Map;
import java.util.UUID;

/**
 * <b>LoopingLinearMovingProviderFactory</b>
 * <p>
 * A factory which creates {@link LoopingLinearMovingProvider}s
 *
 * @author felix.t.morgenstern
 * @version 0.0.1
 */
public interface LoopingLinearMovingProviderFactory {
    /**
     * @param id                  The id of this ProviderAtTime
     * @param periodDuration      The duration of the period over which this provider loops (c.f.
     *                            {@link LoopingLinearMovingProvider#periodDuration()}
     * @param periodModuloOffset  The offset of the period (c.f.
     *                            {@link LoopingLinearMovingProvider#periodModuloOffset()})
     * @param valuesWithinPeriod  The values corresponding to different ms positions within the
     *                            period (c.f.
     *                            {@link LoopingLinearMovingProvider#valuesWithinPeriod()}
     * @param pausedTimestamp     The time at which this Provider has been paused
     * @param <T>                 The type of value provided
     * @return The newly-created LoopingLinearMovingProvider
     * @throws IllegalArgumentException If and only if id is null, periodDuration is less than or
     *                                  equal to 0, periodModuloOffset is less than 0,
     *                                  periodModuloOffset is greater than or equal
     *                                  to periodDuration, valuesWithinPeriod is null,
     *                                  valuesWithinPeriod does not have a value
     *                                  corresponding to 0ms, or pausedTimestamp is non-null and
     *                                  mostRecentTimestamp is null or
     *                                  prior to pausedTimestamp
     */
    <T> LoopingLinearMovingProvider<T> make(UUID id, int periodDuration,
                                            int periodModuloOffset,
                                            Map<Integer, T> valuesWithinPeriod,
                                            Long pausedTimestamp)
            throws IllegalArgumentException;
}
