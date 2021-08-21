package soliloquy.specs.common.shared;

/**
 * <b>EntityGroupItem</b>
 * <p>
 * An {@link EntityGroupOfTypeItem}, without any exotic features. This class exists to simplify
 * type declarations.
 *
 * @author felix.t.morgenstern
 * @version 0.0.1
 *
 * @param <EntityType> The entity being grouped
 */
public interface EntityGroupItem<EntityType>
        extends EntityGroupOfTypeItem<EntityType, EntityGroup<EntityType>,
        EntityGroupItem<EntityType>> {
}
