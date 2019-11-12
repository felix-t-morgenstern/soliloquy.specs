package soliloquy.specs.gamestate.entities;

import soliloquy.specs.common.infrastructure.Map;
import soliloquy.specs.common.shared.SoliloquyClass;

import java.awt.event.KeyListener;

/**
 * <b>KeyPressListener</b>
 * <p>
 * This class responds to key press events by going through all current KeyBindingContexts, in
 * order.
 *
 * @author felix.t.morgenstern
 * @version 0.0.1
 *
 */
public interface KeyPressListener extends KeyListener, SoliloquyClass {
    /**
     * @return An ordered collection of KeyBindingContexts; intended use is that KeyBindingContexts
     * will be triggered by key press events in the order specified by the index of this Map.
     */
    Map<Integer,KeyBindingContext> contexts();
}
