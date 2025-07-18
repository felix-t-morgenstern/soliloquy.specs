package soliloquy.specs.ui.definitions.providers;

import soliloquy.specs.common.valueobjects.Pair;

public class LoopingLinearMovingProviderDefinition<T> extends AbstractProviderDefinition<T> {
    public final int PERIOD_DURATION;
    public final int RENDER_TIMESTAMP_OFFSET;
    public final Pair<Integer, T>[] VALUES_WITHIN_PERIOD;

    @SafeVarargs
    protected LoopingLinearMovingProviderDefinition(int periodDuration, int renderTimestampOffset,
                                                    Pair<Integer, T>... valuesWithinPeriod) {
        PERIOD_DURATION = periodDuration;
        RENDER_TIMESTAMP_OFFSET = renderTimestampOffset;
        VALUES_WITHIN_PERIOD = valuesWithinPeriod;
    }

    @SafeVarargs
    public static <T> LoopingLinearMovingProviderDefinition<T> loopingLinearMoving(
            int periodDuration, int renderTimestampOffset, Pair<Integer, T>... valuesWithinPeriod) {
        return new LoopingLinearMovingProviderDefinition<>(periodDuration, renderTimestampOffset,
                valuesWithinPeriod);
    }
}
