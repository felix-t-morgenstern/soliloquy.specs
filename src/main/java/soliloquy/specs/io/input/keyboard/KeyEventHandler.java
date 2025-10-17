package soliloquy.specs.io.input.keyboard;

import soliloquy.specs.io.graphics.renderables.Component;

import java.util.Map;
import java.util.Set;

/**
 * <b>KeyEventHandler</b>
 * <p>
 * This class responds to key press and release events by going through all current
 * {@link KeyBinding}s within {@link Component}s, in a specified order.
 *
 * @author felix.t.morgenstern
 * @version 0.0.1
 */
public interface KeyEventHandler {
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
     * @param component The component whose key event priority to retrieve
     * @return The priority of key events for the provided component; null, if component is not
     *         registered to this class
     * @throws IllegalArgumentException If and only if component is null
     */
    Integer getPriority(Component component) throws IllegalArgumentException;

    /**
     * @param component The component to remove
     * @throws IllegalArgumentException If and only if component is null
     */
    void removeComponent(Component component) throws IllegalArgumentException;

    /**
     * NB: This method excludes keys whose contexts are suppressed
     *
     * @return A Set of all codepoints for the keys which are being listened to
     */
    Set<Integer> activeKeysRepresentation();

    /**
     * @param codepoint The codepoint of the key which is pressed
     * @param timestamp The timestamp at which the codepoint is pressed
     * @throws IllegalArgumentException If and only if codepoint is an illegal value, or if
     *                                  timestamp is before the most recent timestamp provided to
     *                                  class
     */
    void press(int codepoint, long timestamp) throws IllegalArgumentException;

    /**
     * @param codepoint The codepoint of the key which has been released
     * @param timestamp The timestamp at which the key is pressed
     * @throws IllegalArgumentException If and only if codepoint is an illegal value, or if
     *                                  timestamp is before the most recent timestamp provided to
     *                                  class
     */
    void release(int codepoint, long timestamp) throws IllegalArgumentException;

    /**
     * @return An ordered representation of Components; intended use is that Components will be
     *         triggered by key press events in the order specified by the index of this Map, with
     *         higher-numbered indexes firing first.
     */
    Map<Integer, Set<Component>> componentsRepresentation();
}
