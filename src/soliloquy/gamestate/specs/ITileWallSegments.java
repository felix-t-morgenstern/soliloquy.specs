package soliloquy.gamestate.specs;

import soliloquy.common.specs.IMap;
import soliloquy.common.specs.ISoliloquyClass;

/**
 * <b>ITileWallSegments</b>
 * <p>
 * This is a numbered Map of numbered Maps of TileWallSegments.
 * <p>
 * The first (outer) index refers to the height.
 * <p>
 * The second (inner) index is the z-index, i.e. the determinant of which wall segments go "atop" one another. (For instance, you may have a cliff face; and that cliff face may have rock outcrops on it, which are also TileWallSegments.)
 *  
 * @author felix.t.morgenstern
 * @version 0.0.1
 *
 */
public interface ITileWallSegments extends IMap<Integer,IMap<Integer,ITileWallSegment>>, ISoliloquyClass {
}
