package soliloquy.specs.ruleset.entities;

import soliloquy.specs.common.infrastructure.List;
import soliloquy.specs.graphics.colorshifting.ColorShift;

/**
 * <b>HasDefaultColorShifts</b>
 * <p>
 * Entities of this type have default color shifts. (These cannot be changed by individual entities
 * of these types, but those entities can define custom color shifts which override these default
 * color shifts.)
 *
 * @author felix.t.morgenstern
 * @version 0.0.1
 *
 */
public interface HasDefaultColorShifts {
    /**
     * @return The default color shifts for this type
     */
    List<ColorShift> defaultColorShifts();
}
