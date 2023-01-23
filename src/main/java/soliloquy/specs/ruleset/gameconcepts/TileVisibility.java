package soliloquy.specs.ruleset.gameconcepts;

import soliloquy.specs.common.shared.SoliloquyClass;
import soliloquy.specs.gamestate.entities.Tile;
import soliloquy.specs.gamestate.entities.TileWallSegment;

/**
 * <b>TileVisibility</b>
 * <p>
 * This class contains the rules determining whether a Character on one Tile can see another Tile
 *
 * @author felix.t.morgenstern
 * @version 0.0.1
 */
public interface TileVisibility extends SoliloquyClass {
    /**
     * @param origin The origin Tile
     * @param target The destination Tile
     * @return True, if and only if a Character on the origin Tile can see the target Tile
     * @throws IllegalArgumentException If either origin or target are null, if they are the same
     *                                  Tile, or if they are in different GameZones
     */
    boolean canSeeTile(Tile origin, Tile target) throws IllegalArgumentException;

    boolean canSeeTileWallSegment(Tile origin, TileWallSegment tileWallSegment)
            throws IllegalArgumentException;
}
