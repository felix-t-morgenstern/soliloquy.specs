package soliloquy.specs.io.graphics.renderables.colorshifting;

/**
 * <b>NetColorShifts</b>
 * <p>
 * This class specifies the net color shifts of all {@link ColorShift}s, to be used by the default
 * shader. This class is to be generated when rendering a
 * {@link soliloquy.specs.io.graphics.renderables.Renderable} with a stack of {@link ColorShift}s.
 *
 * @author felix.t.morgenstern
 * @version 0.0.1
 */
public class NetColorShifts {
    /**
     * The net brightness shift, c.f. {@link BrightnessShift#shiftAmountProvider}, ranging from -1.0
     * to 1.0.
     */
    public final float BRIGHTNESS_SHIFT;
    /**
     * The net increase for red, c.f. {@link ColorComponentIntensityShift#shiftAmountProvider},
     * ranging from -1.0 to 1.0.
     */
    public final float RED_INTENSITY_SHIFT;
    /**
     * The net increase for green, c.f. {@link ColorComponentIntensityShift#shiftAmountProvider},
     * ranging from -1.0 to 1.0.
     */
    public final float GREEN_INTENSITY_SHIFT;
    /**
     * The net increase for blue, c.f. {@link ColorComponentIntensityShift#shiftAmountProvider},
     * ranging from -1.0 to 1.0.
     */
    public final float BLUE_INTENSITY_SHIFT;
    /**
     * The net color rotation shift, c.f. {@link ColorRotationShift#shiftAmountProvider}, ranging
     * from -1.0 to 1.0.
     */
    public final float COLOR_ROTATION_SHIFT;

    private NetColorShifts(float brightnessShift, float redIntensityShift,
                           float greenIntensityShift,
                           float blueIntensityShift, float colorRotationShift) {
        BRIGHTNESS_SHIFT = brightnessShift;
        RED_INTENSITY_SHIFT = redIntensityShift;
        GREEN_INTENSITY_SHIFT = greenIntensityShift;
        BLUE_INTENSITY_SHIFT = blueIntensityShift;
        COLOR_ROTATION_SHIFT = colorRotationShift;
    }

    public static NetColorShifts netShifts(float brightnessShift, float redIntensityShift,
                                           float greenIntensityShift, float blueIntensityShift,
                                           float colorRotationShift) {
        return new NetColorShifts(brightnessShift, redIntensityShift, greenIntensityShift,
                blueIntensityShift, colorRotationShift);
    }
}
