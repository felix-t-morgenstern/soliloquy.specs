package soliloquy.common.specs;

/**
 * <b>Writes</b>
 * <p>
 * This class can write out its contents as an array of Strings, e.g. for saving to a file.
 * 
 * @author felix.t.morgenstern
 * @version 0.0.1
 *
 */
public interface IWrites {
	/**
	 * Saves the class
	 * @return A series of strings describing the results to be written
	 * @throws IllegalArgumentException If and only if the params are illegal; e.g. no filename specified, an inaccessible file location, null object, etc.
	 */
	String write() throws IllegalArgumentException;
}
