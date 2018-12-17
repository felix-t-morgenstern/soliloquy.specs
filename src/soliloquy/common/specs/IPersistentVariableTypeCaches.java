package soliloquy.common.specs;

/**
 * <b>PersistentVariableTypeCaches</b>
 * <p>
 * This is a collection of all PersistentVariableTypeCaches. They may be selected by their type.
 * <p>
 * (It is intended that each instance of PersistentVaraibleTypeCaches will only have one PersistentVariableTypeCache per each type. It is also intended that different instances of PersistentVariableTypeCaches will correspond to different uses, e.g. one instance of this class for the Game, one instance for Core Settings, etc.)
 * 
 * @author felix.t.morgenstern
 * @version 0.0.1
 *
 */
public interface IPersistentVariableTypeCaches extends IReads, IWrites {
	/**
	 * Creates a PersistentVariableTypeCache, to be retrieved as needed
	 * @param type - The type of cache to be registered
	 * @param cache - The cache to be registered
	 * @throws IllegalArgumentException If cache is null
	 * @throws UnsupportedOperationException If a PersistentVariableTypeCache of this type has already been registered
	 */
	<T> void registerCache(Class<T> type, IPersistentVariableTypeCache<T> cache) throws IllegalArgumentException, UnsupportedOperationException;
	
	/**
	 * Retrieves a PersistentVariableTypeCache of a given type
	 * @param type - The type of PersistentVariableTypeCache to retrieve
	 * @throws IllegalArgumentException If type is null, or a PersistentVariableTypeCache of this type does not exist
	 */
	<T> IPersistentVariableTypeCache<T> retrieveCache(Class<T> type) throws IllegalArgumentException;
}
