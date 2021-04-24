package soliloquy.specs.graphics.renderables.colorshifting;

import soliloquy.specs.common.shared.SoliloquyClass;

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
     * 'Type' here refers to specific implementations of ColorShift; so, for example, if a
     * {@link BrightnessShift} returns True from this method, then all BrightnessShifts lower in
     * the stack are ignored.
     * @return If true, then this shift overrides all previous shifts of the same type.
     */
    boolean overridesPriorShiftsOfSameType();
}
