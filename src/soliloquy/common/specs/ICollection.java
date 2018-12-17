package soliloquy.common.specs;

/**
 * <b>Collection</b>
 * <p>
 * A grouping of some entities.
 * <p>
 * Items can be added to it.
 * <p>
 * It can be cleared.
 * <p>
 * It can be asked whether it has a specific item.
 * <p>
 * It can be asked whether it is empty.
 * <p>
 * It can be converted into an array.
 * <p>
 * It can be asked how many items it has.
 * <p>
 * Items can be removed from it.
 * 
 * @author felix.t.morgenstern
 * @version 0.0.1
 *
 * @param <V> The type of entities in this Collection
 */
public interface ICollection<V> extends Iterable<V>, ICloneable <ICollection<V>>, IHasOneGenericParam<V> {
	/**
	 * @param item - item whose presence in this collection is to be ensured
	 * @throws UnsupportedOperationException If item addition is not supported in this Collection
	 */
	void add(V item) throws UnsupportedOperationException;
	
	/**
	 * @param items - items whose presence in this collection is to be ensured
	 * @throws UnsupportedOperationException If item addition is not supported in this Collection
	 */
	void addAll(ICollection<? extends V> items) throws UnsupportedOperationException;

	/**
	 * @param items - items whose presence in this collection is to be ensured
	 * @throws UnsupportedOperationException If item addition is not supported in this Collection
	 */
	void addAll(V[] items) throws UnsupportedOperationException;
	
	/**
	 * Clears all items from this Collection
	 * @throws UnsupportedOperationException If item removal is not supported in this Collection
	 */
	void clear() throws UnsupportedOperationException;
	
	/**
	 * @param item - The item to check for
	 * @return True, if and only if the item is present in this Collection
	 */
	boolean contains(V item);
	
	/**
	 * @param items - The collection whose contents to compare to this Collection
	 * @return True, if and only if every item which is present in this Collection is present in items
	 */
	boolean equals(ICollection<V> items);
	
	/**
	 * @param index - The index in the Collection at which to retrieve the item
	 * @return The item at that index
	 */
	V get(int index);
	
	/**
	 * @return true if this Collection contains no items.
	 */
	boolean isEmpty();
	
	/**
	 * If this is a Collection of a class that can be sorted, then the resulting array will be sorted by the items' Ids.
	 * <p>
	 * <i>This method must return Object[] instead of V[], since Java cannot create generic Arrays.</i>
	 * @return An array of all values
	 */
	Object[] toArray();
	
	/**
	 * @return The number of items in the Collection
	 */
	int size();
	
	/**
	 * @param item - item to be removed from this collection, if present
	 * @return true if an element was removed as a result of this call
	 * @throws UnsupportedOperationException If item removal is not supported in this Collection
	 */
	boolean removeItem(V item) throws UnsupportedOperationException;
}
