package soliloquy.specs.gamestate.factories;

import soliloquy.specs.common.shared.ISoliloquyClass;
import soliloquy.specs.gamestate.entities.ITile;
import soliloquy.specs.gamestate.entities.ITileFixtures;

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
