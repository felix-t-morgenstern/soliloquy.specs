package soliloquy.specs.graphics.renderables;

import soliloquy.specs.graphics.renderables.providers.ProviderAtTime;

/**
 * <b>TriangleRenderable</b>
 * <p>
 * A polygon which can be rendered in the window, c.f. {@link TriangleRenderable} or
 * {@link RectangleRenderable}
 *
 * @author felix.t.morgenstern
 * @version 0.0.1
 */
public interface PolygonRenderable extends RenderableWithMouseEvents {
    /**
     * <i>NB: If this method returns null, that implies that there is no background texture</i>
     *
     * @return The Texture which will be provided as a background for this polygon for a given
     *         timestamp
     */
    ProviderAtTime<Integer> getBackgroundTextureIdProvider();

    /**
     * C.f. {@link #getBackgroundTextureIdProvider()} for more information
     *
     * @param backgroundTextureIdProvider The background texture Id provider for this Renderable
     * @throws IllegalArgumentException If and only if backgroundTextureIdProvider is null
     */
    void setBackgroundTextureIdProvider(ProviderAtTime<Integer> backgroundTextureIdProvider)
            throws IllegalArgumentException;

    /**
     * @return The width of the texture (c.f. {@link #getBackgroundTextureIdProvider}) acting as a
     *         background for this polygon. Width is expressed in percentage of window width, where
     *         1f is
     *         100% of the window width.
     */
    float getBackgroundTextureTileWidth();

    /**
     * C.f. {@link #getBackgroundTextureTileWidth()} for more information
     *
     * @param backgroundTextureTileWidth The percentage of the window width for one tile of the
     *                                   provided texture Id
     * @throws IllegalArgumentException If and only if backgroundTextureTileWidth is less than or
     *                                  equal to 0
     */
    void setBackgroundTextureTileWidth(float backgroundTextureTileWidth)
            throws IllegalArgumentException;

    /**
     * @return The height of the texture (c.f. {@link #getBackgroundTextureIdProvider}) acting as a
     *         background for this polygon. Height is expressed in percentage of window height,
     *         where 1f
     *         is 100% of the window height.
     */
    float getBackgroundTextureTileHeight();

    /**
     * C.f. {@link #getBackgroundTextureTileHeight()} for more information
     *
     * @param backgroundTextureTileHeight The percentage of the window height for one tile of the
     *                                    provided texture Id
     * @throws IllegalArgumentException If and only if backgroundTextureTileHeight is less than or
     *                                  equal to 0
     */
    void setBackgroundTextureTileHeight(float backgroundTextureTileHeight)
            throws IllegalArgumentException;
}
