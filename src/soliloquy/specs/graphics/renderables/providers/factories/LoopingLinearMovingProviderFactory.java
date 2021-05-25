package soliloquy.specs.graphics.renderables.providers.factories;

import soliloquy.specs.common.shared.SoliloquyClass;
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
     * @param periodDuration The duration of the period over which this provider loops (c.f.
     * {@link LoopingLinearMovingProvider#periodDuration()}
     * @param periodModuloOffset The offset of the period (c.f.
     * {@link LoopingLinearMovingProvider#periodModuloOffset()})
     * @param valuesWithinPeriod The values corresponding to different ms positions within the
     *                           period (c.f.
     *                           {@link LoopingLinearMovingProvider#valuesWithinPeriod()}
     * @param <T> The type of value provided
     * @return The newly-created LoopingLinearMovingProvider
     * @throws IllegalArgumentException If and only if periodDuration is less than or equal to 0,
     * periodModuloOffset is less than 0, periodModuloOffset is greater than or equal to
     * periodDuration, valuesWithinPeriod is null, or valuesWithinPeriod does not have a value
     * corresponding to 0ms
     */
    <T> LoopingLinearMovingProvider<T> make(int periodDuration, int periodModuloOffset,
                                            Map<Integer, T> valuesWithinPeriod)
            throws IllegalArgumentException;
}
