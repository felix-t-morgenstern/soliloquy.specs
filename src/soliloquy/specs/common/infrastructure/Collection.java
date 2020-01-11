package soliloquy.specs.common.infrastructure;

import soliloquy.specs.common.entities.Function;
import soliloquy.specs.common.factories.CollectionFactory;

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
public interface Collection<V> extends ReadableCollection<V> {
	/**
	 * @param item - item whose presence in this collection is to be ensured
	 * @throws UnsupportedOperationException If item addition is not supported in this Collection
	 */
	void add(V item) throws UnsupportedOperationException;
	
	/**
	 * @param items - items whose presence in this collection is to be ensured
	 * @throws UnsupportedOperationException If item addition is not supported in this Collection
	 */
	void addAll(Collection<? extends V> items) throws UnsupportedOperationException;

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
	 * @param item - item to be removed from this collection, if present
	 * @return true if an element was removed as a result of this call
	 * @throws UnsupportedOperationException If item removal is not supported in this Collection
	 */
	boolean remove(V item) throws UnsupportedOperationException;

	/**
	 * NB: This method exists so that any Collections produced by a {@link CollectionFactory}
	 * cannot be cast to a (non-read-only) Collection by a particularly clever developer
	 * @return A read-only representation of this Collection
	 */
	ReadableCollection<V> representation();
}
