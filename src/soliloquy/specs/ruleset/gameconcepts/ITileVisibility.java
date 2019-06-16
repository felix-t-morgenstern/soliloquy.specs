package soliloquy.specs.ruleset.gameconcepts;

import soliloquy.specs.common.shared.ISoliloquyClass;
import soliloquy.specs.gamestate.entities.ITile;

/**
 * <b>TileVisibility</b>
 * <p>
 * This class contains the rules determining whether a Character on one Tile can see another Tile
 * 
 * @author felix.t.morgenstern
 * @version 0.0.1
 *
 */
public interface ITileVisibility extends ISoliloquyClass {
	/**
	 * @param origin - The origin Tile
	 * @param target - The destination Tile
	 * @return True, if and only if a Character on the origin Tile can see the target Tile
	 * @throws IllegalArgumentException If either origin or target are null, if they are the same
	 * Tile, or if they are in different GameZones
	 */
	boolean canSeeTile(ITile origin, ITile target) throws IllegalArgumentException;
}
