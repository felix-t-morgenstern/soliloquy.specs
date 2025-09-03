package soliloquy.specs.io.graphics.renderables.colorshifting;

import soliloquy.specs.io.graphics.renderables.providers.ProviderAtTime;

/**
 * <b>ColorShift</b>
 * <p>
 * A type of color shift (e.g. brightness adjustment, red/green swapping, etc.)
 *
 * @author felix.t.morgenstern
 * @version 0.0.1
 */
public class ColorShift {
    /**
     * See the individual implementations for more details: {@link BrightnessShift},
     * {@link ColorComponentIntensityShift}, and {@link ColorRotationShift}
     */
    public final ProviderAtTime<Float> AMOUNT_PROVIDER;

    /**
     * 'Type' here refers to specific implementations of ColorShift; so, for example, if a
     * {@link BrightnessShift} returns True from this method, then all BrightnessShifts lower in
     * the stack are ignored.
     */
    public final boolean OVERRIDES_PRIOR_SHIFTS_OF_SAME_TYPE;

    protected ColorShift(
            ProviderAtTime<Float> amountProvider,
            boolean overridesPriorShiftsOfSameType
    ) {
        AMOUNT_PROVIDER = amountProvider;
        OVERRIDES_PRIOR_SHIFTS_OF_SAME_TYPE = overridesPriorShiftsOfSameType;
    }
}
