package soliloquy.specs.graphics.renderables;

import soliloquy.specs.graphics.assets.ImageAsset;
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
     * <i>NB: If this ProviderAtTime returns null, that implies total transparency for this
     * corner.</i>
     * @return A ProviderAtTime which provides the color at the top-left of this rectangle for a
     * given timestamp.
     */
    ProviderAtTime<Color> topLeftColorProvider();
    /**
     * <i>NB: If this ProviderAtTime returns null, that implies total transparency for this
     * corner.</i>
     * @return A ProviderAtTime which provides the color at the top-right of this rectangle for a
     * given timestamp.
     */
    ProviderAtTime<Color> topRightColorProvider();
    /**
     * <i>NB: If this ProviderAtTime returns null, that implies total transparency for this
     * corner.</i>
     * @return A ProviderAtTime which provides the color at the bottom-right of this rectangle for
     * a given timestamp.
     */
    ProviderAtTime<Color> bottomRightColorProvider();
    /**
     * <i>NB: If this ProviderAtTime returns null, that implies total transparency for this
     * corner.</i>
     * @return A ProviderAtTime which provides the color at the bottom-left of this rectangle for a
     * given timestamp.
     */
    ProviderAtTime<Color> bottomLeftColorProvider();

    /**
     * <i>NB: If this method returns null, that implies that there is no background texture</i>
     * @return The Texture which will be provided as a background for this Rectangle for a given
     * timestamp
     */
    ProviderAtTime<Integer> backgroundTextureIdProvider();

    /**
     * @return The width of the texture (c.f. {@link #backgroundTextureIdProvider}) acting as a
     * background for this Rectangle. Width is expressed in percentage of window width, where 1f is
     * 100% of the window width.
     */
    float backgroundTextureTileWidth();

    /**
     * @return The height of the texture (c.f. {@link #backgroundTextureIdProvider}) acting as a
     * background for this Rectangle. Height is expressed in percentage of window height, where 1f
     * is 100% of the window height.
     */
    float backgroundTextureTileHeight();
}
