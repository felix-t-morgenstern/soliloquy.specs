package soliloquy.specs.io.input.keyboard;

import soliloquy.specs.io.graphics.renderables.Component;

import java.util.Map;
import java.util.Set;

/**
 * <b>KeyEventListener</b>
 * <p>
 * This class responds to key press events by going through all current
 * {@link KeyBinding}s within {@link Component}s, in a
 * specified order.
 *
 * @author felix.t.morgenstern
 * @version 0.0.1
 */
public interface KeyEventListener {
    /**
     * NB: If this method is called with a component already present, its priority is updated to the
     * priority provided. And, if multiple contexts are assigned the same priority, there may be
     * indeterminacy in which component registers a key event first.
     *
     * @param component The component to add (or the component whose priority to update)
     * @param priority  The priority of this component, with higher-numbered indices firing first
     * @throws IllegalArgumentException If and only if component is null
     */
    void addComponent(Component component, int priority) throws IllegalArgumentException;

    /**
     * @param component The component to remove
     * @throws IllegalArgumentException If and only if component is null
     */
    void removeComponent(Component component) throws IllegalArgumentException;

    /**
     * NB: This method excludes keys whose contexts are suppressed
     *
     * @return A Set of all keys which are being listened to
     */
    Set<Character> activeKeysRepresentation();

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
     * @return An ordered representation of Components; intended use is that Components will be
     *         triggered by key press events in the order specified by the index of this Map, with
     *         higher-numbered indexes firing first.
     */
    Map<Integer, Set<Component>> componentsRepresentation();
}
