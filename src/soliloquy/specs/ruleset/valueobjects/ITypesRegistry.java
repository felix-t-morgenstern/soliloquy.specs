package soliloquy.specs.ruleset.valueobjects;

import soliloquy.specs.common.shared.IHasId;
import soliloquy.specs.ruleset.entities.ICharacterType;
import soliloquy.specs.ruleset.entities.IItemType;

/**
 * <b>TypesRegistry</b>
 * <p>
 * This class is a registry of types of entities; e.g. {@link ICharacterType}, {@link IItemType};
 * which may be passed into classes, e.g. factories, which need to reference a central repository
 * of game entity types. Intended use is for there to only be one of these classes, and for it to
 * be used by the Ruleset to register types.
 *
 * @param <T> The Type to register (e.g. {@link ICharacterType})
 *
 * @author felix.t.morgenstern
 * @version 0.0.1
 */
public interface ITypesRegistry<T extends IHasId> {
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
     * @param type - The type to register into this registry. If a type with the same Id exists, it
     *             is replaced by type.
     */
    void register(T type);

    /**
     * @param id - The Id of the entity to remove
     * @return True, if and only if an entity with that id was removed (and was therefore in the
     * registry)
     */
    boolean remove(String id);
}
