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
     * <i>NB: Location <u>is</u> mutable, but this is handled by an unexposed method fed into
     * {@link GameZone} to be called by {@link GameZone#putTile} and
     * {@link GameZone#putSegment}</i>
     *
     * @return The Coordinate at which this entity is located
     * @throws IllegalStateException If the GameZone does not contain this entity at the location
     */
    Coordinate3d location() throws IllegalStateException;
}
