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
     * @param coordinate The coordinate of the Tile to retrieve
     * @return The Tile at those coordinates
     * @throws IllegalArgumentException If coordinate is null, or beyond the dimensions of the
     *                                  GameZone
     */
    Tile tile(Coordinate coordinate) throws IllegalArgumentException;

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
