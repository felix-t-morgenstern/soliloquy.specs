package soliloquy.specs.gamestate.entities;

import soliloquy.specs.common.entities.Action;
import soliloquy.specs.common.infrastructure.List;
import soliloquy.specs.common.shared.SoliloquyClass;

/**
 * <b>KeyBinding</b>
 * <p>
 * When a key is pressed or released, an Action may take place.
 * <p>
 * The key associated with this KeyBinding is defined by the Id used to access this KeyBinding in
 * the its KeyBindingContext.
 * <p>
 * It can block the bindings from lower contexts corresponding to the same key.
 * 
 * @author felix.t.morgenstern
 * @version 0.0.1
 */
public interface KeyBinding extends SoliloquyClass {
	/**
	 * NB: The Character here responds to the end result of pressing the keys; i.e., pressing shift
	 * and then "a" will result in the Character "A", ala
	 * {@link java.awt.event.KeyEvent#getKeyChar}.
	 * @return A List of characters corresponding to this KeyBinding.
	 */
	List<java.lang.Character> boundCharacters();

	/**
	 * Runs the Action that is ran when this key is pressed
	 * @throws IllegalArgumentException If and only if timestamp is out-of-date
	 */
	void press(long timestamp) throws IllegalArgumentException;
	
	/**
	 * @param onPress The Action to run when the bound key is pressed (Can be null)
	 */
	void setOnPress(Action<Long> onPress);

	/**
	 * @return The Id of the Action that is ran when this key is pressed; can be null
	 */
	String onPressActionId();

	/**
	 * Runs the Action that is ran when this key is released
	 * @throws IllegalArgumentException If and only if timestamp is out-of-date
	 */
	void release(long timestamp) throws IllegalArgumentException;

	/**
	 * @param onRelease The Action to run when the bound key is released (Can be null)
	 */
	void setOnRelease(Action<Long> onRelease);

	/**
	 * @return The Id of the Action that is ran when this key is released; can be null
	 */
	String onReleaseActionId();
	
	/**
	 * @return True, if and only if this KeyBinding blocks KeyBindings in lower KeyBindingContexts
	 * which are bound to the same key
	 */
	boolean getBlocksLowerBindings();
	
	/**
	 * @param blocksLowerBindings - Whether this KeyBinding blocks KeyBindings in lower
	 * KeyBindingContexts which are bound to the same key 
	 */
	void setBlocksLowerBindings(boolean blocksLowerBindings);
}
