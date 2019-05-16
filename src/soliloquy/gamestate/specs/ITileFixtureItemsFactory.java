package soliloquy.gamestate.specs;

import soliloquy.common.specs.ISoliloquyClass;

/**
 * <b>TileFixtureItems</b>
 * <p>
 * This class makes a TileFixtureItems for a given TileFixture
 *
 * @author felix.t.morgenstern
 * @version 0.0.1
 */
public interface ITileFixtureItemsFactory extends ISoliloquyClass {
    /**
     * @param tileFixture - The TileFixture for which to make the new TileFixtureItems
     * @return A TileFixtureItems for the provided TileFixture
     */
    ITileFixtureItems make(ITileFixture tileFixture);
}
