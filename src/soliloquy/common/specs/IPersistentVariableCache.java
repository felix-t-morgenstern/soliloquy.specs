package soliloquy.common.specs;

/**
 * <b>PersistentVariableCache</b>
 * <p>
 * A PersistentVariableCache is a cache of persistent variables (identified by String Ids) which
 * are saved when the player quits the Game--presumably to a save file--and which are restored once
 * that save file is loaded.
 * <p>
 * An individual PersistentVariableCache is a cache for variables of any type. It is expected that
 * developers will know the types to their own PersistentVariables, and will therefore be able to
 * cast them properly.
 * <p>
 * A PersistentVariableCache can be populated by reading lines from a String.
 * <p>
 * (The intended use is that either each line will correspond to a single variable, or that lines
 * will describe variables in a systematic way, e.g. with each line defining an item in a
 * Collection, after a first line describing that Collection.
 * 
 * @author felix.t.morgenstern
 * @version 0.0.1
 *
 */
public interface IPersistentVariableCache extends ISoliloquyClass {
	/**
	 * @param name - The name of the persistent variable
	 * @param value - The value of the persistent variable
	 * @throws IllegalArgumentException If name is null or empty, or if value is null
	 */
	<T> void setVariable(String name, T value) throws IllegalArgumentException;

	/**
	 * @param name - The name of the PersistentVariable to remove
	 * @return True, if and only if the PersistentVariable was removed
	 */
	boolean remove(String name);

	/**
	 * @return The number of PersistentVariables in this PersistentVariableCache
	 */
	int size();

	/**
	 * NB: Changing the contents of this Collection does not change the actual contents of this
	 * PersistentVariableCache; it is merely a representation
	 * @return A Collection of the names of the names of PersistentVariables in this
	 * PersistentVariableCache
	 */
	ICollection<String> getNamesRepresentation();

	/**
	 * NB: Changing the contents of this Collection does not change which PersistentVariables are
	 * present in this PersistentVariableCache; however, the variables returned in the Collection
	 * are the actual variables, and changing their values will result in the real variable values
	 * being changed.
	 * @return A Collection of the PersistentVariables in this PersistentVariableCache
	 */
	IMap<String,Object> getVariablesRepresentation();

	/**
	 * Clears all PersistentVariables in this PersistentVariableCache
	 */
	void clear();

	/**
	 * @param name - The name of the PersistentVariable to retrieve
	 * @param <T> The type of object to be returned
	 * @return The PersistentVariable with the name provided; null if none exists
	 */
	<T> T getVariable(String name);
}
