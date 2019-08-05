package soliloquy.specs.gamestate.entities;

import soliloquy.specs.common.entities.Action;
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
	 * @return The Action that is fired when this key is pressed
	 */
	Action<Void> getOnPress();
	
	/**
	 * @param onPress - The Action to fire when the bound key is pressed (Can be null)
	 */
	void setOnPress(Action<Void> onPress);

	/**
	 * @return The Action that is fired when this key is released
	 */
	Action<Void> getOnRelease();

	/**
	 * @param onRelease - The Action to fire when the bound key is pressed (Can be null)
	 */
	void setOnRelease(Action<Void> onRelease);
	
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