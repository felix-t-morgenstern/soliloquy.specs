package soliloquy.specs.ui.definitions.providers;

import soliloquy.specs.common.valueobjects.Pair;

import java.awt.Color;
import java.util.List;

public class FiniteLinearMovingColorProviderDefinition extends
        FiniteLinearMovingProviderDefinition<Color> {
    public final List<Boolean> HUE_MOVEMENT_IS_CLOCKWISE;

    @SafeVarargs
    private FiniteLinearMovingColorProviderDefinition(List<Boolean> hueMovementIsClockwise,
                                                      Pair<Integer, Color>... valuesAtTimestampOffsets) {
        super(valuesAtTimestampOffsets);
        HUE_MOVEMENT_IS_CLOCKWISE = hueMovementIsClockwise;
    }

    @SafeVarargs
    public static FiniteLinearMovingColorProviderDefinition finiteLinearMovingColor(
            List<Boolean> hueMovementIsClockwise,
            Pair<Integer, Color>... valuesAtTimestampOffsets) {
        return new FiniteLinearMovingColorProviderDefinition(hueMovementIsClockwise,
                valuesAtTimestampOffsets);
    }
}
