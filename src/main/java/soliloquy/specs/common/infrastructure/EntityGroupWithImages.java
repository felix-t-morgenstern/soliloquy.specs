package soliloquy.specs.common.infrastructure;

import soliloquy.specs.common.shared.HasId;
import soliloquy.specs.ruleset.entities.shared.HasImageAssetSet;

public interface EntityGroupWithImages<TEntityType extends HasId>
        extends EntityGroup<TEntityType>, HasImageAssetSet {
}
