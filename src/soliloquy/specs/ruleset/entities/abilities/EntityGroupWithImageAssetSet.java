package soliloquy.specs.ruleset.entities.abilities;

import soliloquy.specs.common.shared.EntityGroupOfType;
import soliloquy.specs.graphics.assets.ImageAssetSet;

/**
 * <b>EntityGroupWithImageAssetSet</b>
 * <p>
 * (This interface is analogous to {@link EntityGroupOfType}, with the difference
 * being that it provides a ImageAssetSet for each grouping.)
 * 
 * @author felix.t.morgenstern
 * @version 0.0.1
 *
 * @param <EntityType> The entity being grouped
 */
public interface EntityGroupWithImageAssetSet<EntityType>
		extends EntityGroupOfType<EntityType, EntityGroupWithImageAssetSet<EntityType>,
				EntityGroupWithImageAssetSetItem<EntityType>> {
	/**
	 * A ImageAssetSet with UI elements required to navigate that Group.
	 * <p>
	 * (E.g. buttons for opening up a sub-menu or a drop-down menu, Sprites to include in the menu,
	 * etc.)
	 * <p>
	 * This is primarily intended for ActiveAbilities.
	 * @return The ImageAssetSet associated with this EntityGroupOfType
	 */
	ImageAssetSet imageAssetSet();
}
