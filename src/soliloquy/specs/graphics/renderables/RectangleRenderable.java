package soliloquy.specs.graphics.renderables;

import soliloquy.specs.graphics.renderables.providers.ProviderAtTime;

import java.awt.*;

/**
 * <b>RectangleRenderable</b>
 * <p>
 * A rectangle which can be rendered in the window
 * <p>
 * <i>NB: When you use both a texture as a tile as well as colors in any of the corners, you will
 * not draw those colors on top of your tile; instead, those colors will act as masks, limiting how
 * much of each of the channels of the underlying tile image will be allowed to pass through. So,
 * if you have a corner that is red, only the red parts of the image will be drawn. If you have a
 * corner that is cyan (i.e. both green and blue), then the green and blue parts of the tile will
 * be allowed to pass through, but not the red. If you want to draw a gradient on top of your tile,
 * you will need to render two rectangles.</i>
 *
 * @author felix.t.morgenstern
 * @version 0.0.1
 *
 */
public interface RectangleRenderable extends PolygonRenderable, RenderableWithDimensions {
    /**
     * <i>NB: If this ProviderAtTime returns null, that implies total transparency for this
     * corner.</i>
     * @return A ProviderAtTime which provides the color at the top-left of this rectangle for a
     * given timestamp.
     */
    ProviderAtTime<Color> getTopLeftColorProvider();

    /**
     * C.f. {@link #getTopLeftColorProvider()} for more information
     * @param topLeftColorProvider The top-left Color provider for this Renderable
     * @throws IllegalArgumentException If and only if topLeftColorProvider is null
     */
    void setTopLeftColorProvider(ProviderAtTime<Color> topLeftColorProvider)
            throws IllegalArgumentException;

    /**
     * <i>NB: If this ProviderAtTime returns null, that implies total transparency for this
     * corner.</i>
     * @return A ProviderAtTime which provides the color at the top-right of this rectangle for a
     * given timestamp.
     */
    ProviderAtTime<Color> getTopRightColorProvider();

    /**
     * C.f. {@link #getTopRightColorProvider()} for more information
     * @param topRightColorProvider The top-right Color provider for this Renderable
     * @throws IllegalArgumentException If and only if topRightColorProvider is null
     */
    void setTopRightColorProvider(ProviderAtTime<Color> topRightColorProvider)
            throws IllegalArgumentException;

    /**
     * <i>NB: If this ProviderAtTime returns null, that implies total transparency for this
     * corner.</i>
     * @return A ProviderAtTime which provides the color at the bottom-right of this rectangle for
     * a given timestamp.
     */
    ProviderAtTime<Color> getBottomRightColorProvider();

    /**
     * C.f. {@link #getBottomRightColorProvider()} for more information
     * @param bottomRightColorProvider The bottom-right Color provider for this Renderable
     * @throws IllegalArgumentException If and only if bottomRightColorProvider is null
     */
    void setBottomRightColorProvider(ProviderAtTime<Color> bottomRightColorProvider)
            throws IllegalArgumentException;

    /**
     * <i>NB: If this ProviderAtTime returns null, that implies total transparency for this
     * corner.</i>
     * @return A ProviderAtTime which provides the color at the bottom-left of this rectangle for a
     * given timestamp.
     */
    ProviderAtTime<Color> getBottomLeftColorProvider();

    /**
     * C.f. {@link #getBottomLeftColorProvider()} for more information
     * @param bottomLeftColorProvider The bottom-left Color provider for this Renderable
     * @throws IllegalArgumentException If and only if bottomLeftColorProvider is null
     */
    void setBottomLeftColorProvider(ProviderAtTime<Color> bottomLeftColorProvider)
            throws IllegalArgumentException;
}
