package soliloquy.specs.graphics.renderables.colorshifting;

import soliloquy.specs.common.shared.SoliloquyClass;
import soliloquy.specs.graphics.renderables.providers.ProviderAtTime;

/**
 * <b>ColorShift</b>
 * <p>
 * A type of color shift (e.g. brightness adjustment, red/green swapping, etc.)
 *
 * @author felix.t.morgenstern
 * @version 0.0.1
 *
 */
public interface ColorShift extends SoliloquyClass {
    /**
     * See the individual implementations for more details:
     * {@link BrightnessShift#shiftAmountProvider()},
     * {@link ColorComponentIntensityShift#shiftAmountProvider()}, and
     * {@link ColorRotationShift#shiftAmountProvider()}
     * @return A Provider, providing the value for this ColorShift at a given time
     */
    ProviderAtTime<Float> shiftAmountProvider();

    /**
     * 'Type' here refers to specific implementations of ColorShift; so, for example, if a
     * {@link BrightnessShift} returns True from this method, then all BrightnessShifts lower in
     * the stack are ignored.
     * @return If true, then this shift overrides all previous shifts of the same type.
     */
    boolean overridesPriorShiftsOfSameType();
}
