package soliloquy.specs.ruleset.gameconcepts;

import soliloquy.specs.common.shared.SoliloquyClass;
import soliloquy.specs.gamestate.entities.Tile;

/**
 * <b>TileVisibility</b>
 * <p>
 * This class contains the rules determining whether a Character on one Tile can move to another
 * Tile, and how many action points it will cost
 *
 * @author felix.t.morgenstern
 * @version 0.0.1
 */
public interface TileNavigability extends SoliloquyClass {
    /**
     * @param origin The origin Tile
     * @param target The target Tile
     * @return The cost, in action points, to navigate from the origin to the target; if the step
     *         between those two Tiles is blocked, this method returns null.
     * @throws IllegalArgumentException If either origin or target are null, if they are the same
     *                                  Tile, if they are not adjacent, or if they are in different
     *                                  GameZones
     */
    Integer navigationCost(Tile origin, Tile target) throws IllegalArgumentException;
}
