package soliloquy.specs.graphics.renderables.providers.factories;

import soliloquy.specs.common.shared.SoliloquyClass;
import soliloquy.specs.graphics.renderables.providers.LoopingLinearMovingColorProvider;
import soliloquy.specs.graphics.renderables.providers.LoopingLinearMovingProvider;

import java.awt.*;
import java.util.List;
import java.util.Map;

public interface LoopingLinearMovingColorProviderFactory extends SoliloquyClass {
    /**
     * @param periodDuration The duration of the period over which this provider loops (c.f.
     * {@link LoopingLinearMovingProvider#periodDuration()}
     * @param periodModuloOffset The offset of the period (c.f.
     * {@link LoopingLinearMovingProvider#periodModuloOffset()})
     * @param valuesWithinPeriod The values corresponding to different ms positions within the
     *                           period (c.f.
     *                           {@link LoopingLinearMovingProvider#valuesWithinPeriod()}
     * @param hueMovementIsClockwise The rotational direction of each movement
     * @return The newly-created LoopingLinearMovingProvider
     * @throws IllegalArgumentException If and only if periodDuration is less than or equal to 0,
     * periodModuloOffset is less than 0, periodModuloOffset is greater than or equal to
     * periodDuration, valuesWithinPeriod is null, or valuesWithinPeriod does not have a value
     * corresponding to 0ms, or hueMovementIsClockwise is null, or if hueMovementIsClockwise has
     * any null items, or if hueMovementIsClockwise has a size different from that of
     * valuesWithinPeriod
     */
    LoopingLinearMovingColorProvider make(int periodDuration, int periodModuloOffset,
                                          Map<Integer, Color> valuesWithinPeriod,
                                          List<Boolean> hueMovementIsClockwise)
            throws IllegalArgumentException;
}
