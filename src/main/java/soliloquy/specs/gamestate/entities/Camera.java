package soliloquy.specs.gamestate.entities;

import soliloquy.specs.common.shared.SoliloquyClass;
import soliloquy.specs.common.valueobjects.Coordinate;
import soliloquy.specs.common.valueobjects.Vertex;
import soliloquy.specs.graphics.renderables.providers.ProviderAtTime;
import soliloquy.specs.ruleset.gameconcepts.TileVisibility;

import java.util.List;
import java.util.Map;

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
public interface Camera extends SoliloquyClass {
    /**
     * NB: This Coordinate is a representation of the TileLocation; changing its values will not
     * change the Camera's TileLocation
     *
     * @return The Tile on which the Camera is centered
     */
    Coordinate getTileLocation();

    /**
     * <i>NB: x and y can be outside of the bounds of the current GameZone; this is equivalent to
     * the Camera moving out of the range of all visible Tiles.</i>
     *
     * @param tileLocation The Tile on which the Camera is located
     * @throws IllegalArgumentException If and only if tileLocation is null
     */
    void setTileLocation(Coordinate tileLocation) throws IllegalArgumentException;

    /**
     * @return A Provider, providing a Vertex representing the offset of the Camera from the center
     *         of the Tile in question. The x value of the Vertex represents how much the Camera is
     *         adjusted to the right of the Tile center, where 1.0 represents a whole Tile width.
     *         Similarly, the y value of the Vertex represents the offset from the Tile center,
     *         where a value of 1.0 represents a whole tile height.
     */
    ProviderAtTime<Vertex> tileCenterOffsetProvider();

    /**
     *
     */
    void setTileCenterOffsetProvider(ProviderAtTime<Vertex> tileCenterOffsetProvider)
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
     * This method does not return how many Tiles away a given Character can see; instead, it
     * returns how many Tiles away from the center of the Camera can be rendered by the Camera
     * itself. For example, the Party might be highly spread out, giving Visibility over many
     * Tiles, but if the Camera is set to have a TileRenderingRadius of 7, the Camera will only
     * check tiles within 7 of its TileLocation to see whether they are visible. (This also limits
     * how many Tiles will be displayed when AllTilesVisible is set to true.)
     * <p>
     * <i>NB: The radius includes the TileLocation. So, a TileRenderingRadius of 0 implies that no
     * Tiles will be rendered; a TileRenderingRadius of 1 implies that only the TileLocation will
     * be rendered; a TileRenderingRadius of 2 implies that the TileLocation and all immediately
     * surrounding Tiles will be rendered, and so on.</i>
     *
     * @return The radius around the TileLocation for which Tiles will be rendered (if they are
     *         visible)
     */
    int getTileRenderingRadius();

    /**
     * For more detailed explanation regarding the meaning of "TileRenderingRadius", see
     * {@link #getTileRenderingRadius}.
     *
     * @param tileRenderingRadius The radius around the TileLocation for which Tiles will be
     *                            rendered (if they are visible)
     * @throws IllegalArgumentException If and only if tileRenderingRadius is negative
     */
    void setTileRenderingRadius(int tileRenderingRadius) throws IllegalArgumentException;

    /**
     * @return Whether all Tiles are visible to this Camera
     */
    boolean getAllTilesVisible();

    /**
     * @param allTilesVisible Sets whether the Camera should treat all Tiles as visible
     */
    void setAllTilesVisible(boolean allTilesVisible);

    /**
     * Intended use for this method is to return Characters through whom the player sees the game
     * world; generally the Party, and perhaps also some allies in certain instances.
     * <p>
     * This method does <i>not</i> return how many Tiles a Character can "see" when determining
     * their behavior in-game; {@link Character#getAIType} and {@link Character#data} are
     * intended to handle this sort of functionality instead.
     * <p>
     * The value returned by this method includes the Tile on which this Character is standing. For
     * instance, if this method returns 0, then this Character cannot "see" any Tiles. If this
     * method returns 1, then this Character can only "see" the Tile on which they stand. If this
     * method returns 2, then this Character can only "see" the Tile on which they stand, and all
     * immediately neighboring Tiles.
     *
     * @return A collection of Characters who provide visibility to the player
     */
    Map<Character, Integer> charactersProvidingVisibility();

    /**
     * The intended use of this Map is to have each key specify a Coordinate for which there is
     * visibility, and each Integer specify the radius around that Coordinate to which that
     * visibility extends. The visibility radius for these Coordinates would include the Coordinate
     * itself, similarly to how the radius value behaves in {@link #getTileRenderingRadius}.
     *
     * @return A collection of Coordinates which provide visibility to the player.
     */
    Map<Coordinate, Integer> coordinatesProvidingVisibility();

    /**
     * This function sets visibilityPoints to return the Coordinates of Tiles which are visible to
     * Characters controlled by the player (as specified by
     * {@link TileVisibility}).
     *
     * @throws IllegalStateException If and only if TileVisibility is null
     */
    void calculateVisibleTiles() throws IllegalStateException;

    /**
     * These are the Coordinates of the Tiles currently visible to the player. (These may be
     * changed manually, e.g. in cutscenes.)
     *
     * @return A collection of the Tiles which are currently visible to the player
     */
    List<Coordinate> visibleTiles();
}
