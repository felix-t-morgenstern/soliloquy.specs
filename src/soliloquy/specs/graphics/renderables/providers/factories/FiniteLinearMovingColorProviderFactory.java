package soliloquy.specs.graphics.renderables.providers.factories;

import soliloquy.specs.common.shared.SoliloquyClass;
import soliloquy.specs.graphics.renderables.providers.FiniteLinearMovingColorProvider;

import java.awt.*;
import java.util.List;
import java.util.Map;

/**
 * <b>FiniteLinearMovingProviderFactory</b>
 * <p>
 * A factory which creates {@link FiniteLinearMovingColorProvider}s
 *
 * @author felix.t.morgenstern
 * @version 0.0.1
 *
 */
public interface FiniteLinearMovingColorProviderFactory extends SoliloquyClass {
    /**
     * @param valuesAtTimestamps The valuesAtTimestamps to provide (c.f.
     * {@link FiniteLinearMovingColorProvider#valuesAtTimestamps})
     * @param hueMovementIsClockwise The rotational directions of hue movements (c.f.
     * {@link FiniteLinearMovingColorProvider#hueMovementIsClockwise})
     * @return The newly-created FiniteLinearMovingProvider
     * @throws IllegalArgumentException If and only if valuesAtTimestamps is null, or contains
     * fewer than two key-value pairs, or if hueMovementIsClockwise is null, or if
     * hueMovementIsClockwise has any null items, or if hueMovementIsClockwise has a size different
     * from the size of valuesAtTimestamps minus one
     */
    FiniteLinearMovingColorProvider make(Map<Long, Color> valuesAtTimestamps,
                                         List<Boolean> hueMovementIsClockwise)
            throws IllegalArgumentException;
}
