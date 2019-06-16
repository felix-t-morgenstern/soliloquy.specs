package soliloquy.specs.graphics;

import soliloquy.specs.common.shared.ISoliloquyClass;
import soliloquy.specs.ui.windowelements.IScreen;

/**
 * <b>WindowRenderer</b>
 * <p>
 * This class renders Screens.
 * 
 * @author felix.t.morgenstern
 * @version 0.0.1
 *
 */
public interface IWindowRenderer extends ISoliloquyClass {
	/**
	 * (16.6667 ms, i.e. 17 ms, corresponds to 60 FPS.)
	 * @return The number of milliseconds in-between every time the game UI refreshes
	 */
	int millisecondsPerRefresh();
	
	/**
	 * (16.6667 ms, i.e. 17 ms, corresponds to 60 FPS.)
	 * @param milliseconds - The number of milliseconds in-between every time the game's UI will
	 * refresh
	 */
	void setMillisecondsPerTick(int milliseconds);
	
	/**
	 * @return The current number of miliseconds for which the game has been running
	 */
	Integer currentGameMs();
	
	/**
	 * @return The current Screen being rendered
	 * @throws IllegalStateException If no Screen is defined
	 */
	IScreen getScreen() throws IllegalStateException;
	
	/**
	 * @param screen - The Screen to be rendered (replaces the previous Screen)
	 * @throws IllegalArgumentException If Screen is null
	 */
	void setScreen(IScreen screen) throws IllegalArgumentException;
}
