package soliloquy.common.specs;

/**
 * <b>PersistentVariableCacheFactory</b>
 * <p>
 * This class instantiates new PersistentVariableCaches. (Intended use is for a
 * PersistentTypeHandler to read PersistentVariableCaches from memory.)
 *
 * @author felix.t.morgenstern
 * @version 0.0.1
 */
public interface IPersistentVariableCacheFactory extends ISoliloquyClass {
    /**
     * @return A new PersistentVariableCache
     */
    IPersistentVariableCache make();
}
