package soliloquy.specs.graphics.renderables.colorshifting;

import soliloquy.specs.graphics.renderables.providers.ProviderAtTime;

/**
 * <b>ColorComponentIntensityShift</b>
 * <p>
 * A color shift that increases or decreases the value of a specific color component (i.e. red,
 * green, or blue--alpha is not supported for this operation). When shifts of this type are
 * stacked, they are stacked additively, with a floor at -1.0, and a ceiling at 1.0.
 * <p>
 * Intended use for this class is to be generated at runtime as an anonymous class. <i>It is
 * expected that the value provided will never be null.</i>
 *
 * @author felix.t.morgenstern
 * @version 0.0.1
 */
public interface ColorComponentIntensityShift extends ColorShift {
    /**
     * @return The ColorComponent to shift (i.e. red, green, or blue--alpha is unsupported)
     */
    ColorComponent colorComponent();

    /**
     * The value provided here is to range between -1.0 and 1.0, inclusively. A value of 0.0
     * implies no change. A value of 1.0 implies that every pixel's specified component (e.g. red,
     * green, or blue) is set to 255. A value of -1.0 implies that every pixel's specified
     * component is set to 0. A value of 0.5 implies that every pixel's specified component's
     * distance to 255 is halved. A value of -0.5 implies that every pixel's specified component's
     * distance to 0 is halved.
     *
     * @return The amount to which to shift the value of the specified ColorComponent at the
     *         provided timestamp.
     */
    ProviderAtTime<Float> shiftAmountProvider();
}
