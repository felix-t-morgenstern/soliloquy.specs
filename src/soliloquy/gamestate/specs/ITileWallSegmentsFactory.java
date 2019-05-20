package soliloquy.gamestate.specs;

import soliloquy.common.specs.ISoliloquyClass;

/**
 * <b>TileWallSegmentsFactory</b>
 * <p>
 * This class creates a {@link ITileWallSegments} for a provided {@link ITile}.
 *
 * @author felix.t.morgenstern
 * @version 0.0.1
 */
public interface ITileWallSegmentsFactory extends ISoliloquyClass {
    /**
     * @param tile - The {@link ITile} for which this {@link ITileWallSegments} is to be made
     * @return A {@link ITileWallSegments} for tile
     * @throws IllegalArgumentException If and only if tile is null
     */
    ITileWallSegments make(ITile tile) throws IllegalArgumentException;
}
