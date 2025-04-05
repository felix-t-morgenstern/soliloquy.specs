package soliloquy.specs.gamestate.entities.shared;

import soliloquy.specs.common.valueobjects.Coordinate3d;
import soliloquy.specs.gamestate.entities.GameZone;

/**
 * <b>GameZoneTerrain</b>
 * <p>
 * This is either a {@link soliloquy.specs.gamestate.entities.Tile} or a
 * {@link soliloquy.specs.gamestate.entities.WallSegment}, which are unique in only being able to
 * occupy one {@link soliloquy.specs.common.valueobjects.Coordinate3d} location in a
 * {@link soliloquy.specs.gamestate.entities.GameZone}.
 *
 * @author felix.t.morgenstern
 * @version 0.0.1
 */
public interface GameZoneTerrain {
    /**
     * @return The GameZone in which this entity exists
     * @throws IllegalStateException If the GameZone does not contain this entity at the location
     *                               specified by {@link #location}
     */
    GameZone gameZone() throws IllegalStateException;

    /**
     * @return The Coordinate at which this entity is located
     * @throws IllegalStateException If the GameZone does not contain this entity at the location
     */
    Coordinate3d location() throws IllegalStateException;

    /**
     * <b>NB: This method is intended to <b><u>only</u></b> be used {@link GameZone} when adding
     * this entity; it is intended to check whether the GameZone assigned to this entity has this
     * entity on it, at the given location, prior to assignment.</b>
     *
     * @param gameZone The GameZone to which this entity has been added (may be null)
     * @param location The location in which this entity has been placed (may be null if and only if
     *                 gameZone is null)
     * @throws IllegalArgumentException If and only if gameZone is null, and location is not; or,
     *                                  gameZone does not contain this entity at the specified
     *                                  location
     * @throws IllegalStateException    If this entity has been deleted
     */
    void assignGameZoneAfterAddedToGameZone(GameZone gameZone, Coordinate3d location)
            throws IllegalArgumentException, IllegalStateException;
}
