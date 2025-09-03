package soliloquy.specs.ui.definitions.colorshifting;

import soliloquy.specs.io.graphics.renderables.colorshifting.*;
import soliloquy.specs.ui.definitions.providers.AbstractProviderDefinition;

public class ShiftDefinition {
    public final AbstractProviderDefinition<Float> SHIFT_AMOUNT_PROVIDER;
    public final boolean OVERRIDES_PRIOR_SHIFTS_OF_SAME_TYPE;
    public final ColorComponent COMPONENT;
    public final ShiftType SHIFT_TYPE;

    private ShiftDefinition(AbstractProviderDefinition<Float> shiftAmountProvider,
                            boolean overridesPriorShiftsOfSameType, ColorComponent component,
                            ShiftType shiftType) {
        SHIFT_AMOUNT_PROVIDER = shiftAmountProvider;
        OVERRIDES_PRIOR_SHIFTS_OF_SAME_TYPE = overridesPriorShiftsOfSameType;
        COMPONENT = component;
        SHIFT_TYPE = shiftType;
    }

    /**
     * @param shiftAmountProvider C.f. {@link ColorShift#shiftAmountProvider()}
     * @param overridesPriorShiftsOfSameType C.f. {@link ColorShift#OVERRIDES_PRIOR_SHIFTS_OF_SAME_TYPE()}
     * @return A definition of a {@link BrightnessShift}
     */
    public static ShiftDefinition brightness(AbstractProviderDefinition<Float> shiftAmountProvider,
                                             boolean overridesPriorShiftsOfSameType) {
        return new ShiftDefinition(shiftAmountProvider, overridesPriorShiftsOfSameType, null,
                ShiftType.BRIGHTNESS);
    }

    /**
     * @param shiftAmountProvider C.f. {@link ColorShift#shiftAmountProvider()}
     * @param overridesPriorShiftsOfSameType C.f. {@link ColorShift#OVERRIDES_PRIOR_SHIFTS_OF_SAME_TYPE()}
     * @param component C.f. {@link ColorComponentIntensityShift#colorComponent()}
     * @return A definition of a {@link ColorComponentIntensityShift}
     */
    public static ShiftDefinition componentIntensity(
            AbstractProviderDefinition<Float> shiftAmountProvider,
            boolean overridesPriorShiftsOfSameType, ColorComponent component) {
        return new ShiftDefinition(shiftAmountProvider, overridesPriorShiftsOfSameType, component,
                ShiftType.COMPONENT_INTENSITY);
    }

    /**
     * @param shiftAmountProvider C.f. {@link ColorShift#shiftAmountProvider()}
     * @param overridesPriorShiftsOfSameType C.f. {@link ColorShift#OVERRIDES_PRIOR_SHIFTS_OF_SAME_TYPE()}
     * @return A definition of a {@link ColorRotationShift}
     */
    public static ShiftDefinition rotation(AbstractProviderDefinition<Float> shiftAmountProvider,
                                           boolean overridesPriorShiftsOfSameType) {
        return new ShiftDefinition(shiftAmountProvider, overridesPriorShiftsOfSameType, null,
                ShiftType.ROTATION);
    }

    public enum ShiftType {
        BRIGHTNESS,
        COMPONENT_INTENSITY,
        ROTATION
    }
}
