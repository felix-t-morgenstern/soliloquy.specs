package soliloquy.specs.ui.gamezone;

import soliloquy.specs.common.valueobjects.Coordinate3d;
import soliloquy.specs.common.valueobjects.Vertex;
import soliloquy.specs.gamestate.entities.Character;
import soliloquy.specs.gamestate.entities.Party;
import soliloquy.specs.io.graphics.renderables.providers.ProviderAtTime;
import soliloquy.specs.ruleset.gameconcepts.TileVisibilityCalculation;

import java.util.Map;
import java.util.Set;

/**
 * <b>Camera</b>
 * <p>
 * Camera is used to describe what the player sees, i.e. the center of their view in the GameWorld,
 * and which Tiles are visible to them.
 * <p>
 * The Camera is fed into the {@link GameZoneView}, which takes
 * snapshots from the Camera, which are then rendered by
 * {@link soliloquy.specs.io.graphics.rendering.renderers.StackRenderer}.
 *
 * @author felix.t.morgenstern
 * @version 0.0.1
 */
public interface Camera {
    /**
     * @return The location in the GameZone (i.e., a 3d coordinate at which a Tile could be placed)
     *         on which the Camera is centered, with an offset provided by
     *         {@link #tileCenterOffset}
     */
    Coordinate3d gameZoneLocation();

    /**
     * @param gameZoneLocation The location to assign the Camera
     * @throws IllegalArgumentException If and only if gameZoneLocation is null
     */
    void setGameZoneLocation(Coordinate3d gameZoneLocation) throws IllegalArgumentException;

    /**
     * (This method can obviously be used flexibly; one use case includes a smooth Camera transition
     * in the UI after calling {@link #setGameZoneLocation}
     *
     * @return The degree to which the Camera's location in the GameWorld is offset from its 3d
     *         coordinate (c.f. {@link #gameZoneLocation}), expressed in percent of Tile width and
     *         height respectively
     */
    Vertex tileCenterOffset();

    /**
     * @param provider The Provider of the TileCenterOffset (c.f. {@link #tileCenterOffset})
     * @throws IllegalArgumentException If and only if provider is null
     */
    void setTileCenterOffsetProvider(ProviderAtTime<Vertex> provider)
            throws IllegalArgumentException;

    /**
     * @return The level of zoom, where the value returned represents the number of tile widths
     *         visible in the view of the GameZone
     * @throws IllegalStateException If and only if the {@link ProviderAtTime} passed into
     *                               {@link #setZoomProvider} returns a value greater than 1.0 or
     *                               less than 0.0
     */
    float zoom() throws IllegalStateException;

    /**
     * By convention, the value provided should fall within the range of [0.0, 1.0] (c.f.
     * {@link #zoom}. A higher value implies a higher amount of zoom. The exact definitions of zoom
     * levels of 0.0 and 1.0 are responsibilities left to implementation.
     *
     * @param zoom The amount of zoom to set, c.f. {@link #zoom()}
     * @throws IllegalArgumentException If and only if zoom is null
     */
    void setZoomProvider(ProviderAtTime<Float> zoom) throws IllegalArgumentException;

    /**
     * @return A mutable collection of Characters who provide visibility to the player
     */
    Set<Character> charactersProvidingVisibility();

    /**
     * The intended use of this Map is to set points of player visibility other than {@link Party}
     * members, e.g. to reveal an area in cutscenes. The keys of the Map are the locations providing
     * visibility to the player, and the corresponding integers are the radii of visibility at those
     * locations. The radii are used in {@link TileVisibilityCalculation#atPoint}.
     *
     * @return A modifiable collection of locations providing visibility to the player
     */
    Map<Coordinate3d, Integer> locationsProvidingVisibility();
}
