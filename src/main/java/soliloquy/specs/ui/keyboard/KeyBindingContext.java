package soliloquy.specs.ui.keyboard;

import java.util.List;

/**
 * <b>KeyBindingContext</b>
 * <p>
 * It is a set of KeyBindings, whose index is the characters corresponding to those key bindings.
 * <p>
 * It can block all bindings from all lower contexts.
 *
 * @author felix.t.morgenstern
 * @version 0.0.1
 */
public interface KeyBindingContext {
    /**
     * @return A List of the KeyBindings in this context
     */
    List<KeyBinding> bindings();

    /**
     * @return True, if and only if all lower contexts' bindings are blocked
     */
    boolean blocksLowerBindings();
}
