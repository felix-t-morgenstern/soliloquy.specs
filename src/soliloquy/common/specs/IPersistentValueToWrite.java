package soliloquy.common.specs;

/**
 * <b>PersistentValueToWrite</b>
 * <p>
 * This is a stub class used by PersistentValuesHandler to pass off to a PersistentValueTypeHandler to be written and translated into a String
 * 
 * @author felix.t.morgenstern
 * @version 0.0.1
 *
 * @param <T> The type of value being processed
 */
public interface IPersistentValueToWrite<T> extends IHasOneGenericParam<T> {
	/**
	 * @return The type of the persistent value to process
	 */
	String typeName();
	
	/**
	 * @return The name of the persistent value to process
	 */
	String name();
	
	/**
	 * @return The value of the persistent value to process
	 */
	T value();
}
