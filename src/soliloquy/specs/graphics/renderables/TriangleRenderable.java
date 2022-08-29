package soliloquy.specs.graphics.renderables;

import soliloquy.specs.common.valueobjects.Pair;
import soliloquy.specs.common.valueobjects.Vertex;
import soliloquy.specs.graphics.renderables.providers.ProviderAtTime;

import java.awt.*;

/**
 * <b>TriangleRenderable</b>
 * <p>
 * A triangle which can be rendered in the window
 * <p>
 * <i>NB: When you use both a texture as a tile as well as colors in any of the corners, you will
 * not draw those colors on top of your tile; instead, those colors will act as masks, limiting how
 * much of each of the channels of the underlying tile image will be allowed to pass through. So,
 * if you have a corner that is red, only the red parts of the image will be drawn. If you have a
 * corner that is cyan (i.e. both green and blue), then the green and blue parts of the tile will
 * be allowed to pass through, but not the red. If you want to draw a gradient on top of your tile,
 * you will need to render two triangles.</i>
 *
 * @author felix.t.morgenstern
 * @version 0.0.1
 */
public interface TriangleRenderable extends PolygonRenderable {
    /**
     * @return A ProviderAtTime which provides the location for the first vertex
     */
    ProviderAtTime<Vertex> getVertex1Provider();

    /**
     * @param provider Provides the location of the first vertex at a given timestamp
     * @throws IllegalArgumentException If and only if provider is null
     */
    void setVertex1Provider(ProviderAtTime<Vertex> provider)
            throws IllegalArgumentException;

    /**
     * <i>NB: If this ProviderAtTime returns null, that implies total transparency for this
     * vertex.</i>
     *
     * @return A ProviderAtTime which provides the color at the first vertex
     */
    ProviderAtTime<Color> getVertex1ColorProvider();

    /**
     * C.f. {@link #getVertex1ColorProvider()} for more information
     *
     * @param provider The Color provider for the first vertex
     * @throws IllegalArgumentException If and only if provider is null
     */
    void setVertex1ColorProvider(ProviderAtTime<Color> provider) throws IllegalArgumentException;

    /**
     * @return A ProviderAtTime which provides the location for the second vertex
     */
    ProviderAtTime<Vertex> getVertex2Provider();

    /**
     * @param provider Provides the location of the second vertex at a given timestamp
     * @throws IllegalArgumentException If and only if provider is null
     */
    void setVertex2Provider(ProviderAtTime<Vertex> provider)
            throws IllegalArgumentException;

    /**
     * <i>NB: If this ProviderAtTime returns null, that implies total transparency for this
     * vertex.</i>
     *
     * @return A ProviderAtTime which provides the color at the second vertex
     */
    ProviderAtTime<Color> getVertex2ColorProvider();

    /**
     * C.f. {@link #getVertex1ColorProvider()} for more information
     *
     * @param provider The Color provider for the second vertex
     * @throws IllegalArgumentException If and only if provider is null
     */
    void setVertex2ColorProvider(ProviderAtTime<Color> provider) throws IllegalArgumentException;

    /**
     * @return A ProviderAtTime which provides the location for the third vertex
     */
    ProviderAtTime<Vertex> getVertex3Provider();

    /**
     * @param provider Provides the location of the third vertex at a given timestamp
     * @throws IllegalArgumentException If and only if provider is null
     */
    void setVertex3Provider(ProviderAtTime<Vertex> provider)
            throws IllegalArgumentException;

    /**
     * <i>NB: If this ProviderAtTime returns null, that implies total transparency for this
     * vertex.</i>
     *
     * @return A ProviderAtTime which provides the color at the third vertex
     */
    ProviderAtTime<Color> getVertex3ColorProvider();

    /**
     * C.f. {@link #getVertex1ColorProvider()} for more information
     *
     * @param provider The Color provider for the third vertex
     * @throws IllegalArgumentException If and only if provider is null
     */
    void setVertex3ColorProvider(ProviderAtTime<Color> provider) throws IllegalArgumentException;
}
