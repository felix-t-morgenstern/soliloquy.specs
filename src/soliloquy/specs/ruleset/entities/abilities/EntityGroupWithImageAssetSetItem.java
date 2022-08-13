package soliloquy.specs.ruleset.entities.abilities;

import soliloquy.specs.common.shared.EntityGroupOfType;
import soliloquy.specs.common.shared.EntityGroupOfTypeItem;
import soliloquy.specs.graphics.assets.ImageAssetSet;

/**
 * <b>EntityGroupWithImageAssetSetItem</b>
 * <p>
 * (This interface is analogous to {@link EntityGroupOfTypeItem}, with the
 * difference being that if the GroupItem is a Group, it returns an
 * {@link EntityGroupWithImageAssetSet} instead of an
 * {@link EntityGroupOfType}.)
 *
 * @param <EntityType> The type of Entity being grouped
 * @author felix.t.morgenstern
 * @version 0.0.1
 */
public interface EntityGroupWithImageAssetSetItem<EntityType>
        extends EntityGroupOfTypeItem<EntityType, EntityGroupWithImageAssetSet<EntityType>,
        EntityGroupWithImageAssetSetItem<EntityType>> {
    /**
     * @return The ImageAssetSet corresponding to this grouped entity (e.g. button
     *         {@link soliloquy.specs.graphics.assets.ImageAsset}s corresponding to the button(s)
     *         for this
     *         Entity)
     */
    ImageAssetSet imageAssetSet();
}
