package soliloquy.specs.ui.definitions.providers;

import soliloquy.specs.common.valueobjects.Pair;

import java.util.List;

public class FiniteSinusoidMovingProviderDefinition<T> extends FiniteLinearMovingProviderDefinition<T> {
    public final List<Float> TRANSITION_SHARPNESSES;

    @SafeVarargs
    private FiniteSinusoidMovingProviderDefinition(List<Float> transitionSharpnesses,
                                                   Pair<Integer, T>... valuesAtTimestampOffsets) {
        super(valuesAtTimestampOffsets);
        TRANSITION_SHARPNESSES = transitionSharpnesses;
    }

    @SafeVarargs
    public static <T> FiniteSinusoidMovingProviderDefinition<T> finiteSinusoidMoving(
            List<Float> transitionSharpnesses, Pair<Integer, T>... valuesAtTimestampOffsets) {
        return new FiniteSinusoidMovingProviderDefinition<>(transitionSharpnesses,
                valuesAtTimestampOffsets);
    }
}
