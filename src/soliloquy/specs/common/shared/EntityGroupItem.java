package soliloquy.specs.common.shared;

/**
 * <b>EntityGroupItem</b>
 * <p>
 * An {@link EntityGroupOfTypeItem}, without any exotic features. This class exists to simplify
 * type declarations.
 *
 * @param <EntityType> The entity being grouped
 * @author felix.t.morgenstern
 * @version 0.0.1
 */
public interface EntityGroupItem<EntityType>
        extends EntityGroupOfTypeItem<EntityType, EntityGroup<EntityType>,
        EntityGroupItem<EntityType>> {
}
