package soliloquy.specs.gamestate.factories;

import soliloquy.specs.common.shared.SoliloquyClass;
import soliloquy.specs.gamestate.entities.Tile;
import soliloquy.specs.gamestate.entities.TileItems;

/**
 * <b>TileItemsFactory</b>
 * <p>
 * This class creates a {@link TileItems} for a given {@link Tile}.
 *
 * @author felix.t.morgenstern
 * @version 0.0.1
 */
public interface TileItemsFactory extends SoliloquyClass {
    /**
     * @param tile - The {@link Tile} for which this {@link TileItems} is to be made
     * @return A {@link TileItems} for tile
     * @throws IllegalArgumentException If and only if tile is null
     */
    TileItems make(Tile tile) throws IllegalArgumentException;
}
