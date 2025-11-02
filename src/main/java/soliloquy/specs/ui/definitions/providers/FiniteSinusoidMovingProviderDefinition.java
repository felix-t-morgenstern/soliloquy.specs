package soliloquy.specs.ui.definitions.providers;

import soliloquy.specs.common.valueobjects.Pair;

import java.util.List;

public class FiniteSinusoidMovingProviderDefinition<T> extends FiniteLinearMovingProviderDefinition<T> {
    public final float[] TRANSITION_SHARPNESSES;

    @SafeVarargs
    private FiniteSinusoidMovingProviderDefinition(float[] transitionSharpnesses,
                                                   Pair<Integer, T>... valuesAtTimestampOffsets) {
        super(valuesAtTimestampOffsets);
        TRANSITION_SHARPNESSES = transitionSharpnesses;
    }

    @SafeVarargs
    public static <T> FiniteSinusoidMovingProviderDefinition<T> finiteSinusoidMoving(
            float[] transitionSharpnesses, Pair<Integer, T>... valuesAtTimestampOffsets) {
        return new FiniteSinusoidMovingProviderDefinition<>(transitionSharpnesses,
                valuesAtTimestampOffsets);
    }

    @SafeVarargs
    public static <T> FiniteSinusoidMovingProviderDefinition<T> finiteSinusoidMoving(
            Pair<Integer, T>... valuesAtTimestampOffsets) {
        return new FiniteSinusoidMovingProviderDefinition<>(
                new float[valuesAtTimestampOffsets.length - 1],
                valuesAtTimestampOffsets
        );
    }
}
