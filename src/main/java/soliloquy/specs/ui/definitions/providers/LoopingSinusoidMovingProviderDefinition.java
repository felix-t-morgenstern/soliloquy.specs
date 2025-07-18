package soliloquy.specs.ui.definitions.providers;

import soliloquy.specs.common.valueobjects.Pair;

public class LoopingSinusoidMovingProviderDefinition<T> extends LoopingLinearMovingProviderDefinition<T> {
    private LoopingSinusoidMovingProviderDefinition(int periodDuration, int periodModuloOffset,
                                                      Pair<Integer, T>... valuesWithinPeriod) {
        super(periodDuration, periodModuloOffset, valuesWithinPeriod);
    }
}
