package soliloquy.common.specs;

// TODO: Delete this interface, once GenericParamsSet, PersistentVariableCache and SettingsRepo no longer implement its methods
public interface IWrites extends ISoliloquyClass {
	/**
	 * Saves the class
	 * @return A series of strings describing the results to be written
	 * @throws IllegalArgumentException If and only if the params are illegal; e.g. no filename
	 * specified, an inaccessible file location, null object, etc.
	 */
	String write() throws IllegalArgumentException;
}
