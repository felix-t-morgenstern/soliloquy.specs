package soliloquy.specs.graphics.renderables;

import java.awt.*;
import java.util.List;

/**
 * <b>RectangleRenderable</b>
 * <p>
 * A rectangle which can be rendered in the window
 *
 * @author felix.t.morgenstern
 * @version 0.0.1
 *
 */
public interface RectangleRenderable extends RenderableWithArea {
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

    /**
     * NB: All child renderables will be rendered below all renderables above their parent, and all
     * children of those renderables above their parent.
     * @return The renderables which are children of this renderable
     */
    List<Renderable> innerRenderables();

    // TODO: Expose members to define backgrounds, whether those backgrounds are stretched, and whether (and how) those backgrounds are repeated
}
