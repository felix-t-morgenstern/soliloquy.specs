package soliloquy.specs.common.infrastructure;

import soliloquy.specs.common.shared.Cloneable;
import soliloquy.specs.common.shared.SoliloquyClass;

/**
 * <b>VariableCache</b>
 * <p>
 * A VariableCache is a cache of persistent variables (identified by String Ids) which
 * are saved when the player quits the Game--presumably to a save file--and which are restored once
 * that save file is loaded.
 * <p>
 * An individual VariableCache is a cache for variables of any type. It is expected that
 * developers will know the types to their own PersistentVariables, and will therefore be able to
 * cast them properly.
 * <p>
 * A VariableCache can be populated by reading lines from a String.
 * <p>
 * (The intended use is that either each line will correspond to a single variable, or that lines
 * will describe variables in a systematic way, e.g. with each line defining an item in a
 * List, after a first line describing that List.
 * 
 * @author felix.t.morgenstern
 * @version 0.0.1
 *
 */
public interface VariableCache extends Cloneable<VariableCache>, SoliloquyClass {
	/**
	 * @param name - The name of the persistent variable
	 * @param value - The value of the persistent variable
	 * @throws IllegalArgumentException If name is null or empty, or if value is null
	 */
	<T> void setVariable(String name, T value) throws IllegalArgumentException;

	/**
	 * @param name - The name of the PersistentVariable to remove
	 * @return True, if and only if the PersistentVariable was removed
	 * @throws IllegalArgumentException If and only if name is empty or null
	 */
	boolean remove(String name) throws IllegalArgumentException;

	/**
	 * @return The number of PersistentVariables in this VariableCache
	 */
	int size();

	/**
	 * NB: Changing the contents of this List does not change the actual contents of this
	 * VariableCache; it is merely a representation
	 * @return A List of the names of the names of PersistentVariables in this
	 * VariableCache
	 */
	List<String> namesRepresentation();

	/**
	 * NB: Changing the contents of this Map does not change which PersistentVariables are present
	 * in this VariableCache; however, the variables returned in the List are the actual variables,
	 * and changing their values will result in the real variable values being changed.
	 * @return A Map of the PersistentVariables in this VariableCache
	 */
	Map<String,Object> variablesRepresentation();

	/**
	 * Clears all PersistentVariables in this VariableCache
	 */
	void clear();

	/**
	 * @param name - The name of the PersistentVariable to retrieve
	 * @param <T> The type of object to be returned
	 * @return The PersistentVariable with the name provided; null if none exists
	 * @throws IllegalArgumentException If and only if name is empty or null
	 */
	<T> T getVariable(String name) throws IllegalArgumentException;
}
