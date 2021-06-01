package soliloquy.specs.graphics.renderables;

import soliloquy.specs.graphics.renderables.providers.ProviderAtTime;
import soliloquy.specs.graphics.rendering.RenderableStack;

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
public interface RectangleRenderable extends RenderableWithArea, RenderableStack {
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

    /**
     * <i>NB: If this method returns null, that implies that there is no background texture</i>
     * @return The Texture which will be provided as a background for this Rectangle for a given
     * timestamp
     */
    ProviderAtTime<Integer> getBackgroundTextureIdProvider();

    /**
     * C.f. {@link #getBackgroundTextureIdProvider()} for more information
     * @param backgroundTextureIdProvider The background texture Id provider for this Renderable
     * @throws IllegalArgumentException If and only if backgroundTextureIdProvider is null
     */
    void setBackgroundTextureIdProvider(ProviderAtTime<Integer> backgroundTextureIdProvider)
            throws IllegalArgumentException;

    /**
     * @return The width of the texture (c.f. {@link #getBackgroundTextureIdProvider}) acting as a
     * background for this Rectangle. Width is expressed in percentage of window width, where 1f is
     * 100% of the window width.
     */
    float getBackgroundTextureTileWidth();

    /**
     * C.f. {@link #getBackgroundTextureTileWidth()} for more information
     * @param backgroundTextureTileWidth The percentage of the window width for one tile of the
     *                                   provided texture Id
     * @throws IllegalArgumentException If and only if backgroundTextureTileWidth is less than or
     * equal to 0
     */
    void setBackgroundTextureTileWidth(float backgroundTextureTileWidth)
            throws IllegalArgumentException;

    /**
     * @return The height of the texture (c.f. {@link #getBackgroundTextureIdProvider}) acting as a
     * background for this Rectangle. Height is expressed in percentage of window height, where 1f
     * is 100% of the window height.
     */
    float getBackgroundTextureTileHeight();

    /**
     * C.f. {@link #getBackgroundTextureTileHeight()} for more information
     * @param backgroundTextureTileHeight The percentage of the window height for one tile of the
     *                                    provided texture Id
     * @throws IllegalArgumentException If and only if backgroundTextureTileHeight is less than or
     * equal to 0
     */
    void setBackgroundTextureTileHeight(float backgroundTextureTileHeight)
            throws IllegalArgumentException;
}
