package soliloquy.specs.gamestate.factories;

import soliloquy.specs.common.shared.SoliloquyClass;
import soliloquy.specs.gamestate.entities.Tile;
import soliloquy.specs.gamestate.entities.TileFixtures;

/**
 * <b>TileFixturesFactory</b>
 * <p>
 *
 *
 * @author felix.t.morgenstern
 * @version 0.0.1
 */
public interface TileFixturesFactory extends SoliloquyClass {
    /**
     * @param tile - The {@link Tile} for which this {@link TileFixtures} is to be made
     * @return A new {@link TileFixtures}
     * @throws IllegalArgumentException If and only if tile is null
     */
    TileFixtures make(Tile tile) throws IllegalArgumentException;
}
