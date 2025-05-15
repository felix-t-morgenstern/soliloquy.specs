package soliloquy.specs.common.infrastructure;

import soliloquy.specs.common.shared.HasId;

import java.util.List;

/**
 * <b>EntityGroup</b>
 * <p>
 * An EntityGroup is an immutable, ordered group of both entities of a given type (with an Id), as
 * well as subgroups, which themselves can contain both entities and subgroups.
 *
 * @param <T> The type of entity grouped
 * @author felix.t.morgenstern
 * @version 0.0.1
 */
public interface EntityGroup<T extends HasId> extends HasId {
    /**
     * @return The number of entries in this group
     */
    int size();

    /**
     * @param order The number of the entry to retrieve. (The first entry has an order of 0.)
     * @return The entry (either an entity or a group) in that slot
     * @throws IllegalArgumentException If the order requested is either below zero, or is outside
     *                                  the range of entries (i.e. if it is greater than or equal to
     *                                  their count)
     */
    Entry<T> getEntryByOrder(int order) throws IllegalArgumentException;

    /**
     * @return All the entries in this group, in order. An entry can be either an entity or a
     *         (sub)group.
     */
    List<Entry<T>> getAllGrouped();

    /**
     * @return A representation of all the entities in this group, including all subgroups
     */
    List<T> allEntities();

    /**
     * @param id The id of the entity to retrieve
     * @return The entity, if present; null if absent
     * @throws IllegalArgumentException If and only if id is null or empty
     */
    T getById(String id) throws IllegalArgumentException;

    interface Entry<T extends HasId> {
        /**
         * @return The type of this entry, i.e., whether it's an entity or a group
         */
        Type type();

        /**
         * @return The actual value of this Item, i.e., an EntityGroup
         * @throws UnsupportedOperationException If this entry is not a group
         */
        EntityGroup<T> group() throws UnsupportedOperationException;

        /**
         * @return The actual value of this Item, i.e., an Entity
         * @throws UnsupportedOperationException If this entry is not an entity
         */
        T entity() throws UnsupportedOperationException;

        enum Type {
            GROUP,
            ENTITY
        }
    }
}
