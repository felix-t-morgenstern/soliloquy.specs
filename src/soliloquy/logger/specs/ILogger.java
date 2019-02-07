package soliloquy.logger.specs;

import soliloquy.common.specs.ISoliloquyClass;

/**
 * <b>Logger</b>
 * <p>
 * Logs exceptions, warnings, and messages to an output file, intended for debugging
 * 
 * @author felix.t.morgenstern
 * @version 0.0.1
 *
 */
public interface ILogger extends ISoliloquyClass {
	/**
	 * @param e - The Exception to log (e.g. to file)
	 * @param origin - The origin (i.e. the responsible class, method, and line)
	 * @param timestamp - The date and time of the exception
	 */
	void logException(Exception e, String origin, String timestamp);
	
	/**
	 * @param warning - The warning to log (e.g. to file)
	 * @param origin - The origin (i.e. the responsible class/method)
	 * @param timestamp - The date and time of the warning
	 */
	void logWarning(String warning, String origin, String timestamp);
	
	/**
	 * @param message - The message to log (e.g. to file)
	 * @param origin - The origin (i.e. the responsible class, method, and line)
	 * @param timestamp - The date and time of the message
	 */
	void logMessage(String message, String origin, String timestamp);
}
