package soliloquy.specs.graphics.renderables.providers;

public interface PausableProviderWithOffset<T> extends NonStaticProvider<T> {
    /**
     * <i>NB: This method exists to support period starting timestamps which are not exact
     * multiples of the periodDuration. E.g., if periodDuration is 1000ms, then the periods would
     * start on the timestamps 1000ms, 2000ms, 3000ms, etc. However, if this method returns 250,
     * then the periods would start on the timestamps 1250ms, 2250ms, 3250ms, etc.</i>
     * @return The offset, in ms, of the period start time.
     */
    int periodModuloOffset();
}
