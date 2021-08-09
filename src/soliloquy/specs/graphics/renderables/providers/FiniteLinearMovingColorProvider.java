package soliloquy.specs.graphics.renderables.providers;

import java.awt.*;
import java.util.List;

/**
 * <b>FiniteLinearMovingColorProvider</b>
 * <p>
 * A ProviderAtTime which supports linear movement from one Color to another
 * <p>
 * <i>NB: This class does not need to be explicitly defined to actually provide the values;
 * however, it is necessary to expose the underlying data in this provider for the purpose of
 * persistence handling.</i>
 *
 * @author felix.t.morgenstern
 * @version 0.0.1
 *
 */
public interface FiniteLinearMovingColorProvider extends FiniteLinearMovingProvider<Color> {
    /**
     * <i>NB: This class exists because hues in color space are circular. For instance, a movement
     * from red to green can travel clockwise, from red to yellow to green; but it can also travel
     * counterclockwise, from red to purple to blue to cyan to green. For every value within
     * {@link #valuesAtTimestampsRepresentation} after the first, that implies a movement in hue;
     * and this method outlines whether each of those movements of hue are clockwise or
     * counterclockwise.</i>
     * @return A List containing booleans, each of which is true if the corresponding hue movement
     * implied in {@link #valuesAtTimestampsRepresentation} is clockwise, i.e. from red to green to
     * blue
     */
    List<Boolean> hueMovementIsClockwise();
}
