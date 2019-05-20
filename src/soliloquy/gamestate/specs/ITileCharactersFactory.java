package soliloquy.gamestate.specs;

import soliloquy.common.specs.ISoliloquyClass;

/**
 * <b>TileCharactersFactory</b>
 * <p>
 * This class makes a {@link ITileCharacters} for a given {@link ITile}
 *
 * @author felix.t.morgenstern
 * @version 0.0.1
 */
public interface ITileCharactersFactory extends ISoliloquyClass {
    /**
     * @param tile - The {@link ITile} for whom to make this {@link ITileCharacters}
     * @return The new {@link ITileCharacters}
     * @throws IllegalArgumentException If and only if tile is null
     */
    ITileCharacters make(ITile tile) throws IllegalArgumentException;
}
