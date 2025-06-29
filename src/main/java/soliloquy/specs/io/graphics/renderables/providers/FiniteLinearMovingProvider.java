package soliloquy.specs.io.graphics.renderables.providers;

import soliloquy.specs.common.valueobjects.FloatBox;

import java.util.Map;

/**
 * <b>FiniteLinearMovingProvider</b>
 * <p>
 * A ProviderAtTime which supports linear movement from one value, e.g. a rendering area or a
 * float, to another
 * <p>
 * <i>NB: This class does not need to be explicitly defined to actually provide the values;
 * however, it is necessary to expose the underlying data in this provider for the purpose of
 * persistence handling.</i>
 *
 * @author felix.t.morgenstern
 * @version 0.0.1
 */
public interface FiniteLinearMovingProvider<T> extends ProviderAtTime<T> {
    /**
     * <i>NB: The values represented by method are used to calculate motion, e.g. a moving
     * {@link FloatBox} representing the position of a
     * {@link soliloquy.specs.io.graphics.renderables.Renderable} in the window. The notion is that a
     * rendering area can start at one place in the window at one timestamp, and it will move
     * towards another place in the window, arriving there by the timestamp corresponding to that
     * second place. If this class is asked to provide the value prior to the first timestamp, it
     * will return the value at the first timestamp; similarly, if this class is asked to provide
     * the value after the last timestamp, it will return the value at the last timestamp.
     * <p>
     * ALSO note that this method returns a representation, not the actual values!</i>
     *
     * @return A Map, linking timestamps to the values provided at that timestamp. Linear movement
     *         is calculated for any given timestamp by finding the distance between the two nearest
     *         timestamps.
     */
    Map<Long, T> valuesAtTimestampsRepresentation();
}
