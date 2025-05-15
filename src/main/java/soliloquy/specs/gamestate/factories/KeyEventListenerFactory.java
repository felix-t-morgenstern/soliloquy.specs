package soliloquy.specs.gamestate.factories;

import soliloquy.specs.gamestate.entities.KeyEventListener;

/**
 * <b>KeyEventListenerFactory</b>
 * <p>
 * This class creates KeyBindingContexts
 *
 * @author felix.t.morgenstern
 * @version 0.0.1
 */
public interface KeyEventListenerFactory {
    /**
     * (NB: This method accepts mostRecentTimestamp to ensure that timestamp information is
     * persisted.)
     *
     * @param mostRecentTimestamp The most recent timestamp at which a key event was registered
     * @return The newly-created KeyEventListener
     */
    KeyEventListener make(Long mostRecentTimestamp);
}
