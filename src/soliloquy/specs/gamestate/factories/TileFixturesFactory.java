package soliloquy.specs.gamestate.factories;

import soliloquy.specs.common.shared.SoliloquyClass;
import soliloquy.specs.gamestate.entities.Tile;
import soliloquy.specs.gamestate.entities.TileFixtures;

/**
 * <b>TileFixturesFactory</b>
 * <p>
 * This class creates TileFixtures, e.g. aggregates of none-to-many
 * {@link soliloquy.specs.gamestate.entities.TileFixture}s on a given
 * {@link soliloquy.specs.gamestate.entities.Tile}
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
