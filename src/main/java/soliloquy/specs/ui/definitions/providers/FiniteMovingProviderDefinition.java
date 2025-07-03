package soliloquy.specs.ui.definitions.providers;

import soliloquy.specs.common.valueobjects.Pair;

public class FiniteMovingProviderDefinition<T> extends AbstractProviderDefinition<T> {
    public final Pair<Long, T>[] VALUES_AT_TIMESTAMPS;
    public final MotionType MOVEMENT_TYPE;

    @SafeVarargs
    protected FiniteMovingProviderDefinition(MotionType motionType,
                                             Pair<Long, T>... valuesAtTimestamps) {
        VALUES_AT_TIMESTAMPS = valuesAtTimestamps;
        MOVEMENT_TYPE = motionType;
    }

    @SafeVarargs
    public static <T> FiniteMovingProviderDefinition<T> finiteMoving(MotionType motionType,
                                                                     Pair<Long, T>... valuesAtTimestamps) {
        return new FiniteMovingProviderDefinition<>(motionType, valuesAtTimestamps);
    }
}
