package soliloquy.specs.gamestate.factories;

import soliloquy.specs.gamestate.entities.Tile;
import soliloquy.specs.gamestate.entities.TileCharacters;
import soliloquy.specs.common.shared.SoliloquyClass;

/**
 * <b>TileCharactersFactory</b>
 * <p>
 * This class makes a {@link TileCharacters} for a given {@link Tile}
 *
 * @author felix.t.morgenstern
 * @version 0.0.1
 */
public interface TileCharactersFactory extends SoliloquyClass {
    /**
     * @param tile - The {@link Tile} for whom to make this {@link TileCharacters}
     * @return The new {@link TileCharacters}
     * @throws IllegalArgumentException If and only if tile is null
     */
    TileCharacters make(Tile tile) throws IllegalArgumentException;
}
