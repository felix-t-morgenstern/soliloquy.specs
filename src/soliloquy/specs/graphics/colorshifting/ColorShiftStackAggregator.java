package soliloquy.specs.graphics.colorshifting;

import soliloquy.specs.common.infrastructure.Collection;
import soliloquy.specs.common.shared.SoliloquyClass;

/**
 * <b>NetColorShifts</b>
 * <p>
 * This class takes a Stack (technically a {@link Collection}) of {@link ColorShiftType}s of
 * various types, and aggregates them into a {@link NetColorShifts} object, which can be used by
 * the shader program to render a {@link soliloquy.specs.graphics.renderables.Renderable}.
 *
 * @author felix.t.morgenstern
 * @version 0.0.1
 *
 */
public interface ColorShiftStackAggregator extends SoliloquyClass {
    /**
     * @param colorShifts The ColorShiftTypes to aggregate
     * @return The NetColorShifts resulting from the provided colorShifts
     * @throws IllegalArgumentException If and only if colorShifts is null, or contains any
     * ColorShiftTypes with invalid values
     */
    NetColorShifts aggregate(Collection<ColorShiftType> colorShifts)
            throws IllegalArgumentException;
}
