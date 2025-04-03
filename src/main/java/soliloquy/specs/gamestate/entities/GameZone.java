package soliloquy.specs.gamestate.entities;

import soliloquy.specs.common.entities.Action;
import soliloquy.specs.common.shared.HasId;
import soliloquy.specs.common.shared.HasName;
import soliloquy.specs.common.valueobjects.Coordinate2d;
import soliloquy.specs.common.valueobjects.Coordinate3d;
import soliloquy.specs.gamestate.entities.shared.HasData;

import java.util.List;
import java.util.Map;
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
     * @return The type of the GameZone (e.g. expansive, local). Can be null or empty.
     */
    String type();

    /**
     * @return The maximum x and y values of Coordinates in the GameZone
     */
    Coordinate2d maxCoordinates();

    /**
     * @param location The Coordinate of the Tile to retrieve
     * @return The Tile at those coordinates
     * @throws IllegalArgumentException If location is null, or beyond the dimensions of the
     *                                  GameZone
     */
    Tile tile(Coordinate2d location) throws IllegalArgumentException;

    /**
     * A north-facing Segment with a location of (0,0) is on the north edge of the Tile at (0,0). A
     * west-facing Segment with a location of (0,0) is on the west edge of the Tile at (0,0). A
     * northwest-facing Segment with a location of (0,0) is in the northwest corner of the Tile at
     * (0,0).
     *
     * @param location The location of the Segments to retrieve
     * @return The 3d locations of the WallSegments adjacent to the given location, and the
     *         corresponding actual WallSegment, for each orientation. The value entries for each
     *         key correspond to a given location and segment, whose orientation is the
     *         corresponding key.
     * @throws IllegalArgumentException If and only if location or direction are null, or if the x
     *                                  or y value of location are below 0, or if location is
     *                                  beyond the {@link #maxCoordinates()}
     */
    Map<WallSegmentDirection, Map<Coordinate3d, WallSegment>> getSegments(Coordinate2d location)
            throws IllegalArgumentException;

    /**
     * @param location    The location at which to set the Segment  ({@link WallSegment#getType()}
     *                    specifies the {@link WallSegmentDirection}). The z vertex is height.
     * @param wallSegment The Segment to set at the location provided. (Can be null)
     * @throws IllegalArgumentException If and only if location or wallSegment are null, or if the
     *                                  x or y value of location are below 0, or if location is
     *                                  beyond the {@link #maxCoordinates()}
     */
    void setSegment(Coordinate3d location, WallSegment wallSegment)
            throws IllegalArgumentException;

    /**
     * @param location  The location at which to remove a Segment. The z vertex is height.
     * @param direction The direction of Segment to remove
     * @return True, if and only if a Segment was present, prior to being removed
     * @throws IllegalArgumentException If and only if location or direction are null, or if the x
     *                                  or y value of location are below 0, or if location is beyond
     *                                  the {@link #maxCoordinates()}
     */
    boolean removeSegment(Coordinate3d location, WallSegmentDirection direction)
            throws IllegalArgumentException;

    /**
     * Removes all WallSegments of a given orientation at a given coordinate. (These are the
     * coordinates of the segments themselves, and not the tiles; c.f. {@link #getSegments} for more
     * info.)
     *
     * @param location  The location at which to remove all Segments
     * @param direction The direction of Segments to remove
     * @throws IllegalArgumentException If and only if location or direction are null, or if the x
     *                                  or y value of location are below 0, or if location is beyond
     *                                  the {@link #maxCoordinates()}
     */
    void removeAllSegments(Coordinate2d location, WallSegmentDirection direction)
            throws IllegalArgumentException;

    /**
     * @return A List of Actions which are fired when the Party enters this GameZone.
     *         <p>
     *         (It is expected that this will be called when GameState.setCurrentGameZone is
     *         called.)
     */
    List<Action> onEntry();

    /**
     * @return A List of Actions which are fired when the Party leaves this GameZone.
     *         <p>
     *         (It is expected that this will be called when GameState.setCurrentGameZone is
     *         called.)
     *         <p>
     *         (Also, this is where Timers which are intended only for this GameZone can be
     *         eliminated.)
     */
    List<Action> onExit();

    /**
     * <i>NB: This method returns a representation of Characters in this GameZone, so altering its
     * contents will not change the characters in this GameZone.</i>
     *
     * @return A Map containing all the Characters in this GameZone, where the key is the id of each
     *         corresponding Character.
     */
    Map<UUID, Character> charactersRepresentation();
}
