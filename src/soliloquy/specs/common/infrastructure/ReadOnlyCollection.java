package soliloquy.specs.common.infrastructure;

import soliloquy.specs.common.shared.Cloneable;
import soliloquy.specs.common.shared.HasOneGenericParam;

/**
 * <b>ReadOnlyCollection</b>
 * <p>
 * A grouping of some entities. An implementation of this class cannot alter the contents of this
 * Collection; {@link Collection} supports those operations.
 *
 * @author felix.t.morgenstern
 * @version 0.0.1
 *
 * @param <V> The type of entities in this Collection
 */
public interface ReadOnlyCollection<V> extends Iterable<V>, Cloneable<Collection<V>>,
        HasOneGenericParam<V> {
    /**
     * @param item - The item to check for
     * @return True, if and only if the item is present in this Collection
     */
    boolean contains(V item);

    /**
     * @param items - The collection whose contents to compare to this Collection
     * @return True, if and only if every item which is present in this Collection is present in
     * items
     */
    boolean equals(ReadOnlyCollection<V> items);

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
     * If this is a Collection of a class that can be sorted, then the resulting array will be
     * sorted by the items' Ids.
     * <p>
     * <i>This method must return Object[] instead of V[], since Java cannot create generic
     * Arrays.</i>
     * @return An array of all values
     */
    Object[] toArray();

    /**
     * @return The number of items in the Collection
     */
    int size();
}
