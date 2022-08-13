package soliloquy.specs.gamestate.factories;

import soliloquy.specs.common.shared.SoliloquyClass;
import soliloquy.specs.gamestate.entities.TileFixture;
import soliloquy.specs.gamestate.entities.TileFixtureItems;

/**
 * <b>TileFixtureItems</b>
 * <p>
 * This class makes a TileFixtureItems for a given TileFixture
 *
 * @author felix.t.morgenstern
 * @version 0.0.1
 */
public interface TileFixtureItemsFactory extends SoliloquyClass {
    /**
     * @param tileFixture The TileFixture for which to make the new TileFixtureItems
     * @return A TileFixtureItems for the provided TileFixture
     */
    TileFixtureItems make(TileFixture tileFixture);
}
