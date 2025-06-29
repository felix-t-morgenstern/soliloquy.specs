package soliloquy.specs.io.graphics.renderables.providers.factories;

import soliloquy.specs.io.graphics.renderables.providers.FiniteLinearMovingColorProvider;

import java.awt.*;
import java.util.List;
import java.util.Map;
import java.util.UUID;

/**
 * <b>FiniteLinearMovingProviderFactory</b>
 * <p>
 * A factory which creates {@link FiniteLinearMovingColorProvider}s
 *
 * @author felix.t.morgenstern
 * @version 0.0.1
 */
public interface FiniteLinearMovingColorProviderFactory {
    /**
     * @param uuid                   The uuid of this ProviderAtTime
     * @param valuesAtTimestamps     The valuesAtTimestamps to provide
     * @param hueMovementIsClockwise The rotational directions of hue movements
     * @param pausedTimestamp        The timestamp at which this Provider is paused; if unpaused,
     *                               this
     *                               parameter should be null
     * @param mostRecentTimestamp    The most recent timestamp for which a value was provided; can
     *                               be
     *                               null, implying no value provided
     * @return The newly-created FiniteLinearMovingProvider
     * @throws IllegalArgumentException If and only if id is null; or valuesAtTimestamps is null,
     *                                  or contains fewer than two key-value pairs; or if
     *                                  hueMovementIsClockwise is null, or if
     *                                  hueMovementIsClockwise has any null items, or if
     *                                  hueMovementIsClockwise has a size different
     *                                  from the size of valuesAtTimestamps minus one; or if
     *                                  pausedTimestamp is non-null, and
     *                                  mostRecentTimestamp is either null or prior to
     *                                  pausedTimestamp
     */
    FiniteLinearMovingColorProvider make(UUID uuid, Map<Long, Color> valuesAtTimestamps,
                                         List<Boolean> hueMovementIsClockwise,
                                         Long pausedTimestamp, Long mostRecentTimestamp)
            throws IllegalArgumentException;
}
