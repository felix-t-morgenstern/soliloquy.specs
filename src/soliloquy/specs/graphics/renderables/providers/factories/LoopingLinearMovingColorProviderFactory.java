package soliloquy.specs.graphics.renderables.providers.factories;

import soliloquy.specs.common.shared.SoliloquyClass;
import soliloquy.specs.common.valueobjects.EntityUuid;
import soliloquy.specs.graphics.renderables.providers.LoopingMovingColorProvider;
import soliloquy.specs.graphics.renderables.providers.LoopingMovingProvider;

import java.awt.*;
import java.util.List;
import java.util.Map;

public interface LoopingLinearMovingColorProviderFactory extends SoliloquyClass {
    /**
     * @param id The id of this ProviderAtTime
     * @param periodDuration The duration of the period over which this provider loops (c.f.
     *                       {@link LoopingMovingProvider#periodDuration()}
     * @param periodModuloOffset The offset of the period (c.f.
     *                           {@link LoopingMovingProvider#periodModuloOffset()})
     * @param movementIsLinear Sets whether the movement is linear or discrete (c.f.
     *                         {@link LoopingMovingProvider#movementIsLinear}
     * @param valuesWithinPeriod The values corresponding to different ms positions within the
     *                           period (c.f.
     *                           {@link LoopingMovingProvider#valuesWithinPeriod()}
     * @param hueMovementIsClockwise The rotational direction of each movement
     * @return The newly-created LoopingMovingProvider
     * @throws IllegalArgumentException If and only if id is null, periodDuration is less than or
     * equal to 0, periodModuloOffset is less than 0, periodModuloOffset is greater than or equal
     * to periodDuration, valuesWithinPeriod is null, or valuesWithinPeriod does not have a value
     * corresponding to 0ms, or hueMovementIsClockwise is null, or if hueMovementIsClockwise has
     * any null items, or if hueMovementIsClockwise has a size different from that of
     * valuesWithinPeriod
     */
    LoopingMovingColorProvider make(EntityUuid id, int periodDuration, int periodModuloOffset,
                                    boolean movementIsLinear,
                                    Map<Integer, Color> valuesWithinPeriod,
                                    List<Boolean> hueMovementIsClockwise)
            throws IllegalArgumentException;
}
