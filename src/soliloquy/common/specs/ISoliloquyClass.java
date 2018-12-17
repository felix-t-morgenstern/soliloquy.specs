package soliloquy.common.specs;

import soliloquy.game.primary.specs.IGame;
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
	 * This method is provided to ensure that nearly every class in the framework can access nearly every other class. Intended common uses are to access Settings and PersistentVariables.
	 * <p>
	 * <i>If you are not sure what you are doing when using this class, be careful, and feel free to ask!</i> 
	 * @return The top-level component for the entire Game
	 */
	IGame game();
	
	/**
	 * @return The Logger, which can record messages to a file, to the screen, etc.
	 */
	ILogger logger();
}
