package soliloquy.specs.gamestate.factories;

import soliloquy.specs.common.shared.SoliloquyClass;
import soliloquy.specs.gamestate.entities.KeyBindingContext;

/**
 * <b>KeyBindingContextFactory</b>
 * <p>
 * This class creates KeyBindingContexts
 *
 * @author felix.t.morgenstern
 * @version 0.0.1
 */
public interface KeyBindingContextFactory extends SoliloquyClass {
    KeyBindingContext make();
}
