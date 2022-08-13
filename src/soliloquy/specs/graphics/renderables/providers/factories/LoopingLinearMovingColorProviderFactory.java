package soliloquy.specs.graphics.renderables.providers.factories;

import soliloquy.specs.common.shared.SoliloquyClass;
import soliloquy.specs.graphics.renderables.providers.LoopingLinearMovingColorProvider;
import soliloquy.specs.graphics.renderables.providers.LoopingLinearMovingProvider;

import java.awt.*;
import java.util.List;
import java.util.Map;
import java.util.UUID;

public interface LoopingLinearMovingColorProviderFactory extends SoliloquyClass {
    /**
     * @param uuid                   The uuid of this ProviderAtTime
     * @param valuesWithinPeriod     The values corresponding to different ms positions within the
     *                               period (c.f.
     *                               {@link LoopingLinearMovingProvider#valuesWithinPeriod()}
     * @param hueMovementIsClockwise The rotational direction of each movement
     * @param periodDuration         The duration of the period over which this provider loops (c.f.
     *                               {@link LoopingLinearMovingProvider#periodDuration()}
     * @param periodModuloOffset     The offset of the period (c.f.
     *                               {@link LoopingLinearMovingProvider#periodModuloOffset()})
     * @param pausedTimestamp        The timestamp at which the Provider has been paused; if it is
     *                               unpaused, this should be null
     * @param mostRecentTimestamp    The most recent timestamp for which a value was provided; can
     *                               be
     *                               null, implying no value provided
     * @return The newly-created LoopingLinearMovingProvider
     * @throws IllegalArgumentException If and only if uuid is null, periodDuration is less than or
     *                                  equal to 0, periodModuloOffset is less than 0,
     *                                  periodModuloOffset is greater than or equal
     *                                  to periodDuration, valuesWithinPeriod is null, or
     *                                  valuesWithinPeriod does not have a value
     *                                  corresponding to 0ms, or if valuesWithinPeriod has any null
     *                                  times within the period, or
     *                                  hueMovementIsClockwise is null, or if hueMovementIsClockwise
     *                                  has any null items, or if
     *                                  hueMovementIsClockwise has a size different from that of
     *                                  valuesWithinPeriod
     */
    LoopingLinearMovingColorProvider make(UUID uuid, Map<Integer, Color> valuesWithinPeriod,
                                          List<Boolean> hueMovementIsClockwise,
                                          int periodDuration, int periodModuloOffset,
                                          Long pausedTimestamp, Long mostRecentTimestamp)
            throws IllegalArgumentException;
}
