package soliloquy.specs.graphics.colorshifting;

/**
 * <b>BrightnessShift</b>
 * <p>
 * A color shift that increases or decreases brightness. When shifts of this type are stacked, they
 * are stacked additively, with a floor at -1.0, and a ceiling at 1.0.
 * <p>
 * Intended use for this class is to be generated at runtime as an anonymous class.
 *
 * @author felix.t.morgenstern
 * @version 0.0.1
 *
 */
public interface BrightnessShift extends ColorShift {
    /**
     * The value provided here is to range between -1.0 and 1.0, inclusively. A value of 0.0
     * implies no change. A value of 1.0 implies that every pixel is set to white (i.e.
     * (255,255,255) in RGB values). A value of -1.0 implies that every pixel is set to black (i.e.
     * (0,0,0) in RGB values). A value of 0.5 implies that every pixel's distance to (255,255,255)
     * is halved. A value of -0.5 implies that every pixel's distance to (0,0,0) is halved.
     * @return The amount to which to shift the brightness
     */
    float shiftAmount();
}
