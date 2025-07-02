package soliloquy.specs.io.graphics.renderables.providers;

import java.util.List;

public interface FiniteSinusoidMovingProvider<T> extends FiniteLinearMovingProvider<T> {
    /**
     * <i>NB: This movement is sinusoid, meaning that its position is changed by the degree to
     * which a sine function changes its values over a range of [-pi/2, pi/2]. Practically, this
     * means that the change will start slowly at first, go fastest in the middle of the
     * transition, and slow down towards the end. Every value is paired with a float value,
     * representing the sharpness of the curve. The lower this value, approaching but not going
     * lower than zero, the more slowly the transition proceeds at the beginning and the end, and
     * the more quickly it proceeds in the middle. This value can never be lower than 0.
     * Conversely, the higher this value, the faster the transition proceeds at the beginning and
     * the end, and the more slowly it proceeds in the middle. Behavior of this Provider may become
     * odd the closer this value approaches zero, or the higher this value becomes, particularly
     * above 4.</i>
     * <p>
     * <i>Because this List describes the sharpness of each transition, it is expected that it will
     * contain N entries, where N is 1 less than the size of
     * {@link #valuesAtTimestampsRepresentation}.</i>
     * <p>
     * <i>ALSO note that this method returns a representation, not the actual values!</i>
     *
     * @return A List of the sharpnesses of each transition
     */
    List<Float> transitionSharpnesses();
}
