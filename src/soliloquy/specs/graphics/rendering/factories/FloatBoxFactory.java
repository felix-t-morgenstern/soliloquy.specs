package soliloquy.specs.graphics.rendering.factories;

import soliloquy.specs.common.shared.SoliloquyClass;
import soliloquy.specs.graphics.rendering.FloatBox;

/**
 * <b>FloatBoxFactory</b>
 * <p>
 * Creates {@link FloatBox}es
 *
 * @author felix.t.morgenstern
 * @version 0.0.1
 *
 */
public interface FloatBoxFactory extends SoliloquyClass {
    /**
     * @param leftX The left edge of the box
     * @param topY The top edge of the box
     * @param rightX The right edge of the box
     * @param bottomY The bottom edge of the box
     * @return The newly-created box
     * @throws IllegalArgumentException If and only if rightX is less than or equal to leftX, or if
     * bottomY is less than or equal to topY
     */
    FloatBox make (float leftX, float topY, float rightX, float bottomY)
            throws IllegalArgumentException;
}
