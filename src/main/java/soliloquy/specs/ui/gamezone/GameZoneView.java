package soliloquy.specs.ui.gamezone;

import soliloquy.specs.common.valueobjects.Coordinate3d;
import soliloquy.specs.common.valueobjects.Vertex;
import soliloquy.specs.gamestate.entities.Tile;
import soliloquy.specs.gamestate.entities.WallSegment;
import soliloquy.specs.io.graphics.renderables.ImageAssetRenderable;
import soliloquy.specs.io.graphics.renderables.providers.ProviderAtTime;

import java.util.Map;
import java.util.Set;

// NB: This is a trash interface
//TODO: Document this interface
public interface GameZoneView {
    /**
     * To set the GameWorldView to take up the entire screen, use {@link #setLocationProvider} to
     * assign a {@link soliloquy.specs.io.graphics.renderables.providers.StaticProvider} which
     * always returns (0.0,0.0).
     *
     * @return A
     */
    Vertex location();

    /**
     * @param locationProvider Provides the location at a given timestamp
     * @throws IllegalArgumentException If and only if locationProvider is null
     */
    void setLocationProvider(ProviderAtTime<Vertex> locationProvider)
            throws IllegalArgumentException;

    /**
     * To set the GameWorldView to take up the entire screen, use {@link #setDimensionsProvider} to
     * assign a {@link soliloquy.specs.io.graphics.renderables.providers.StaticProvider} which
     * always returns (0.0,0.0).
     *
     * @return The dimensions of the GameWorldView, expressing percent of screen width and height
     *         respectively
     */
    Vertex dimensionsProvider();

    /**
     * @param dimensionsProvider Provides the dimensions at a given timestamp
     * @throws IllegalArgumentException If and only if dimensionsProvider is null
     */
    void setDimensionsProvider(ProviderAtTime<Vertex> dimensionsProvider)
            throws IllegalArgumentException;

    /**
     * @return A mutable Set of visible Tiles
     */
    Set<Tile> visibleTiles();

    /**
     * @return A mutable Set of visible WallSegments
     */
    Set<WallSegment> visibleSegments();

    /**
     * @return A mutable Set of the ImageAssetRenderables (i.e.,
     *         {@link soliloquy.specs.io.graphics.renderables.SpriteRenderable},
     *         {@link soliloquy.specs.io.graphics.renderables.ImageAssetSetRenderable},
     *         {@link soliloquy.specs.io.graphics.renderables.FiniteAnimationRenderable}, or
     *         {@link soliloquy.specs.io.graphics.renderables.GlobalLoopingAnimationRenderable})
     *         present on the GameZoneView itself, and not one of its Tiles
     */
    Set<ImageAssetRenderable> imageAssetRenderables();
}
