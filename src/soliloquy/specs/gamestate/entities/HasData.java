package soliloquy.specs.gamestate.entities;

import soliloquy.specs.common.infrastructure.VariableCache;
import soliloquy.specs.common.shared.SoliloquyClass;

/**
 * <b>HasData</b>
 * <p>
 * This class has a {@link VariableCache}, intended for game entities, to allow them to store
 * state dynamically.
 *
 * @author felix.t.morgenstern
 * @version 0.0.1
 */
public interface HasData extends SoliloquyClass {
    /**
     * @return Any parameters regarding this entity which do not fit neatly into any of their other
     *         properties.
     * @throws IllegalStateException If this Item has been deleted
     */
    VariableCache data() throws IllegalStateException;
}
