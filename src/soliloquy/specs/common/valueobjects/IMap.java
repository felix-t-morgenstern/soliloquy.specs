package soliloquy.specs.common.valueobjects;

import soliloquy.specs.common.entities.IFunction;
import soliloquy.specs.common.shared.ICloneable;
import soliloquy.specs.common.shared.IHasTwoGenericParams;

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
public interface IMap<K,V> extends Iterable<IPair<K,V>>, IHasTwoGenericParams<K,V>, ICloneable<IMap<K,V>> {
	/**
	 * Clears this Map of all keys and values
	 */
	void clear();
	
	/**
	 * @param key - The key for which to check
	 * @return True, if and only key is a key present in this Map
	 */
	boolean containsKey(K key);
	
	/**
	 * @param value - The value for which to check
	 * @return True, if and only value is a value present in this Map
	 */
	boolean containsValue(V value);
	
	/**
	 * @param item - The key-value pair for which to check
	 * @return True, if and only if item is a key-value pair present in this Map
	 * @throws IllegalArgumentException If item is null
	 */
	boolean contains(IPair<K,V> item) throws IllegalArgumentException;
	
	/**
	 * @param items - The Collection whose contents to compare to this Map
	 * @return True, if and only if every item which is present in items is a value present in this
	 * Map
	 * @throws IllegalArgumentException If items is null
	 */
	boolean equals(ICollection<V> items) throws IllegalArgumentException;
	
	/**
	 * @param map - The Map to compare to this Map
	 * @return True, if and only if every key in this Map is present in map, and if every key in
	 * this Map corresponds to the same value in map
	 * @throws IllegalArgumentException If map is null
	 */
	boolean equals(IMap<K,V> map) throws IllegalArgumentException;
	
	/**
	 * Gets the entity, specified by its key.
	 * @param key - The key of the item to retrieve
	 * @return	Returns the entity with the associated key. (If it isn't in the Map, it returns
	 * null.)
	 * @throws IllegalArgumentException If the provided key is null, a blank String, etc.
	 * Additionally, if this Map is only expecting a limited set of keys, and key is not one of
	 * those keys, this exception will be thrown.
	 * @throws IllegalStateException If this Map is a Set of entities with keys, and the entity
	 * obtained by this method does not have the same key as the parameter provided to this method,
	 * this exception will be thrown. Additionally, if this Map is expecting a value for every key
	 * requested, and a value does not exist for the requested key, this exception will be thrown. 
	 */
	V get(K key) throws IllegalArgumentException, IllegalStateException;
	
	/**
	 * @return An array of all of the keys in this Map
	 */
	ICollection<K> getKeys();
	
	/**
	 * @return An array of all of the values in this Map
	 */
	ICollection<V> getValues();
	
	/**
	 * @param item - The item to check for in this Map
	 * @return The keys of the item in this map. (If it isn't in the Map, it returns an empty
	 * collection.)
	 */
	ICollection<K> indicesOf(V item);
	
	/**
	 * @return true if this Map contains no items.
	 */
	boolean isEmpty();
	
	/**
	 * @param key - The key to check for in this Map
	 * @return True, if and only if an entry in this Map with that key exists
	 */
	boolean itemExists(K key);
	
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
	 * @param key - The value of the item to remove from this Map
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
	 * @return The number of items in the Map
	 */
	int size();
}
