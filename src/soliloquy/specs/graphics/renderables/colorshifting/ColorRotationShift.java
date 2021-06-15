package soliloquy.specs.graphics.renderables.colorshifting;

import soliloquy.specs.graphics.renderables.providers.ProviderAtTime;

/**
 * <b>ColorRotationShift</b>
 * <p>
 * A color shift that rotates colors. When shifts of this type are stacked, they
 * are stacked additively, with values of -1.0 looping around to 1.0, and vice-versa.
 * <p>
 * Intended use for this class is to be generated at runtime as an anonymous class.
 *
 * @author felix.t.morgenstern
 * @version 0.0.1
 *
 */
public interface ColorRotationShift extends ColorShift {
    /**
     * A value of 0.0 implies no change. The value corresponds to "clockwise" rotation within the
     * color wheel, going from red to green to blue, and back to red. A value of 1.0 is a full
     * rotation clockwise, i.e. it has no effect. Values lower than 0.0 or greater than or equal to
     * 1.0 will be brought back into the range of [0.0, 1.0).
     * @return The amount by which the colors are rotated at the specified timestamp. <i>It is
     * expected that the value provided will never be null.</i>
     */
    ProviderAtTime<Float> shiftAmountProvider();
}
