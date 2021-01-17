package soliloquy.specs.graphics.colorshifting;

import soliloquy.specs.common.shared.SoliloquyClass;

/**
 * <b>NetColorShifts</b>
 * <p>
 * This class specifies the net color shifts of all {@link ColorShiftType}s, to be used by the
 * default shader. This class is to be generated when rendering a
 * {@link soliloquy.specs.graphics.renderables.RenderableType} with a stack of
 * {@link ColorShiftType}s.
 * <p>
 * Intended use for this class is to be generated at runtime as an anonymous class.
 *
 * @author felix.t.morgenstern
 * @version 0.0.1
 *
 */
public interface NetColorShifts extends SoliloquyClass {
    /**
     * @return The net brightness shift, c.f. {@link BrightnessShift#shiftAmount}, ranging from
     * -1.0 to 1.0.
     */
    float netBrightnessShift();

    /**
     * @return The net red shift, c.f. {@link ColorComponentShift#shiftAmount}, ranging from -1.0
     * to 1.0.
     */
    float netRedShift();

    /**
     * @return The net green shift, c.f. {@link ColorComponentShift#shiftAmount}, ranging from -1.0
     * to 1.0.
     */
    float netGreenShift();

    /**
     * @return The net blue shift, c.f. {@link ColorComponentShift#shiftAmount}, ranging from -1.0
     * to 1.0.
     */
    float netBlueShift();

    /**
     * @return The net color rotation shift, c.f. {@link ColorRotationShift#shiftAmount}, ranging
     * from -1.0 to 1.0.
     */
    float netColorRotationShift();
}
