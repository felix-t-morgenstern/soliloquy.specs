package soliloquy.specs.ruleset.gameconcepts;

import soliloquy.specs.common.shared.Direction;
import soliloquy.specs.common.valueobjects.Coordinate3d;

/**
 * <b>TileVisibility</b>
 * <p>
 * This class contains the rules determining whether a Character on one Tile can move to another
 * Tile, and how many action points it will cost
 *
 * @author felix.t.morgenstern
 * @version 0.0.1
 */
public interface TileNavigability {
    /**
     * @param origin     The origin from which to calculate navigation
     * @param direction  The direction in which to calculate navigation
     * @param charHeight The height of the {@link soliloquy.specs.gamestate.entities.Character}
     *                   whose navigation to calculate
     * @return The location where a {@link soliloquy.specs.gamestate.entities.Character} will be
     *         when moving in the provided direction, and the movement cost to get there
     * @throws IllegalArgumentException If either origin or target are null, if they are the same
     *                                  Tile, if they are not adjacent, or if they are in different
     *                                  GameZones
     */
    Navigability calculate(Coordinate3d origin, Direction direction, int charHeight)
            throws IllegalArgumentException;

    interface Navigability {
        /**
         * @return The location a {@link soliloquy.specs.gamestate.entities.Character} will be after
         *         moving in the provided direction
         */
        Coordinate3d destination();

        /**
         * @return The cost (e.g., in movement points) of moving in the provided direction
         */
        int cost();
    }
}
