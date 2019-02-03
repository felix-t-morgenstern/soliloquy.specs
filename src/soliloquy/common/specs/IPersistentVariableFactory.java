package soliloquy.common.specs;

/**
 * <b>PersistentVariableFactory</b>
 * <p>
 * This class is used to generate {@link soliloquy.common.specs.IPersistentVariable}s.
 * 
 * @author felix.t.morgenstern
 * @version 0.0.1
 *
 */
public interface IPersistentVariableFactory {
	<T> IPersistentVariable make(String name, T value);
}
