package soliloquy.specs.ui;

import soliloquy.specs.common.valueobjects.Coordinate3d;
import soliloquy.specs.common.valueobjects.Vertex;
import soliloquy.specs.gamestate.entities.Character;
import soliloquy.specs.gamestate.entities.GameZone;
import soliloquy.specs.gamestate.entities.Party;
import soliloquy.specs.gamestate.entities.exceptions.EntityDeletedException;
import soliloquy.specs.io.graphics.renderables.Component;
import soliloquy.specs.io.graphics.renderables.ImageAssetRenderable;
import soliloquy.specs.io.graphics.renderables.providers.ProviderAtTime;
import soliloquy.specs.ruleset.gameconcepts.TileVisibilityCalculation;

import java.util.Map;
import java.util.Set;

/**
 * <b>GameZoneView</b>
 * <p>
 * GameZoneView is an UI {@link Component} which displays a
 * {@link soliloquy.specs.gamestate.entities.GameZone}. It describes the location within the
 * GameZone where this view is centered, and the Tiles visible, based on both the Characters and
 * Tile locations providing visibility (c.f. {@link #charactersProvidingVisibility()} &
 * {@link #tileLocationsProvidingVisibility()}.
 *
 * @author felix.t.morgenstern
 * @version 0.0.1
 */
public interface GameZoneView extends Component {
    /**
     * @return The GameZone displayed by this View
     */
    GameZone getGameZone();

    /**
     * @param gameZone The GameZone to assign to this View
     * @throws IllegalArgumentException If and only if gameZone is null
     * @throws EntityDeletedException If and only if gameZone is deleted
     */
    void setGameZone(GameZone gameZone) throws IllegalArgumentException, EntityDeletedException;

    /**
     * @return The location in the GameZone (i.e., a 3d coordinate at which a Tile could be placed)
     *         on which the GameZoneView is centered, with an offset provided by
     *         {@link #tileCenterOffsetProvider}
     */
    Coordinate3d tileLocation();

    /**
     * @param tileLocation The location to assign the GameZoneView
     * @throws IllegalArgumentException If and only if tileLocation is null
     */
    void setTileLocation(Coordinate3d tileLocation) throws IllegalArgumentException;

    /**
     * (This method can obviously be used flexibly; one use case includes a smooth GameZoneView
     * transition
     * in the UI after calling {@link #setTileLocation}
     *
     * @return A Provider of the degree to which the GameZoneView's location in the GameWorld is
     *         offset
     *         from its {@link Coordinate3d} (c.f. {@link #tileLocation}), expressed in percent of
     *         Tile width and height respectively
     */
    ProviderAtTime<Vertex> tileCenterOffsetProvider();

    /**
     * @param provider The Provider of the TileCenterOffset (c.f. {@link #tileCenterOffsetProvider})
     * @throws IllegalArgumentException If and only if provider is null
     */
    void setTileCenterOffsetProvider(ProviderAtTime<Vertex> provider)
            throws IllegalArgumentException;

    /**
     * @return A Provider of the level of zoom, where the value returned represents the number of
     *         Tile widths visible in the view of the GameZone
     */
    ProviderAtTime<Float> zoomProvider() throws IllegalStateException;

    /**
     * By convention, the value provided should fall within the range of [0.0, 1.0] (c.f.
     * {@link #zoomProvider}. A higher value implies a higher amount of zoom. The exact definitions
     * of zoom
     * levels of 0.0 and 1.0 are responsibilities left to implementation.
     *
     * @param zoom The amount of zoom to set, c.f. {@link #zoomProvider()}
     * @throws IllegalArgumentException If and only if zoom is null
     */
    void setZoomProvider(ProviderAtTime<Float> zoom) throws IllegalArgumentException;

    /**
     * @return A mutable collection of Characters who provide visibility to the player
     */
    Set<Character> charactersProvidingVisibility();

    /**
     * The intended use of this Map is to set points of player visibility other than {@link Party}
     * members, e.g., to reveal an area in cutscenes. The keys of the Map are the locations providing
     * visibility to the player, and the corresponding integers are the radii of visibility at those
     * locations. The radii are used in {@link TileVisibilityCalculation#atPoint}.
     *
     * @return A modifiable collection of locations providing visibility to the player
     */
    Map<Coordinate3d, Integer> tileLocationsProvidingVisibility();

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
