package soliloquy.specs.graphics.renderables.providers;

import soliloquy.specs.common.shared.HasPeriodDuration;

import java.util.Map;

/**
 * <b>LoopingMovingProvider</b>
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
public interface LoopingMovingProvider<T> extends LoopingProvider<T>, HasPeriodDuration {
    /**
     * <i>NB: <u>When the movement is linear,</u> this method links milliseconds within a period to
     * the values; when this provider is requested for a value at a timestamp falling in the middle
     * of two milliseconds within this period, this provider takes a linear interpolation of the
     * values of the nearest two milliseconds. It is assumed that there is always a value at 0ms;
     * this value corresponds to both the start and end of the loop, so if a millisecond position
     * is requested beyond the last specified ms position described by this method, the linear
     * interpolation will be made between that last ms position and the first ms position.</i>
     * <p>
     * <i><u>Conversely, when the movement is discrete,</u> this method simply links values with
     * the first millisecond in which they appear. Again, a value is required at 0ms; and if, for
     * instance, there are values provided at 100ms and 200ms, the value at 100ms will be the value
     * provided until 200ms, at which point the latter value will be provided.</i>
     * <p>
     * <i>(This method only exists for the sake of persistence handling--it should <u>not</u>
     * return the same map, but rather, a clone.)</i>
     * @return A Map, linking ms within a period to their corresponding values.
     */
    Map<Integer, T> valuesWithinPeriod();
}
