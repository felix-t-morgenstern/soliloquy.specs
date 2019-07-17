package soliloquy.specs.common.factories;

import soliloquy.specs.common.infrastructure.PersistentVariableCache;
import soliloquy.specs.common.shared.SoliloquyClass;

/**
 * <b>PersistentVariableCacheFactory</b>
 * <p>
 * This class instantiates new PersistentVariableCaches. (Intended use is for a
 * PersistentTypeHandler to read PersistentVariableCaches from memory.)
 *
 * @author felix.t.morgenstern
 * @version 0.0.1
 */
public interface PersistentVariableCacheFactory extends SoliloquyClass {
    /**
     * @return A new PersistentVariableCache
     */
    PersistentVariableCache make();
}
