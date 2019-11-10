package soliloquy.specs.gamestate.factories;

import soliloquy.specs.common.infrastructure.GenericParamsSet;
import soliloquy.specs.common.shared.SoliloquyClass;
import soliloquy.specs.common.valueobjects.EntityUuid;
import soliloquy.specs.gamestate.entities.TileFixture;
import soliloquy.specs.ruleset.entities.FixtureType;

/**
 * <b>ItemFactory</b>
 * <p>
 * This class creates Items
 *
 * @author felix.t.morgenstern
 * @version 0.0.1
 */
public interface TileFixtureFactory extends SoliloquyClass {
    /**
     * @param type - The type of the newly-created TileFixture
     * @param data - The data for the newly-created TileFixture; may be null
     * @return The newly-created TileFixture
     * @throws IllegalArgumentException If and only if type is null
     */
    TileFixture make(FixtureType type, GenericParamsSet data) throws IllegalArgumentException;

    /**
     * @param type - The type of the newly-created TileFixture
     * @param data - The data for the newly-created TileFixture; may be null
     * @param id - The Id for the newly-created TileFixture
     * @return The newly-created TileFixture
     * @throws IllegalArgumentException If and only if type or id is null
     */
    TileFixture make(FixtureType type, GenericParamsSet data, EntityUuid id)
            throws IllegalArgumentException;
}
