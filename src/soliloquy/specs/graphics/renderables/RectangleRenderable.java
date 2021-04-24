package soliloquy.specs.graphics.renderables;

import soliloquy.specs.graphics.renderables.providers.ProviderAtTime;
import soliloquy.specs.graphics.rendering.RenderableStack;

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
public interface RectangleRenderable extends RenderableWithArea, RenderableStack {
    /**
     * @return A ProviderAtTime which provides the color at the top-left of this rectangle for a
     * given timestamp.
     */
    ProviderAtTime<Color> topLeftColorProvider();
    /**
     * @return A ProviderAtTime which provides the color at the top-right of this rectangle for a
     * given timestamp.
     */
    ProviderAtTime<Color> topRightColorProvider();
    /**
     * @return A ProviderAtTime which provides the color at the bottom-right of this rectangle for
     * a given timestamp.
     */
    ProviderAtTime<Color> bottomRightColorProvider();
    /**
     * @return A ProviderAtTime which provides the color at the bottom-left of this rectangle for a
     * given timestamp.
     */
    ProviderAtTime<Color> bottomLeftColorProvider();

    // TODO: Expose members to define backgrounds, whether those backgrounds are stretched, and whether (and how) those backgrounds are repeated
}
