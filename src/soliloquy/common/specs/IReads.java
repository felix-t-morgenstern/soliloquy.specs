package soliloquy.common.specs;

/**
 * <b>Reads</b>
 * <p>
 * Specifies a class which can read data to populate itself (e.g. from a savefile)
 * 
 * @author felix.t.morgenstern
 * @version 0.0.1
 *
 */
public interface IReads extends ISoliloquyClass {
	/**
	 * @param data - The data to be read by this class
	 * @param overridePreviousData - If true, then all previous data for this entity will be erased.
	 * @throws IllegalArgumentException If the data are illegal, e.g. if they are null, if they are not properly formattted, etc.
	 */
	void read(String data, boolean overridePreviousData) throws IllegalArgumentException;
}
