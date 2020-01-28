package soliloquy.specs.gamestate.entities;

import soliloquy.specs.common.entities.Action;
import soliloquy.specs.common.infrastructure.Collection;
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
	 * @return A Collection of characters corresponding to this KeyBinding.
	 */
	Collection<java.lang.Character> boundCharacters();

	/**
	 * @return The Action that is fired when this key is pressed
	 */
	@SuppressWarnings("rawtypes")
	Action getOnPress();
	
	/**
	 * @param onPress - The Action to fire when the bound key is pressed (Can be null)
	 */
	@SuppressWarnings("rawtypes")
	void setOnPress(Action onPress);

	/**
	 * @return The Action that is fired when this key is released
	 */
	@SuppressWarnings("rawtypes")
	Action getOnRelease();

	/**
	 * @param onRelease - The Action to fire when the bound key is pressed (Can be null)
	 */
	@SuppressWarnings("rawtypes")
	void setOnRelease(Action onRelease);

	/**
	 * @return The Action that is fired when this key is released
	 */
	@SuppressWarnings("rawtypes")
	Action getOnType();

	/**
	 * @param onType - The Action to fire when the bound key is typed (Can be null)
	 */
	@SuppressWarnings("rawtypes")
	void setOnType(Action onType);
	
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
