package soliloquy.specs.common.persistence;

import soliloquy.specs.common.infrastructure.List;
import soliloquy.specs.common.shared.SoliloquyClass;

/**
 * <b>PersistentValuesHandler</b>
 * <p>
 * This class takes string representations of a persistent value (e.g. an integer, a collection of
 * Strings, some JSON blob, etc.), and transforms them into persistent values of the proper type in
 * Java; and vice-versa.
 * <p>
 * This class contains PersistentValueTypeHandlers, which translate specific string representations
 * of values to the actual value and vice-versa. If you want to process a type which is not yet
 * available in the PersistentValuesHandler, you will have to create a PersistentValueTypeHandler
 * for that type, and register it with this class.
 * 
 * @author felix.t.morgenstern
 * @version 0.0.1
 *
 */
public interface PersistentValuesHandler extends SoliloquyClass {
	/**
	 * (NB: You can technically have multiple String identifiers of a specific type; this may not
	 * be the best design.)
	 * @param persistentValueTypeHandler - The PersistentValueTypeHandler to be added
	 * @throws IllegalArgumentException If persistentValueType of persistentValueTypeHandler is
	 * null
	 */
	void addPersistentValueTypeHandler(PersistentValueTypeHandler<?> persistentValueTypeHandler) throws IllegalArgumentException;
	
	/**
	 * @param persistentValueType - The String representation of the type of the
	 * PersistentValueTypeHandler to remove
	 * @return True, if and only if a PersistentValueTypeHandler of that persistentValueType
	 * existed
	 */
	boolean removePersistentValueTypeHandler(String persistentValueType);
	
	/**
	 * @param persistentValueType - The String representation of the type of the
	 * PersistentValueTypeHandler to be retrieved
	 * @return The PersistentValueTypeHandler of the specified type
	 * @throws UnsupportedOperationException If a PersistentValueTypeHandler of this type does not
	 * exist
	 */
	<T> PersistentValueTypeHandler<T> getPersistentValueTypeHandler(String persistentValueType) throws UnsupportedOperationException;

	/**
	 * @param valueType - The type of the value for which to generate an archetype
	 * @return An archetype of the provided type
	 * @throws IllegalArgumentException If and only if valueType is null, empty, or does not
	 * correspond to a registered {@link PersistentValueTypeHandler}
	 */
	Object generateArchetype(String valueType) throws IllegalArgumentException;
	
	/**
	 * @return A new List of the parameter types with registered PersistentValueTypeHandlers
	 * in this PersistentValuesHandler
	 */
	List<String> persistentValueTypesHandled();

	/**
	 * (NB: persistentListHandler can be null, but this is extremely ill-advised.)
	 * @param persistentListHandler - The PersistentValueTypeHandler for generic Collections
	 *                                    to be used by this PersistentValuesHandler
	 */
	void registerPersistentListHandler(PersistentListHandler persistentListHandler);

	/**
	 * (NB: persistentCollectionHandler can be null, but this is extremely ill-advised.)
	 * @param persistentMapHandler - The PersistentValueTypeHandler for generic Maps to be used by
	 *                                this PersistentValuesHandler
	 */
	void registerPersistentMapHandler(PersistentMapHandler persistentMapHandler);

	/**
	 * (NB: persistentPairHandler can be null, but this is extremely ill-advised.)
	 * @param persistentPairHandler - The PersistentValueTypeHandler for generic Pairs to be used
	 *                                 by this PersistentValuesHandler
	 */
	void registerPersistentPairHandler(PersistentPairHandler persistentPairHandler);


	/**
	 * (NB: persistentRegistryHandler can be null, but this is extremely ill-advised.)
	 * @param persistentRegistryHandler - The PersistentRegistryHandler for generic Registries to
	 *                                     be used by this PersistentValuesHandler
	 */
	void registerPersistentRegistryHandler(PersistentRegistryHandler persistentRegistryHandler);
}
