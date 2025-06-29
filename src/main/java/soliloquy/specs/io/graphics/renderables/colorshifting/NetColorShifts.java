package soliloquy.specs.io.graphics.renderables.colorshifting;

/**
 * <b>NetColorShifts</b>
 * <p>
 * This class specifies the net color shifts of all {@link ColorShift}s, to be used by the default
 * shader. This class is to be generated when rendering a
 * {@link soliloquy.specs.io.graphics.renderables.Renderable} with a stack of {@link ColorShift}s.
 * <p>
 * Intended use for this class is to be generated at runtime as an anonymous class.
 *
 * @author felix.t.morgenstern
 * @version 0.0.1
 */
public interface NetColorShifts {
    /**
     * @return The net brightness shift, c.f. {@link BrightnessShift#shiftAmountProvider}, ranging
     *         from -1.0 to 1.0.
     */
    float brightnessShift();

    /**
     * @return The net increase for red, c.f.
     *         {@link ColorComponentIntensityShift#shiftAmountProvider}, ranging from -1.0 to 1.0.
     */
    float redIntensityShift();

    /**
     * @return The net increase for green, c.f.
     *         {@link ColorComponentIntensityShift#shiftAmountProvider}, ranging from -1.0 to 1.0.
     */
    float greenIntensityShift();

    /**
     * @return The net increase for blue, c.f.
     *         {@link ColorComponentIntensityShift#shiftAmountProvider}, ranging from -1.0 to 1.0.
     */
    float blueIntensityShift();

    /**
     * @return The net color rotation shift, c.f. {@link ColorRotationShift#shiftAmountProvider},
     *         ranging from -1.0 to 1.0.
     */
    float colorRotationShift();
}
