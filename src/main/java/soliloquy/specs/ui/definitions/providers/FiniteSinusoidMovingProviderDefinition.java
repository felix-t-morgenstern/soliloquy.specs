package soliloquy.specs.ui.definitions.providers;

import soliloquy.specs.common.valueobjects.Pair;

import java.util.List;

public class FiniteSinusoidMovingProviderDefinition<T> extends AbstractProviderDefinition<T> {
    public final Pair<Integer, T>[] VALUES_AT_TIMESTAMP_OFFSETS;
    public final List<Float> TRANSITION_SHARPNESSES;

    @SafeVarargs
    private FiniteSinusoidMovingProviderDefinition(List<Float> transitionSharpnesses,
                                                   Pair<Integer, T>... valuesAtTimestampOffsets) {
        TRANSITION_SHARPNESSES = transitionSharpnesses;
        VALUES_AT_TIMESTAMP_OFFSETS = valuesAtTimestampOffsets;
    }

    @SafeVarargs
    public static <T> FiniteSinusoidMovingProviderDefinition<T> finiteSinusoidMoving(
            List<Float> transitionSharpnesses, Pair<Integer, T>... valuesAtTimestampOffsets) {
        return new FiniteSinusoidMovingProviderDefinition<>(transitionSharpnesses,
                valuesAtTimestampOffsets);
    }
}
