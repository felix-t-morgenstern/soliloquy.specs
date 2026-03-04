package soliloquy.specs.io.graphics.renderables;

import soliloquy.specs.io.graphics.renderables.providers.ProviderAtTime;

/**
 * <b>PolygonRenderable</b>
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
     * @return Provides the number of times the texture "tiles" across the width of the polygon. E.g., if this provider returns 3f, then the texture will be duplicated three times lengthwise across the polygon.
     */
    ProviderAtTime<Float> getTextureTilesPerWidthProvider();

    /**
     * C.f. {@link #getTextureTilesPerWidthProvider()} for more information
     *
     * @param provider The percentage of the window width for one tile of the provided texture Id
     * @throws IllegalArgumentException If and only if provider is less than or equal to 0
     */
    void setTextureTilesPerWidthProvider(ProviderAtTime<Float> provider) throws IllegalArgumentException;

    /**
     * @return Provides the percentage of texture width by which the texture is pushed to the left. <u>Note</u> that the amount of <i>space on screen</i> by which the texture is pushed to the left depends on how much the texture is scrunched or stretched by {@link #getTextureTilesPerWidthProvider()}. E.g., if this provider returns 0.5f, and the Provider from {@link #getTextureTilesPerWidthProvider()} returns 3f, then the initial texture will be pushed to the left by 1/6 of the polygon's total width, since 1/6 is half (0.5) of the texture width, and one width of the texture takes up one third of the polygon's width.
     */
    ProviderAtTime<Float> getTextureXOffsetProvider();

    /**
     * C.f. {@link #getTextureXOffsetProvider()} for more information
     * @throws IllegalArgumentException If and only if provider is null
     */
    void setTextureXOffsetProvider(ProviderAtTime<Float> provider) throws IllegalArgumentException;

    /**
     * @return Provides the number of times the texture "tiles" across the height of the polygon. E.g., if this provider returns 3f, then the texture will be duplicated three times heightwise across the polygon.
     */
    ProviderAtTime<Float> getTextureTilesPerHeightProvider();

    /**
     * C.f. {@link #getTextureTilesPerHeightProvider()} for more information
     *
     * @param provider The percentage of the window height for one tile of the provided texture Id
     * @throws IllegalArgumentException If and only if provider is less than or equal to 0
     */
    void setTextureTilesPerHeightProvider(ProviderAtTime<Float> provider) throws IllegalArgumentException;

    /**
     * @return Provides the percentage of texture height by which the texture is pushed down. <u>Note</u> that the amount of <i>space on screen</i> by which the texture is pushed down depends on how much the texture is scrunched or stretched by {@link #getTextureTilesPerHeightProvider()}. E.g., if this provider returns 0.5f, and the Provider from {@link #getTextureTilesPerHeightProvider()} returns 3f, then the initial texture will be pushed down by 1/6 of the polygon's total height, since 1/6 is half (0.5) of the texture height, and one height of the texture takes up one third of the polygon's height.
     */
    ProviderAtTime<Float> getTextureYOffsetProvider();

    /**
     * C.f. {@link #getTextureYOffsetProvider()} for more information
     * @throws IllegalArgumentException If and only if provider is null
     */
    void setTextureYOffsetProvider(ProviderAtTime<Float> provider) throws IllegalArgumentException;
}
