package soliloquy.specs.common.infrastructure;

import soliloquy.specs.common.entities.IFunction;
import soliloquy.specs.common.factories.IMapFactory;

/**
 * <b>Map</b>
 * <p>
 * A Map contains a number of items of a consistent type, with keys of a consistent type.
 * <p>
 * A Map will allow retrieval of an item by its key, a list of all keys, the key corresponding to
 * an item, whether that item exists, etc.
 * 
 * @author felix.t.morgenstern
 * @version 0.0.1
 *
 * @param <K> The type of key used to identify values in the Set
 * @param <V> The type of value populating the Set
 */
public interface IMap<K,V> extends IReadOnlyMap<K,V> {
	/**
	 * Clears this Map of all keys and values
	 */
	void clear();
	
	/**
	 * @param key - The key of the new pair whose presence to ensure
	 * @param value - The value of the new pair whose presence to ensure
	 * @throws IllegalArgumentException If key is null or a blank string
	 */
	void put(K key, V value) throws IllegalArgumentException;
	
	/**
	 * @param items - Key-value pairs whose presence to ensure in this Map
	 * @throws IllegalArgumentException If items is null
	 */
	void putAll(ICollection<IPair<K,V>> items) throws IllegalArgumentException;
	
	/**
	 * @param key - The item, identified by key, to remove from this Map
	 * @return The value, if and only if the item was removed (and therefore if it was present);
	 * else, null
	 */
	V removeByKey(K key);
	
	/**
	 * @param key - The key of the item to remove from this Map
	 * @param value - The value of the item to remove from this Map
	 * @return True, if and only if the item was removed (and therefore if it was present)
	 */
	boolean removeByKeyAndValue(K key, V value);
	
	/**
	 * A collection of functions used to validate all inputs to this Map. (If this is null, then
	 * all inputs are valid.)
	 * <i>Intended usage is that if the input passes validation, the validators return null;
	 * otherwise, a validator returns an exception message, thrown by an
	 * IllegalArgumentException.</i>
	 */
	ICollection<IFunction<IPair<K,V>,String>> validators();

	/**
	 * NB: This method exists so that any Map produced by a {@link IMapFactory} cannot be cast to a
	 * (non-read-only) Map by a particularly clever developer
	 * @return A read-only representation of this Map
	 */
	IReadOnlyMap<K,V> readOnlyRepresentation();
}
