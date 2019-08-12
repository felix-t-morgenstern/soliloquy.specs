package soliloquy.specs.common.infrastructure;

import soliloquy.specs.common.shared.HasId;
import soliloquy.specs.common.shared.HasOneGenericParam;

/**
 * <b>Registry</b>
 * <p>
 * This class is a registry of entities; e.g.
 * {@link soliloquy.specs.ruleset.entities.CharacterType},
 * {@link soliloquy.specs.gamestate.entities.gameevents.GameEvent}; which may be passed into
 * classes, e.g. factories, which need to reference a central repository of game entity types.
 * Intended use is for there to only be one of these classes per type of entity, to be used by the
 * {@link soliloquy.specs.game.Game} or by the {@link soliloquy.specs.ruleset.Ruleset}.
 *
 * @param <T> The Type to register (e.g. {@link soliloquy.specs.ruleset.entities.CharacterType})
 *
 * @author felix.t.morgenstern
 * @version 0.0.1
 */
public interface Registry<T extends HasId> extends HasOneGenericParam<T> {
    /**
     * @param id - The Id of the type of the entity whose presence to verify
     * @return True, if and only if an item with the provided id is in this registry
     */
    boolean contains(String id);

    /**
     * @param id - The Id of the type of the entity to retrieve
     * @return The entity with that id; or null, if none exists
     */
    T get(String id);

    /**
     * @param item - The type to register into this registry. If a type with the same Id exists, it
     *             is replaced by type.
     * @throws IllegalArgumentException If and only if item is null, or has an empty or null id
     */
    void register(T item) throws IllegalArgumentException;

    /**
     * @param id - The Id of the entity to remove
     * @return True, if and only if an entity with that id was removed (and was therefore in the
     * registry)
     */
    boolean remove(String id);
}
