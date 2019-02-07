package soliloquy.common.specs;

/**
 * <b>PersistentValueToRead</b>
 * <p>
 * This is a stub class used by PersistentValuesHandler to pass off to a PersistentValueTypeHandler to be read and translated into the proper type
 * 
 * @author felix.t.morgenstern
 * @version 0.0.1
 *
 */
public interface IPersistentValueToRead extends ISoliloquyClass {
	/**
	 * @return The name of the type of the persistent value to process
	 */
	String typeName();
	
	/**
	 * @return The name of the persistent value to process
	 */
	String name();
	
	/**
	 * @return A String representation of the value of the persistent value to process
	 */
	String value();
}
