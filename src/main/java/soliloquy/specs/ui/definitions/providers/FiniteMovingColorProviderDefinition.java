package soliloquy.specs.ui.definitions.providers;

import soliloquy.specs.common.valueobjects.Pair;

import java.awt.Color;
import java.util.List;

public class FiniteMovingColorProviderDefinition extends FiniteMovingProviderDefinition<Color> {
    public final List<Boolean> HUE_MOVEMENT_IS_CLOCKWISE;

    @SafeVarargs
    private FiniteMovingColorProviderDefinition(MotionType motionType,
                                                List<Boolean> hueMovementIsClockwise,
                                                Pair<Long, Color>... valuesAtTimestamps) {
        super(motionType, valuesAtTimestamps);
        HUE_MOVEMENT_IS_CLOCKWISE = hueMovementIsClockwise;
    }

    @SafeVarargs
    public static FiniteMovingColorProviderDefinition finiteMovingColor(MotionType motionType,
                                                                        List<Boolean> hueMovementIsClockwise,
                                                                        Pair<Long, Color>... valuesAtTimestamps) {
        return new FiniteMovingColorProviderDefinition(motionType, hueMovementIsClockwise,
                valuesAtTimestamps);
    }
}
