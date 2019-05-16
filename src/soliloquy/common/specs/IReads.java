package soliloquy.common.specs;

// TODO: Delete this interface, once GenericParamsSet, PersistentVariableCache and SettingsRepo no longer implement its methods
public interface IReads extends ISoliloquyClass {
	/**
	 * @param data - The data to be read by this class
	 * @throws IllegalArgumentException If the data are illegal, e.g. if they are null, if they are
	 * not properly formatted, etc.
	 */
	void read(String data) throws IllegalArgumentException;
}
