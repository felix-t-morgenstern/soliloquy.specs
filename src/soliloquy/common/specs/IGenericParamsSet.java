package soliloquy.common.specs;

/**
 * <b>GenericParamsSet</b>
 * <p>
 * This is a set of generic parameters, identified by name, and of various types, e.g. Bools, ints,
 * doubles, Strings, and Sprites
 * <p>
 * It can be copied. If you want to change any of these parameters, but you don't want these
 * changes to be reflected in the original version, be sure to use the copy method. 
 * 
 * @author felix.t.morgenstern
 * @version 0.0.1
 *
 */
public interface IGenericParamsSet extends ICloneable<IGenericParamsSet> {
	/**
	 * Adds a parameter with a non-null value. (If you want to add a parameter with a null value,
	 * use addParam(String name, T value, T archetype) instead.) 
	 * @param name - The name of the new parameter to add
	 * @param value - The (non-null) value of the new parameter to add
	 * @throws IllegalArgumentException If a param of the same name and value already exists, or if
	 * value is null 
     * @param <T> The type of the new parameter to be added
	 */
	<T> void addParam(String name, T value) throws IllegalArgumentException;
	
	/**
	 * Adds a parameter with a nullable value.
	 * @param name - The name of the new parameter to add
	 * @param value - The value of the new parameter to add (which can be null)
	 * @param archetype - The archetype of the value to add
	 * @throws IllegalArgumentException If a param of the same name and value already exists, or if
	 * archetype is null
     * @param <T> The type of the new parameter to be added
	 */
	<T> void addParam(String name, T value, T archetype) throws IllegalArgumentException;
	
	/**
	 * @param paramArchetype - An object of the type being added
	 * @param paramsSet - The new params to add to this GenericParamsSet
	 * @throws IllegalArgumentException If paramArchetype or paramsSet is null
	 * @throws UnsupportedOperationException If a paramsSet of the specified type already exists in
	 * this GenericParamsSet
     * @param <T> The type of the paramsSet to be added
	 */
	<T> void addParamsSet(IMap<String,T> paramsSet, T paramArchetype) throws IllegalArgumentException, UnsupportedOperationException;
	
	/**
	 * <i>(getParam cannot differentiate between nonexistent parameters, and parameters which are
	 * genuinely null; use paramExists to be certain)</i>
	 * @param paramTypeName - The name of the type of the parameter to retrieve
	 * @param paramName - The name of the parameter to retrieve
	 * @return - The value of the parameter (null if doesn't exist)
     * @param <T> The type of the parameter to retrieve
	 */
	<T> T getParam(String paramTypeName, String paramName);
	
	/**
	 * @param paramTypeName - The name of the type of paramsSet to retrieve
	 * @return A named Map of parameters of the specified type (returns null if no such set exists
	 * within this GenericParamsSet)
	 * @throws IllegalArgumentException If paramTypeName is blank or null, or if exemplar is null
     * @param <T> The type of the paramsSet to be returned
	 */
	<T> IMap<String,T> getParamsSet(String paramTypeName) throws IllegalArgumentException;
	
	/**
	 * @param paramTypeName - The name of the type of the parameter to be checked
	 * @param paramName - The name of the parameter to be checked
	 * @return - True, if and only if the parameter exists
     * @param <T> The type of the parameter whose existence to check
	 */
	<T> boolean paramExists(String paramTypeName, String paramName);
	
	/**
	 * @return A new Collection of the parameter type names with registered paramSets in this
	 * GenericParamsSet
	 */
	ICollection<String> paramTypes();
	
	/**
	 * @param paramTypeName - The name of the type of the parameter to be checked
	 * @param paramName - The name of the parameter to be removed
	 * @return True, if and only if the parameter was removed
	 */
	boolean removeParam(String paramTypeName, String paramName);
}
