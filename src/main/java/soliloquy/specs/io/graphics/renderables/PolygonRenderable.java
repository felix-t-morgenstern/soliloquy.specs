package soliloquy.specs.io.graphics.renderables;

import soliloquy.specs.io.graphics.renderables.providers.ProviderAtTime;

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
    ProviderAtTime<Integer> getTextureIdProvider();

    /**
     * C.f. {@link #getTextureIdProvider()} for more information
     *
     * @param textureIdProvider The background texture Id provider for this Renderable
     * @throws IllegalArgumentException If and only if textureIdProvider is null
     */
    void setTextureIdProvider(ProviderAtTime<Integer> textureIdProvider)
            throws IllegalArgumentException;

    /**
     * @return The width of the texture (c.f. {@link #getTextureIdProvider}) acting as a background
     *         for this polygon. Width is expressed in percentage of window width, where 1f is 100%
     *         of the window width.
     */
    float getTextureTileWidth();

    /**
     * C.f. {@link #getTextureTileWidth()} for more information
     *
     * @param backgroundTextureTileWidth The percentage of the window width for one tile of the
     *                                   provided texture Id
     * @throws IllegalArgumentException If and only if backgroundTextureTileWidth is less than or
     *                                  equal to 0
     */
    void setTextureTileWidth(float backgroundTextureTileWidth) throws IllegalArgumentException;

    /**
     * @return The height of the texture (c.f. {@link #getTextureIdProvider}) acting as a background
     *         for this polygon. Height is expressed in percentage of window height, where 1f is
     *         100% of the window height.
     */
    float getTextureTileHeight();

    /**
     * C.f. {@link #getTextureTileHeight()} for more information
     *
     * @param backgroundTextureTileHeight The percentage of the window height for one tile of the
     *                                    provided texture Id
     * @throws IllegalArgumentException If and only if backgroundTextureTileHeight is less than or
     *                                  equal to 0
     */
    void setTextureTileHeight(float backgroundTextureTileHeight) throws IllegalArgumentException;
}
