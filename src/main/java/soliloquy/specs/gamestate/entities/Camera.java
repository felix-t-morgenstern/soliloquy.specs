package soliloquy.specs.gamestate.entities;

import soliloquy.specs.common.valueobjects.Coordinate2d;
import soliloquy.specs.common.valueobjects.Vertex;
import soliloquy.specs.graphics.renderables.providers.ProviderAtTime;
import soliloquy.specs.ruleset.gameconcepts.TileVisibilityCalculation;

import java.util.Map;
import java.util.Set;

/**
 * <b>Camera</b>
 * <p>
 * Camera is used to describe what the player sees, i.e. the center of their view in the GameWorld,
 * and which Tiles are rendered.
 * <p>
 * The Camera is fed into the {@link soliloquy.specs.ui.windowelements.GameWorldView}, which takes
 * snapshots from the Camera, which are then rendered by StackRenderer.
 *
 * @author felix.t.morgenstern
 * @version 0.0.1
 */
public interface Camera {
    /**
     * @return The location of the Tile on which the Camera is centered, with an offset provided by
     *         {@link #getTileCenterOffsetProvider}
     */
    Coordinate2d getTileLocation();

    /**
     * <i>NB: tileLocation can be outside of the bounds of the current GameZone; this is equivalent
     * to the Camera moving out of the range of all visible Tiles.</i>
     *
     * @param tileLocation The Tile on which the Camera is located
     * @throws IllegalArgumentException If and only if tileLocation is null
     */
    void setTileLocation(Coordinate2d tileLocation) throws IllegalArgumentException;

    /**
     * @return A Provider, providing a Vertex representing the offset of the Camera from the center
     *         of the Tile in question. The x value of the Vertex represents how much the Camera is
     *         adjusted to the right of the Tile center, where 1.0 represents a whole Tile width.
     *         Similarly, the y value of the Vertex represents the offset from the Tile center,
     *         where a value of 1.0 represents a whole tile height.
     */
    ProviderAtTime<Vertex> getTileCenterOffsetProvider();

    /**
     * @param provider The Provider of the TileCenterOffset (c.f.
     *                 {@link #getTileCenterOffsetProvider})
     * @throws IllegalArgumentException If and only if provider is null
     */
    void setTileCenterOffsetProvider(ProviderAtTime<Vertex> provider)
            throws IllegalArgumentException;

    /**
     * @return The level of zoom, where the value returned represents the number of tile widths
     *         visible in the view of the GameZone
     */
    float getZoom();

    /**
     * @param zoom The amount of zoom to set, c.f. {@link #getZoom()}
     * @throws IllegalArgumentException If and only if zoom is less than or equal to 0.0
     */
    void setZoom(float zoom) throws IllegalArgumentException;

    /**
     * Intended use for this method is to return Characters through whom the player sees the game
     * world; generally the Party, and perhaps also some allies in certain instances.
     *
     * @return A collection of Characters who provide visibility to the player
     */
    Set<Character> charactersProvidingVisibility();

    /**
     * The intended use of this Map is to set points of player visibility other than {@link Party}
     * members, e.g. to reveal an area in cutscenes. The keys of the Map are the locations providing
     * visibility to the player, and the corresponding integers are the radii of visibility at those
     * locations. The radii are used in
     * {@link TileVisibilityCalculation#atPoint}.
     *
     * @return A modifiable collection of locations providing visibility to the player
     */
    Map<Coordinate2d, Integer> locationsProvidingVisibility();
}
