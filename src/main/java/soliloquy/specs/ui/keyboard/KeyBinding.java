package soliloquy.specs.ui.keyboard;

import soliloquy.specs.ui.Component;

import java.util.List;

/**
 * <b>KeyBinding</b>
 * <p>
 * When one or more keys are pressed or released, an action may take place.
 *
 * @author felix.t.morgenstern
 * @version 0.0.1
 */
public interface KeyBinding {
    /**
     * @return A List of characters bound to the press and release actions.
     */
    List<Character> boundCharacters();

    /**
     * Runs an action when this key is pressed
     *
     * @throws IllegalArgumentException If and only if timestamp is before most recent timestamp
     *                                  provided to class
     */
    void press(long timestamp) throws IllegalArgumentException;

    /**
     * Runs an action when this key is released
     *
     * @throws IllegalArgumentException If and only if timestamp is before the most recent timestamp
     *                                  provided to class
     */
    void release(long timestamp) throws IllegalArgumentException;
}
