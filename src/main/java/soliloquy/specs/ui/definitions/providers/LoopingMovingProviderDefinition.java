package soliloquy.specs.ui.definitions.providers;

import soliloquy.specs.common.valueobjects.Pair;

public class LoopingMovingProviderDefinition<T> extends AbstractProviderDefinition<T> {
    public final int PERIOD_DURATION;
    public final int PERIOD_MODULO_OFFSET;
    public final Pair<Integer, T>[] VALUES_WITHIN_PERIOD;

    @SafeVarargs
    protected LoopingMovingProviderDefinition(int periodDuration, int periodModuloOffset,
                                            Pair<Integer, T>... valuesWithinPeriod) {
        PERIOD_DURATION = periodDuration;
        PERIOD_MODULO_OFFSET = periodModuloOffset;
        VALUES_WITHIN_PERIOD = valuesWithinPeriod;
    }

    @SafeVarargs
    public static <T> LoopingMovingProviderDefinition<T> loopingMoving(int periodDuration,
                                                                       int periodModuloOffset,
                                                                       Pair<Integer, T>... valuesWithinPeriod) {
        return new LoopingMovingProviderDefinition<>(periodDuration, periodModuloOffset,
                valuesWithinPeriod);
    }
}
