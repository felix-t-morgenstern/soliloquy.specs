package soliloquy.specs.common.factories;

import soliloquy.specs.common.infrastructure.List;
import soliloquy.specs.common.shared.SoliloquyClass;

import java.util.Collection;

/**
 * <b>ListFactory</b>
 * <p>
 * Generates a List, with a specific item type. May receive params, relating to the behavior
 * of the created List.
 * 
 * @author felix.t.morgenstern
 * @version 0.0.1
 */
public interface ListFactory extends SoliloquyClass {
	/**
	 * @param archetype - A (non-null) example of the item to be held in the new List
	 * @return A new List of the specified type
	 * @throws IllegalArgumentException If and only if archetype is null
	 */
	<V> List<V> make(V archetype) throws IllegalArgumentException;

	/**
	 * @param items - An array of items from which to instantiate the List
	 * @param archetype - A (non-null) example of the item to be held in the new List
	 * @return A new List of the specified type
	 * @throws IllegalArgumentException If and only if archetype or items null
	 */
	<V> List<V> make(V[] items, V archetype) throws IllegalArgumentException;

	/**
	 * @param items - An array of items from which to instantiate the List
	 * @param archetype - A (non-null) example of the item to be held in the new List
	 * @return A new List of the specified type
	 * @throws IllegalArgumentException If and only if archetype or items null
	 */
	<V> List<V> make(Collection<V> items, V archetype) throws IllegalArgumentException;
}
