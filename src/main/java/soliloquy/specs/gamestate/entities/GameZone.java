package soliloquy.specs.gamestate.entities;

import soliloquy.specs.common.entities.Action;
import soliloquy.specs.common.shared.HasId;
import soliloquy.specs.common.shared.HasName;
import soliloquy.specs.common.valueobjects.Coordinate;

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
    Coordinate maxCoordinates();

    /**
     * @param location The Coordinate of the Tile to retrieve
     * @return The Tile at those coordinates
     * @throws IllegalArgumentException If location is null, or beyond the dimensions of the
     *                                  GameZone
     */
    Tile tile(Coordinate location) throws IllegalArgumentException;

    /**
     * A north-facing Segment with a location of (0,0) is on the north edge of the Tile at (0,0). A
     * west-facing Segment with a location of (0,0) is on the west edge of the Tile at (0,0). A
     * northwest-facing Segment with a location of (0,0) is in the northwest corner of the Tile at
     * (0,0).
     *
     * @param location  The location of the Segments to retrieve
     * @param direction The direction of Segments to retrieve at the location
     * @return The Segments facing the specified direction at the specified location. The indexes of
     *         the Map returned correspond to the z indices of the respective Segments.
     * @throws IllegalArgumentException If and only if location or direction are null, or if the x
     *                                  or y value of location are below 0, or if location is
     *                                  beyond the {@link #maxCoordinates()}
     */
    Map<Integer, WallSegment> getSegments(Coordinate location,
                                          WallSegmentDirection direction)
            throws IllegalArgumentException;

    /**
     * @param location    The location at which to set the Segment  ({@link WallSegment#getType()}
     *                    specifies the {@link WallSegmentDirection})
     * @param z           The height at which to place the Segment
     * @param wallSegment The Segment to set at the location provided. (Can be null)
     * @throws IllegalArgumentException If and only if location or wallSegment are null, or if the
     *                                  x or y value of location are below 0, or if location is
     *                                  beyond the {@link #maxCoordinates()}
     */
    void setSegment(Coordinate location, int z, WallSegment wallSegment)
            throws IllegalArgumentException;

    /**
     * @param location  The location at which to remove a Segment
     * @param z         The z-index at which to remove a Segment
     * @param direction The direction of Segment to remove
     * @return True, if and only if a Segment was present, prior to being removed
     * @throws IllegalArgumentException If and only if location or direction are null, or if the x
     *                                  or y value of location are below 0, or if location is beyond
     *                                  the {@link #maxCoordinates()}
     */
    boolean removeSegment(Coordinate location, int z, WallSegmentDirection direction)
            throws IllegalArgumentException;

    /**
     * Removes all WallSegments facing a specified direction at a specified location
     * @param location The location at which to remove all Segments
     * @param direction The direction of Segments to remove
     * @throws IllegalArgumentException If and only if location or direction are null, or if the x
     *                                  or y value of location are below 0, or if location is beyond
     *                                  the {@link #maxCoordinates()}
     */
    void removeAllSegments(Coordinate location, WallSegmentDirection direction)
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
