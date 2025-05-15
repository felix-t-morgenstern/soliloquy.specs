package soliloquy.specs.gamestate.factories;

import soliloquy.specs.gamestate.entities.TileFixture;
import soliloquy.specs.ruleset.entities.FixtureType;

import java.util.Map;
import java.util.UUID;

/**
 * <b>TileFixtureFactory</b>
 * <p>
 * This class creates Items
 *
 * @author felix.t.morgenstern
 * @version 0.0.1
 */
public interface TileFixtureFactory {
    /**
     * @param type The type of the newly-created TileFixture
     * @param data The data for the newly-created TileFixture; may be null
     * @return The newly-created TileFixture
     * @throws IllegalArgumentException If and only if type is null
     */
    TileFixture make(FixtureType type, Map<String, Object> data)
            throws IllegalArgumentException;

    /**
     * @param type The type of the newly-created TileFixture
     * @param data The data for the newly-created TileFixture; may be null
     * @param uuid The UUID for the newly-created TileFixture
     * @return The newly-created TileFixture
     * @throws IllegalArgumentException If and only if type or uuid is null
     */
    TileFixture make(FixtureType type, Map<String, Object> data, UUID uuid)
            throws IllegalArgumentException;
}
