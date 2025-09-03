package soliloquy.specs.io.graphics.renderables.colorshifting;

import soliloquy.specs.io.graphics.renderables.providers.ProviderAtTime;

/**
 * <b>ColorRotationShift</b>
 * <p>
 * A color shift that rotates colors. When shifts of this type are stacked, they are stacked
 * additively, with values of -1.0 looping around to 1.0, and vice-versa. A value of 0.0 implies no
 * change. The value corresponds to "clockwise" rotation within the color wheel, going from red to
 * green to blue, and back to red. A value of 1.0 is a full rotation clockwise, i.e. it has no
 * effect. Values lower than 0.0 or greater than or equal to 1.0 will be brought back into the range
 * of [0.0, 1.0).<i>It is expected that the value provided will never be null.</i>
 *
 * @author felix.t.morgenstern
 * @version 0.0.1
 */
public class ColorRotationShift extends ColorShift {
    private ColorRotationShift(
            ProviderAtTime<Float> amountProvider,
            boolean overridesPriorShiftsOfSameType
    ) {
        super(amountProvider, overridesPriorShiftsOfSameType);
    }

    public static ColorRotationShift rotationShift(
            ProviderAtTime<Float> amountProvider,
            boolean overridesPriorShiftsOfSameType
    ) {
        return new ColorRotationShift(amountProvider, overridesPriorShiftsOfSameType);
    }
}
