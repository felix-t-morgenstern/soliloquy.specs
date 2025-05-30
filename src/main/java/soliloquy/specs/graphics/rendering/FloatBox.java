package soliloquy.specs.graphics.rendering;

/**
 * <b>FloatBox</b>
 * <p>
 * An object which represents some area in the window, where the horizontal and vertical limits of
 * the window are [-1.0,1.0]. (Bounding boxes which extend beyond the window's limits are not
 * illegal, but if none of a {@link soliloquy.specs.graphics.renderables.Renderable}'s bounding box
 * is within the window, it may not be rendered.)
 * <p>
 * (NB: FloatBoxes are immutable, making it safe to pass them around freely.)
 *
 * @author felix.t.morgenstern
 * @version 0.0.1
 */
public interface FloatBox {
    /**
     * @return The left edge of this box
     */
    float leftX();

    /**
     * @return The top edge of this box
     */
    float topY();

    /**
     * @return The right edge of this box
     */
    float rightX();

    /**
     * @return The bottom edge of this box
     */
    float bottomY();

    /**
     * @return The width of this box
     */
    float width();

    /**
     * @return The height of this box
     */
    float height();

    /**
     * <i>NB: If there is no intersection, this method returns null.</i>
     *
     * @param box The box to intersect with this box
     * @return The intersection (i.e. overlap) with this box; if no overlap, returns null
     * @throws IllegalArgumentException If and only if box is null
     */
    FloatBox intersection(FloatBox box) throws IllegalArgumentException;

    /**
     * @param xTranslation The amount by which to move the copy of this FloatBox along the x-axis
     * @param yTranslation The amount by which to move the copy of this FloatBox along the y-axis
     * @return A copy of this FloatBox, moved by some amount on either the x or y axes
     */
    FloatBox translate(float xTranslation, float yTranslation);
}
