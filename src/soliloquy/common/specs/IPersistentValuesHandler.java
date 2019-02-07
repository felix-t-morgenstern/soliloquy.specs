package soliloquy.common.specs;

/**
 * <b>PersistentValuesHandler</b>
 * <p>
 * This class takes string representations of persistent values (e.g. JSON), and transforms them into persistent values of the proper type in Java; and vice-versa.
 * <p>
 * This class contains PersistentValueTypeHandlers, which translate specific string representations of values to the actual value and vice-versa. If you want to process a type which is not yet available in the PersistentValuesHandler, you will have to create a PersistentValueTypeHandler for that type, and register it with this class.
 * 
 * @author felix.t.morgenstern
 * @version 0.0.1
 *
 */
public interface IPersistentValuesHandler extends ISoliloquyClass {
	/**
	 * (NB: You can technically have multiple String identifiers of a specific type; this may not be the best design.)
	 * @param persistentValueTypeHandler - The PersistenValueTypeHandler to be added
	 * @throws IllegalArgumentException If persistentValueType of persistentValueTypeHandler is null
	 */
	void addPersistentValueTypeHandler(IPersistentValueTypeHandler<?> persistentValueTypeHandler) throws IllegalArgumentException;
	
	/**
	 * @param persistentValueType - The String representation of the type of the PersistentValueTypeHandler to remove
	 * @return True, if and only if a PersistentValueTypeHandler of that persistentValueType existed
	 */
	boolean removePersistentValueTypeHandler(String persistentValueType);
	
	/**
	 * @param persistentValueType - The String representation of the type of the PersistentValueTypeHandler to be retrieved
	 * @return The PersistentValueTypeHandler of the specified type
	 * @throws UnsupportedOperationException If a PersistentValueTypeHandler of this type does not exist
	 */
	<T> IPersistentValueTypeHandler<T> getPersistentValueTypeHandler(String persistentValueType) throws UnsupportedOperationException;
	
	/**
	 * @return A new Collection of the parameter types with registered PersistentValueTypeHandlers in this PersistentValuesHandler
	 */
	ICollection<String> persistentValueTypesHandled();
	
	/**
	 * This method takes a String representation of a collection of values, and performs a specified Action on each result.
	 * @param valuesString - The String whose value to read
	 * @param valueProcessing - The Action to perform on the value parsed by this method, e.g. adding it to the SettingsRepo
	 * @param overridePreviousData - True, if and only if the value provided to this method should override existing data of that parameter type and name
	 */
	void readValues(String valuesString, IAction<IPair<IPersistentValueToWrite<?>,Boolean>> valueProcessing, boolean overridePreviousData);
	
	/**
	 * This method takes a Collection of values, and returns a String representation of that Collection
	 * @param persistentValuesToProcess - The persistent values to write to a String
	 * @return A string representing the persistent values
	 */
	String writeValues(ICollection<IPersistentValueToWrite<?>> persistentValuesToProcess);
	
	/**
	 * <b><i>It is assumed that typeName is equal to value.getClass().getCanonicalName()!</i></b>
	 * @param typeName - A String representation of the type
	 * @param name - The name of the value
	 * @param value - A String representation of the value
	 * @return A representation of the value provided, to be read and translated into the appropriate type
	 */
	IPersistentValueToRead makePersistentValueToRead(String typeName, String name, String value);
	
	/**
	 * @param name - The name of the value
	 * @param value - The value
	 * @return A representation of the value provided, to be written as a String
	 */
	<T> IPersistentValueToWrite<T> makePersistentValueToWrite(String name, T value);
}
