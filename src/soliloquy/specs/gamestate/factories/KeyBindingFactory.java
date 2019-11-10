package soliloquy.specs.gamestate.factories;

import soliloquy.specs.common.shared.SoliloquyClass;
import soliloquy.specs.gamestate.entities.KeyBinding;

/**
 * <b>KeyBindingFactory</b>
 * <p>
 * This class creates KeyBindings
 *
 * @author felix.t.morgenstern
 * @version 0.0.1
 */
public interface KeyBindingFactory extends SoliloquyClass {
    KeyBinding make();
}
