package soliloquy.common.specs;

import soliloquy.logger.specs.ILogger;

/**
 * <b>SoliloquyClass</b>
 * <p>
 * This specifies the capability of nearly all Soliloquy classes to access the top-level Soliloquy class, i.e. Game.
 * <p>
 * All classes (or at least nearly all classes) have access to Game to give developers maximum power to do as they see fit. Intended common uses are to access Settings and PersistentVariables.
 * <p>
 * It also permits every class in the Game to perform Logging functions. 
 * 
 * @author felix.t.morgenstern
 * @version 0.0.1
 *
 */
public interface ISoliloquyClass {
	/**
	 * <b>If this class has any type parameters, those parameters should be included, in the proper order, within angle brackets, just as they do in the class definition.</b> 
	 * @return The name of the interface of this class.
	 */
	String getInterfaceName();
}
