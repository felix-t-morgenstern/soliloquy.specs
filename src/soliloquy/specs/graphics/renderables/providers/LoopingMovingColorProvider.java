package soliloquy.specs.graphics.renderables.providers;

import java.awt.*;
import java.util.List;

public interface LoopingMovingColorProvider extends LoopingMovingProvider<Color> {
    /**
     * <i>NB: This class exists because hues in color space are circular. For instance, a movement
     * from red to green can travel clockwise, from red to yellow to green; but it can also travel
     * counterclockwise, from red to purple to blue to cyan to green. For every value within
     * {@link #valuesWithinPeriod}, that implies a movement in hue; and this method outlines
     * whether each of those movements of hue are clockwise or counterclockwise.</i>
     * @return A List containing booleans, each of which is true if the corresponding hue movement
     * implied in {@link #valuesWithinPeriod} is clockwise, i.e. from red to green to blue
     */
    List<Boolean> hueMovementIsClockwise();
}
