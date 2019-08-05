package soliloquy.specs.gamestate.entities;

import soliloquy.specs.common.infrastructure.Map;

/**
 * <b>KeyBindingContext</b>
 * <p>
 * It is a set of KeyBindings, whose index is the characters corresponding to those key bindings.
 * <p>
 * It can block all bindings from all lower contexts.
 * @author felix.t.morgenstern
 * @version 0.0.1
 *
 */
public interface KeyBindingContext extends Map<Character, KeyBinding> {
	/**
	 * @return True, if and only if all lower contexts' bindings are blocked
	 */
	boolean getBlocksAllLowerBindings();
	
	/**
	 * @param blocksLowerBindings - Sets whether all lower contexts' bindings are blocked
	 */
	void setBlocksAllLowerBindings(boolean blocksLowerBindings);
}