package soliloquy.specs.ui.definitions.providers;

import soliloquy.specs.common.valueobjects.Pair;

public class FiniteLinearMovingProviderDefinition<T> extends AbstractProviderDefinition<T> {
    public final Pair<Integer, T>[] VALUES_AT_TIMESTAMP_OFFSETS;

    @SafeVarargs
    protected FiniteLinearMovingProviderDefinition(Pair<Integer, T>... valuesAtTimestampOffsets) {
        VALUES_AT_TIMESTAMP_OFFSETS = valuesAtTimestampOffsets;
    }

    @SafeVarargs
    public static <T> FiniteLinearMovingProviderDefinition<T> finiteLinearMoving(
            Pair<Integer, T>... valuesAtTimestamps) {
        return new FiniteLinearMovingProviderDefinition<>(valuesAtTimestamps);
    }
}
