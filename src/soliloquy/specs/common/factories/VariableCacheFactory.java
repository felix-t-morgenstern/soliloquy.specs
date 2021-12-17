package soliloquy.specs.common.factories;

import soliloquy.specs.common.infrastructure.VariableCache;
import soliloquy.specs.common.shared.SoliloquyClass;

/**
 * <b>VariableCacheFactory</b>
 * <p>
 * This class instantiates new PersistentVariableCaches. (Intended use is for a
 * {@link soliloquy.specs.common.persistence.TypeHandler} to read PersistentVariableCaches from
 * memory.)
 *
 * @author felix.t.morgenstern
 * @version 0.0.1
 */
public interface VariableCacheFactory extends SoliloquyClass {
    /**
     * @return A new VariableCache
     */
    VariableCache make();
}
