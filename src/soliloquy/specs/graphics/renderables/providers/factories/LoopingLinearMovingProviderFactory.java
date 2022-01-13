package soliloquy.specs.graphics.renderables.providers.factories;

import soliloquy.specs.common.shared.SoliloquyClass;
import soliloquy.specs.common.valueobjects.EntityUuid;
import soliloquy.specs.graphics.renderables.providers.LoopingLinearMovingProvider;

import java.util.Map;

/**
 * <b>LoopingLinearMovingProviderFactory</b>
 * <p>
 * A factory which creates {@link LoopingLinearMovingProvider}s
 *
 * @author felix.t.morgenstern
 * @version 0.0.1
 *
 */
public interface LoopingLinearMovingProviderFactory extends SoliloquyClass {
    /**
     * @param id The id of this ProviderAtTime
     * @param periodDuration The duration of the period over which this provider loops (c.f.
     *                       {@link LoopingLinearMovingProvider#periodDuration()}
     * @param periodModuloOffset The offset of the period (c.f.
     *                           {@link LoopingLinearMovingProvider#periodModuloOffset()})
     * @param valuesWithinPeriod The values corresponding to different ms positions within the
     *                           period (c.f.
     *                           {@link LoopingLinearMovingProvider#valuesWithinPeriod()}
     * @param mostRecentTimestamp The most recent timestamp for which a value was provided; can be
     *                            null, implying no value provided
     * @param pausedTimestamp The time at which this Provider has been paused
     * @param archetype An archetype, used by the factory to determine which type of Provider to
     *                  make. (NB: It is needed due to limitations in how Java handles generic
     *                  types.)
     * @param <T> The type of value provided
     * @return The newly-created LoopingLinearMovingProvider
     * @throws IllegalArgumentException If and only if id is null, periodDuration is less than or
     * equal to 0, periodModuloOffset is less than 0, periodModuloOffset is greater than or equal
     * to periodDuration, valuesWithinPeriod is null, valuesWithinPeriod does not have a value
     * corresponding to 0ms, or pausedTimestamp is non-null and mostRecentTimestamp is null or
     * prior to pausedTimestamp, or archetype is null
     */
    <T> LoopingLinearMovingProvider<T> make(EntityUuid id, int periodDuration,
                                            int periodModuloOffset,
                                            Map<Integer, T> valuesWithinPeriod,
                                            Long mostRecentTimestamp,
                                            Long pausedTimestamp, T archetype)
            throws IllegalArgumentException;
}
