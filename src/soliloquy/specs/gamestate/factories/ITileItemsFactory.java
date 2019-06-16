package soliloquy.specs.gamestate.factories;

import soliloquy.specs.common.shared.ISoliloquyClass;
import soliloquy.specs.gamestate.entities.ITile;
import soliloquy.specs.gamestate.entities.ITileItems;

/**
 * <b>TileItemsFactory</b>
 * <p>
 * This class creates a {@link ITileItems} for a given {@link ITile}.
 *
 * @author felix.t.morgenstern
 * @version 0.0.1
 */
public interface ITileItemsFactory extends ISoliloquyClass {
    /**
     * @param tile - The {@link ITile} for which this {@link ITileItems} is to be made
     * @return A {@link ITileItems} for tile
     * @throws IllegalArgumentException If and only if tile is null
     */
    ITileItems make(ITile tile) throws IllegalArgumentException;
}
