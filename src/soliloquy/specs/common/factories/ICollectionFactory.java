package soliloquy.specs.common.factories;

import soliloquy.specs.common.shared.ISoliloquyClass;
import soliloquy.specs.common.infrastructure.ICollection;

/**
 * <b>CollectionFactory</b>
 * <p>
 * Generates a Collection, with a specific item type. May receive params, relating to the behavior
 * of the created Collection.
 * 
 * @author felix.t.morgenstern
 * @version 0.0.1
 */
public interface ICollectionFactory extends ISoliloquyClass {
	/**
	 * @param archetype - A (non-null) example of the item to be held in the new Collection
	 * @return A new Collection of the specified type
	 * @throws IllegalArgumentException If and only if archetype is null
	 */
	<V> ICollection<V> make(V archetype) throws IllegalArgumentException;

	/**
	 * @param items - An array of items from which to instantiate the Collection
	 * @param archetype - A (non-null) example of the item to be held in the new Collection
	 * @return A new Collection of the specified type
	 * @throws IllegalArgumentException If and only if archetype is null
	 */
	<V> ICollection<V> make(V[] items, V archetype) throws IllegalArgumentException;
}
