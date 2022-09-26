package soliloquy.specs.gamestate.factories;

import soliloquy.specs.common.infrastructure.VariableCache;
import soliloquy.specs.common.shared.SoliloquyClass;
import soliloquy.specs.gamestate.entities.Party;

/**
 * <b>PartyFactory</b>
 * <p>
 * This class creates {@link Party} objects.
 *
 * @author felix.t.morgenstern
 * @version 0.0.1
 */
public interface PartyFactory extends SoliloquyClass {
    /**
     * @param data The data for the newly-created Party object
     * @return The newly-created Party object
     * @throws IllegalArgumentException If and only if data is null
     */
    Party make(VariableCache data) throws IllegalArgumentException;
}
