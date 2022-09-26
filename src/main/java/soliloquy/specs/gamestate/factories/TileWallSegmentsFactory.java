package soliloquy.specs.gamestate.factories;

import soliloquy.specs.common.shared.SoliloquyClass;
import soliloquy.specs.gamestate.entities.Tile;
import soliloquy.specs.gamestate.entities.TileWallSegments;

/**
 * <b>TileWallSegmentsFactory</b>
 * <p>
 * This class creates a {@link TileWallSegments} for a provided {@link Tile}.
 *
 * @author felix.t.morgenstern
 * @version 0.0.1
 */
public interface TileWallSegmentsFactory extends SoliloquyClass {
    /**
     * @param tile The {@link Tile} for which this {@link TileWallSegments} is to be made
     * @return A {@link TileWallSegments} for tile
     * @throws IllegalArgumentException If and only if tile is null
     */
    TileWallSegments make(Tile tile) throws IllegalArgumentException;
}
