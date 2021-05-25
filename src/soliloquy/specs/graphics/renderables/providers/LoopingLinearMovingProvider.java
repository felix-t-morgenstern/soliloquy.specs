package soliloquy.specs.graphics.renderables.providers;

import java.util.Map;

/**
 * <b>LoopingLinearMovingProvider</b>
 * <p>
 * A ProviderAtTime which supports linear movement from one value, e.g. a rendering area or a
 * float, to another, on a loop, within a period; this can be paused and resumed
 * <p>
 * <i>NB: This class does not need to be explicitly defined to actually provide the values;
 * however, it is necessary to expose the underlying data in this provider for the purpose of
 * persistence handling.</i>
 *
 * @author felix.t.morgenstern
 * @version 0.0.1
 *
 */
public interface LoopingLinearMovingProvider<T> extends ProviderAtTime<T>, NonStaticProvider {
    /**
     * @return The duration, in ms, of the period over which this provider loops
     */
    int periodDuration();

    /**
     * <i>NB: This method exists to support period starting timestamps which are not exact
     * multiples of the periodDuration. E.g., if periodDuration is 1000ms, then the periods would
     * start on the timestamps 1000ms, 2000ms, 3000ms, etc. However, if this method returns 250,
     * then the periods would start on the timestamps 1250ms, 2250ms, 3250ms, etc.</i>
     * @return The offset, in ms, of the period start time.
     */
    int periodModuloOffset();

    /**
     * <i>NB: This method links milliseconds within a period to the values; when this provider is
     * requested for a value at a timestamp falling in the middle of two milliseconds within this
     * period, this provider takes a linear interpolation of the values of the nearest two
     * milliseconds. It is assumed that there is always a value at 0ms; this value corresponds to
     * both the start and end of the loop, so if a millisecond position is requested beyond the
     * last specified ms position described by this method, the linear interpolation will be made
     * between that last ms position and the first ms position.</i>
     * @return A Map, linking ms within a period to their corresponding values.
     */
    Map<Integer, T> valuesWithinPeriod();
}
