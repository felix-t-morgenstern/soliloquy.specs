package soliloquy.specs.common.factories;

import soliloquy.specs.common.infrastructure.Map;
import soliloquy.specs.common.shared.SoliloquyClass;

/**
 * <b>MapFactory</b>
 * <p>
 * Generates a Map, with a specific key and value. May receive params, relating to the behavior of
 * the created Map.
 *
 * @author felix.t.morgenstern
 * @version 0.0.1
 */
public interface MapFactory extends SoliloquyClass {
    /**
     * @param archetype1 A dummy value of the first type
     * @param archetype2 A dummy value of the second type
     * @return A new Map, with the specified types for its Key and Value
     * @throws IllegalArgumentException If and only if archetype1 or archetype2 are null
     */
    <K, V> Map<K, V> make(K archetype1, V archetype2) throws IllegalArgumentException;

    /**
     * @param items      The items used to populate the newly-created Map
     * @param archetype1 A dummy value of the first type
     * @param archetype2 A dummy value of the second type
     * @return A new Map, with the specified types for its Key and Value
     * @throws IllegalArgumentException If and only if items, archetype1, or archetype2 are null
     */
    <K, V> Map<K, V> make(java.util.Map<K, V> items, K archetype1, V archetype2)
            throws IllegalArgumentException;
}
