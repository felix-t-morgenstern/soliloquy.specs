package soliloquy.specs.ui.definitions.providers;

import soliloquy.specs.common.valueobjects.Pair;

import java.awt.*;
import java.util.List;

public class LoopingMovingColorProviderDefinition extends
        LoopingLinearMovingProviderDefinition<Color> {
    public final List<Boolean> HUE_MOVEMENT_IS_CLOCKWISE;

    @SafeVarargs
    public LoopingMovingColorProviderDefinition(int periodDuration, int renderTimestampOffset,
                                                List<Boolean> hueMovementIsClockwise,
                                                Pair<Integer, Color>... valuesWithinPeriod) {
        super(periodDuration, renderTimestampOffset, valuesWithinPeriod);
        HUE_MOVEMENT_IS_CLOCKWISE = hueMovementIsClockwise;
    }
}
