package soliloquy.specs.io.graphics.renderables.colorshifting;

import java.util.List;

/**
 * <b>NetColorShifts</b>
 * <p>
 * This class takes a Stack (technically a {@link List}) of {@link ColorShift}s of various types,
 * and aggregates them into a {@link NetColorShifts} object, which can be used by the shader
 * program to render a {@link soliloquy.specs.io.graphics.renderables.Renderable}.
 *
 * @author felix.t.morgenstern
 * @version 0.0.1
 */
public interface ColorShiftStackAggregator {
    /**
     * @param colorShifts The ColorShiftTypes to aggregate
     * @param timestamp   The timestamp for which to aggregate the ColorShifts
     * @return The NetColorShifts resulting from the provided colorShifts
     * @throws IllegalArgumentException If and only if colorShifts is null, or contains any
     *                                  ColorShiftTypes with invalid values
     */
    NetColorShifts aggregate(List<ColorShift> colorShifts, long timestamp)
            throws IllegalArgumentException;
}
