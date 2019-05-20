package soliloquy.gamestate.specs;

import soliloquy.common.specs.ISoliloquyClass;

/**
 * <b>TileFixturesFactory</b>
 * <p>
 *
 *
 * @author felix.t.morgenstern
 * @version 0.0.1
 */
public interface ITileFixturesFactory extends ISoliloquyClass {
    /**
     * @param tile - The {@link ITile} for which this {@link ITileFixtures} is to be made
     * @return A new {@link ITileFixtures}
     * @throws IllegalArgumentException If and only if tile is null
     */
    ITileFixtures make(ITile tile) throws IllegalArgumentException;
}
