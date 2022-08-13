package soliloquy.specs.logger;

import java.io.IOException;

import soliloquy.specs.common.shared.SoliloquyClass;

/**
 * <b>Logger</b>
 * <p>
 * Logs exceptions, warnings, and messages to an output file, intended for debugging
 * 
 * @author felix.t.morgenstern
 * @version 0.0.1
 *
 */
public interface Logger extends SoliloquyClass {
	/**
	 * @param logLocation The URI to which to write
	 * @throws IOException Iff a connection to the persistent log location cannot be accessed for IO
	 */
	void setLogfileLocation(String logLocation) throws IOException;
	
	/**
	 * @param e - The Exception to log (e.g. to file)
	 * @throws IOException Iff a connection to the log cannot be accessed for IO
	 */
	void logException(Exception e) throws IOException;
	
	/**
	 * @param warning - The warning to log (e.g. to file)
	 * @throws IOException Iff a connection to the log cannot be accessed for IO
	 */
	void logWarning(String warning) throws IOException;
	
	/**
	 * @param info - The info message to log (e.g. to file)
	 * @throws IOException Iff a connection to the log cannot be accessed for IO
	 */
	void logInfo(String info) throws IOException;
}
