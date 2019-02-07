package soliloquy.gamestate.specs;

import soliloquy.common.specs.IAction;
import soliloquy.common.specs.ISoliloquyClass;

/**
 * <b>KeyBinding</b>
 * <p>
 * When a key is pressed or released, an Action may take place.
 * <p>
 * The key associated with this KeyBinding is defined by the Id used to access this KeyBinding in the its KeyBindingContext.
 * <p>
 * It can block the bindings from lower contexts corresponding to the same key.
 * 
 * @author felix.t.morgenstern
 * @version 0.0.1
 */
public interface IKeyBinding extends ISoliloquyClass {
	/**
	 * @return The Action that is fired when this key is pressed
	 */
	IAction<Void> getOnPress();
	
	/**
	 * @param onPress - The Action to fire when the bound key is pressed (Can be null)
	 */
	void setOnPress(IAction<Void> onPress);

	/**
	 * @return The Action that is fired when this key is released
	 */
	IAction<Void> getOnRelease();

	/**
	 * @param onPress - The Action to fire when the bound key is pressed (Can be null)
	 */
	void setOnRelease(IAction<Void> onRelease);
	
	/**
	 * @return True, if and only if this KeyBinding blocks KeyBindings in lower KeyBindingContexts which are bound to the same key
	 */
	boolean getBlocksLowerBindings();
	
	/**
	 * @param blocksLowerBindings - Whether this KeyBinding blocks KeyBindings in lower KeyBindingContexts which are bound to the same key 
	 */
	void setBlocksLowerBindings(boolean blocksLowerBindings);
}
