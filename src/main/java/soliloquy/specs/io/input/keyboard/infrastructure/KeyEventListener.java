package soliloquy.specs.io.input.keyboard.infrastructure;

import soliloquy.specs.io.input.keyboard.entities.KeyBindingContext;

import java.util.List;
import java.util.Map;

/**
 * <b>KeyEventListener</b>
 * <p>
 * This class responds to key press events by going through all current KeyBindingContexts, in
 * order.
 *
 * @author felix.t.morgenstern
 * @version 0.0.1
 */
public interface KeyEventListener {
    /**
     * NB: If this method is called with a context already present, its priority is updated to the
     * priority provided. And, if multiple contexts are assigned the same priority, there may be
     * indeterminacy in which context registers a key event first.
     *
     * @param context  The context to add (or the context whose priority to update)
     * @param priority The priority of this context, with higher-numbered indices firing first
     * @throws IllegalArgumentException If and only if context is null
     */
    void addContext(KeyBindingContext context, int priority) throws IllegalArgumentException;

    /**
     * @param context The context to remove
     * @throws IllegalArgumentException If and only if context is null
     */
    void removeContext(KeyBindingContext context) throws IllegalArgumentException;

    /**
     * NB: This method excludes keys whose contexts are suppressed
     *
     * @return A list of all keys which are being listened to
     */
    List<Character> activeKeysRepresentation();

    /**
     * @param key       The key which is pressed
     * @param timestamp The timestamp at which the key is pressed
     * @throws IllegalArgumentException If and only if key is an illegal value, or if timestamp is
     *                                  before the most recent timestamp provided to class
     */
    void press(char key, long timestamp) throws IllegalArgumentException;

    /**
     * @param key       The key which has been released
     * @param timestamp The timestamp at which the key is pressed
     * @throws IllegalArgumentException If and only if key is an illegal value, or if timestamp is
     *                                  before the most recent timestamp provided to class
     */
    void release(char key, long timestamp) throws IllegalArgumentException;

    /**
     * @return An ordered representation of KeyBindingContexts; intended use is that
     *         KeyBindingContexts will be triggered by key press events in the order specified by
     *         the index of this Map, with higher-numbered indexes firing first.
     */
    Map<Integer, List<KeyBindingContext>> contextsRepresentation();
}
