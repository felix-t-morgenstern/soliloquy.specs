package soliloquy.specs.io.input.keyboard.entities;

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
public class KeyBindingContext {
    /**
     * A List of the KeyBindings in this context
     */
    public List<KeyBinding> BINDINGS;

    /**
     * True, if and only if all lower contexts' bindings are blocked
     */
    public boolean BLOCKS_LOWER_BINDINGS;

    private KeyBindingContext(
            List<KeyBinding> bindings,
            boolean blocksLowerBindings
    ) {
        BINDINGS = bindings;
        BLOCKS_LOWER_BINDINGS = blocksLowerBindings;
    }

    public static KeyBindingContext bindingContext(
            List<KeyBinding> bindings,
            boolean blocksLowerBindings
    ) {
        return new KeyBindingContext(
                bindings,
                blocksLowerBindings
        );
    }
}
