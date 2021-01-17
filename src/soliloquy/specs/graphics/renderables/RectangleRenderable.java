package soliloquy.specs.graphics.renderables;

import java.awt.*;

/**
 * <b>RectangleRenderable</b>
 * <p>
 * A rectangle which can be rendered in the window
 *
 * @author felix.t.morgenstern
 * @version 0.0.1
 *
 */
public interface RectangleRenderable extends RenderableType {
    /**
     * @return The left x pixel (inclusive) of this rectangle
     */
    int leftX();

    /**
     * @return The top y pixel (inclusive) of this rectangle
     */
    int topY();

    /**
     * @return The right x pixel (inclusive) of this rectangle
     */
    int rightX();

    /**
     * @return The bottom y pixel (inclusive) of this rectangle
     */
    int bottomY();

    /**
     * @return The color at the top left of this rectangle
     */
    Color topLeftColor();

    /**
     * @return The color at the top right of this rectangle
     */
    Color topRightColor();

    /**
     * @return The color at the bottom right of this rectangle
     */
    Color bottomRightColor();

    /**
     * @return The color at the bottom left of this rectangle
     */
    Color bottomLeftColor();
}
