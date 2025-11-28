package soliloquy.specs.gamestate.entities;

import soliloquy.specs.common.entities.Consumer;
import soliloquy.specs.common.shared.HasId;
import soliloquy.specs.common.shared.HasName;
import soliloquy.specs.common.valueobjects.Coordinate2d;
import soliloquy.specs.common.valueobjects.Coordinate3d;
import soliloquy.specs.gamestate.entities.exceptions.EntityDeletedException;
import soliloquy.specs.gamestate.entities.shared.HasData;

import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.UUID;

/**
 * <b>GameZone</b>
 * <p>
 * A GameZone is a set of Tiles in two-dimensional space where gameplay takes place. (Like a
 * castle, or a dungeon, or a forest.)
 * <p>
 * A GameZone has a type, a size, Tiles, Characters, Items, and Actions which are executed when
 * entering and leaving the GameZone.
 *
 * @author felix.t.morgenstern
 * @version 0.0.1
 */
public interface GameZone extends HasName, HasId, HasData, Deletable {
    /**
     * @return The maximum x and y values of Coordinates in the GameZone
     */
    Coordinate2d maxCoordinates() throws EntityDeletedException;

    /**
     * This method is used when you know the z-index of the Tile you want to retrieve. If you don't
     * know which z-index a Tile is at, use the method which accepts a Coordinate2d.
     *
     * @param location The Coordinate of the Tile to retrieve
     * @return The Tile at those coordinates, null if no Tile is present
     * @throws IllegalArgumentException If and only if location is null, or beyond the dimensions of
     *                                  the
     *                                  GameZone
     */
    Tile tile(Coordinate3d location) throws IllegalArgumentException, EntityDeletedException;

    /**
     * @return All Tiles in this GameZone
     */
    Set<Tile> tiles() throws EntityDeletedException;

    /**
     * This method will return all Tiles at a location, regardless of z-indices. If you only want to
     * return a single Tile and know its z-index, use the method which accepts at Coordinate3d.
     *
     * @param location The Coordinate of the Tiles to retrieve
     * @return The Tiles at those coordinates, null if no Tiles are present
     * @throws IllegalArgumentException If and only if location is null, or beyond the dimensions of
     *                                  the
     *                                  GameZone
     */
    Set<Tile> tiles(Coordinate2d location) throws IllegalArgumentException, EntityDeletedException;

    /**
     * When this method places a Tile on a location which already has a Tile, it does not transport
     * any {@link TileEntity}s from the previous Tile to the new one.
     *
     * @param tile     The tile to place at the location
     * @param location The location at which to place tile
     * @return The tile which had previously been present at the location, null if none was present
     * @throws IllegalArgumentException If and only if tile is null, tile is already present in the
     *                                  GameZone, or location is null or beyond the dimensions of
     *                                  the GameZone
     */
    Tile putTile(Tile tile, Coordinate3d location)
            throws IllegalArgumentException, EntityDeletedException;

    /**
     * @param location The location of the Tile to remove
     * @return The Tile removed from the location, null if none was present
     * @throws IllegalArgumentException If and only if location is null or beyond the dimensions of
     *                                  the GameZone
     */
    Tile removeTile(Coordinate3d location) throws IllegalArgumentException, EntityDeletedException;

    /**
     * @param location The location of the Tiles to remove
     * @return The Tiles removed from the location, empty Set if none were present
     * @throws IllegalArgumentException If and only if location is null or beyond the dimensions of
     *                                  the GameZone
     */
    Set<Tile> removeTiles(Coordinate2d location)
            throws IllegalArgumentException, EntityDeletedException;

    /**
     * @param location    The location at which to retrieve the segments
     * @param orientation The orientation of segments to retrieve
     */
    Set<WallSegment> segments(Coordinate2d location, WallSegmentOrientation orientation)
            throws IllegalArgumentException;

    /**
     * This method returns the 3d locations of the WallSegments adjacent to the given <b>Tile
     * location</b> on <b>all sides</b> of that Tile. To get WallSegments at a Segment location with
     * a specific orientation, c.f. {@link #segments(Coordinate2d, WallSegmentOrientation)}
     *
     * @param tileLocation The Tile location of the Segments to retrieve
     * @return The 3d locations and the corresponding WallSegments, for each orientation. The value
     *         entries for each key correspond to a given location and segment, whose orientation is
     *         the corresponding key. A non-null value will be present for all three orientations.
     * @throws IllegalArgumentException If and only if location or orientation are null, or if the x
     *                                  or y value of location are below 0, or if location is beyond
     *                                  the {@link #maxCoordinates()}
     */
    Map<WallSegmentOrientation, Map<Coordinate3d, WallSegment>> segments(Coordinate2d tileLocation)
            throws IllegalArgumentException, EntityDeletedException;

    /**
     * @param orientation The orientation of Segment to return
     * @param location    The location of the Segment to return (nb, [0,0] refers to the furthest
     *                    northwest segments in the GameZone)
     * @return The segment at the location, null if none exists
     * @throws IllegalArgumentException If and only if location or orientation are null, or if the x
     *                                  or y value of location are below 0, or if location is beyond
     *                                  the {@link #maxCoordinates()}
     */
    WallSegment segment(WallSegmentOrientation orientation, Coordinate3d location)
            throws IllegalArgumentException, EntityDeletedException;

    /**
     * @param location    The location at which to set the Segment  ({@link WallSegment#getType()}
     *                    specifies the {@link WallSegmentOrientation}). The z vertex is height.
     * @param wallSegment The Segment to set at the location provided. (Can be null)
     * @return The previous WallSegment here, if one was present
     * @throws IllegalArgumentException If and only if location or wallSegment are null, or if the
     *                                  x or y value of location are below 0, or if location is
     *                                  beyond the {@link #maxCoordinates()}
     */
    WallSegment putSegment(Coordinate3d location, WallSegment wallSegment)
            throws IllegalArgumentException, EntityDeletedException;

    /**
     * @param location    The location at which to remove a Segment. The z vertex is height.
     * @param orientation The orientation of Segment to remove
     * @return The WallSegment removed, if one was present
     * @throws IllegalArgumentException If and only if location or orientation are null, or if the x
     *                                  or y value of location are below 0, or if location is beyond
     *                                  the {@link #maxCoordinates()}
     */
    WallSegment removeSegment(Coordinate3d location, WallSegmentOrientation orientation)
            throws IllegalArgumentException, EntityDeletedException;

    /**
     * Removes all WallSegments of a given orientation at a given coordinate. (These are the
     * coordinates of the segments themselves, and not the tiles; c.f. {@link #segments} for more
     * info.)
     *
     * @param location    The location at which to remove all Segments
     * @param orientation The orientation of Segments to remove
     * @throws IllegalArgumentException If and only if location or orientation are null, or if the x
     *                                  or y value of location are below 0, or if location is beyond
     *                                  the {@link #maxCoordinates()}
     */
    void removeAllSegments(Coordinate2d location, WallSegmentOrientation orientation)
            throws IllegalArgumentException, EntityDeletedException;

    /**
     * It is expected that this will be called when {@link GameZoneRepo#loadGameZone} is
     * called. Also, this is where Timers which are intended only for this GameZone can be
     * eliminated.
     *
     * @return A List of Actions which are fired when the Party enters this GameZone.
     */
    @SuppressWarnings("rawtypes")
    List<Consumer> onEntry();

    /**
     * It is expected that this will be called when {@link GameZoneRepo#loadGameZone} is
     * called. Also, this is where Timers which are intended only for this GameZone can be
     * eliminated.
     *
     * @return A List of Actions which are fired when the Party leaves this GameZone.
     */
    @SuppressWarnings("rawtypes")
    List<Consumer> onExit();

    /**
     * <i>NB: This method returns a representation of Characters in this GameZone, so altering its
     * contents will not change the characters in this GameZone.</i>
     *
     * @return A Map containing all the Characters in this GameZone, where the key is the id of each
     *         corresponding Character.
     */
    Map<UUID, Character> charactersRepresentation();
}
