package soliloquy.specs.gamestate.factories;

import soliloquy.specs.common.shared.SoliloquyClass;
import soliloquy.specs.gamestate.entities.KeyPressListener;

/**
 * <b>KeyPressListenerFactory</b>
 * <p>
 * This class creates KeyBindingContexts
 *
 * @author felix.t.morgenstern
 * @version 0.0.1
 */
public interface KeyPressListenerFactory extends SoliloquyClass {
    KeyPressListener make();
}
