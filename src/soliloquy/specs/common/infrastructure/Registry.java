package soliloquy.specs.common.infrastructure;

import soliloquy.specs.common.shared.HasId;
import soliloquy.specs.common.shared.HasOneGenericParam;
import soliloquy.specs.gamestate.entities.gameevents.GameMovementEvent;

import java.util.Collection;

/**
 * <b>Registry</b>
 * <p>
 * This class is a registry of entities; e.g.
 * {@link soliloquy.specs.ruleset.entities.CharacterType},
 * {@link GameMovementEvent}; which may be passed into
 * classes, e.g. factories, which need to reference a central repository of game entity types.
 * Intended use is for there to only be one of these classes per type of entity, to be used by the
 * {@link soliloquy.specs.game.Game} or by the {@link soliloquy.specs.ruleset.Ruleset}.
 *
 * @param <T> The Type to register (e.g. {@link soliloquy.specs.ruleset.entities.CharacterType})
 *
 * @author felix.t.morgenstern
 * @version 0.0.1
 */
public interface Registry<T extends HasId> extends Iterable<T>, HasOneGenericParam<T> {
    /**
     * NB: If there is already an item with the same Id as the item provided, this method
     * overwrites the previous item.
     * @param item The item to add to the registry
     * @throws IllegalArgumentException If and only if item is null
     */
    void add(T item) throws IllegalArgumentException;

    /**
     * NB: If there are already any items with the same Id as any of the items provided, this
     * method overwrites those previous items.
     * @param items The items to add to the registry
     * @throws IllegalArgumentException If and only if items is null, or if the array is not of the
     * correct type
     */
    void addAll(Object[] items) throws IllegalArgumentException;

    /**
     * NB: If there are already any items with the same Id as any of the items provided, this
     * method overwrites those previous items.
     * @param items The items to add to the registry
     * @throws IllegalArgumentException If and only if items is null
     */
    void addAll(T[] items) throws IllegalArgumentException;

    /**
     * NB: If there are already any items with the same Id as any of the items provided, this
     * method overwrites those previous items.
     * @param items The items to add to the registry
     * @throws IllegalArgumentException If and only if items is null
     */
    void addAll(Collection<T> items) throws IllegalArgumentException;

    /**
     * @param id The Id of the type of the entity whose presence to verify
     * @return True, if and only if an item with the provided id is in this registry
     * @throws IllegalArgumentException If and only if id is empty or null
     */
    boolean contains(String id) throws IllegalArgumentException;

    /**
     * @param item The entity whose presence to verify
     * @return True, if and only if that item is in this registry
     * @throws IllegalArgumentException If and only if item is null
     */
    boolean contains(T item) throws IllegalArgumentException;

    /**
     * @param id The Id of the type of the entity to retrieve
     * @return The entity with that id; or null, if none exists
     * @throws IllegalArgumentException If and only if id is empty or null
     */
    T get(String id) throws IllegalArgumentException;

    /**
     * @param id The Id of the entity to remove
     * @return True, if and only if an entity with that id was removed (and was therefore in the
     * registry)
     * @throws IllegalArgumentException If and only if id is empty or null
     */
    boolean remove(String id) throws IllegalArgumentException;

    /**
     * @param item The the entity to remove
     * @return True, if and only if an entity with that id was removed (and was therefore in the
     * registry)
     * @throws IllegalArgumentException If and only if item is null
     */
    boolean remove(T item) throws IllegalArgumentException;

    /**
     * @return The number of entities in this Registry
     */
    int size();

    /**
     * Clears the Registry of all items
     */
    void clear();

    /**
     * NB: This is a modifiable List, because it is a clone of the contents of this Registry; so,
     * modifying this returned List will not modify the contents of this Registry.
     * @return A List containing all of the entities in this Registry
     */
    java.util.List<T> representation();
}
