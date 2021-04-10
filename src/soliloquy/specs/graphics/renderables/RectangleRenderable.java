package soliloquy.specs.graphics.renderables;

import soliloquy.specs.graphics.rendering.ContainsRenderables;

import java.awt.Color;

/**
 * <b>RectangleRenderable</b>
 * <p>
 * A rectangle which can be rendered in the window
 *
 * @author felix.t.morgenstern
 * @version 0.0.1
 *
 */
public interface RectangleRenderable
        extends RenderableWithArea<RectangleRenderable>, ContainsRenderables {
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

    // TODO: Expose members to define backgrounds, whether those backgrounds are stretched, and whether (and how) those backgrounds are repeated
}
