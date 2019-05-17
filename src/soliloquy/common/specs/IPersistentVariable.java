package soliloquy.common.specs;

/**
 * <b>PersistentVariable</b>
 * <p>
 * This represents a variable, held within the game while it is running, which is intended to be
 * read from and written to some persistent data (i.e. a savefile) in-between game sessions.
 * <p>
 * It can return its name, its value may be set or retrieved, and it can produce an object which
 * can be processed by a {@link soliloquy.common.specs.IPersistentValuesHandler}.
 * <p>
 * (The creation of PersistentVariables is to be handled by a
 * {@link soliloquy.common.specs.IPersistentVariableFactory}.
 * 
 * @author felix.t.morgenstern
 * @version 0.0.1
 *
 */
public interface IPersistentVariable extends ISoliloquyClass {
	/**
	 * @return The Name of the PersistentVariable
	 */
	String getName();
	
	/**
	 * @return The value of the current PersistentVariable
	 */
	<T> T getValue();
	
	/**
	 * @param value The value to which to set this PersistentVariable
	 * @throws IllegalArgumentException If and only if value is null
	 */
	<T> void setValue(T value) throws IllegalArgumentException;
}
