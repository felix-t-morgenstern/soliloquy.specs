package soliloquy.specs.ruleset.entities.abilities;

import soliloquy.specs.common.shared.EntityGroup;
import soliloquy.specs.common.infrastructure.List;
import soliloquy.specs.common.shared.SoliloquyClass;
import soliloquy.specs.graphics.assets.ImageAssetSet;

/**
 * <b>EntityGroupWithImageAssetSet</b>
 * <p>
 * (This interface is analogous to {@link EntityGroup}, with the difference
 * being that it provides a ImageAssetSet for each grouping.)
 * 
 * @author felix.t.morgenstern
 * @version 0.0.1
 *
 * @param <Entity> The entity being grouped
 */
// TODO: Figure out if there's a way to have this interface extend EntityGroup; otherwise, update it with EntityGroup's methods
public interface EntityGroupWithImageAssetSet<Entity> extends SoliloquyClass {
	/**
	 * @return All of the entities/subgroupings in this grouping
	 */
	List<EntityGroupWithImageAssetSetItem<Entity>> getAllGrouped();
	
	/**
	 * @param order - The number of the item to retrieve. (The first item has an order of 0.)
	 * @return The Entity or subgrouping in that slot
	 * @throws IllegalArgumentException If the order requested is either below zero, or is outside
	 * of the range of items (i.e. if it is greater than or equal to their count)
	 */
	EntityGroupWithImageAssetSetItem<Entity> getItemByOrder(int order)
			throws IllegalArgumentException;
	
	/**
	 * A ImageAssetSet with UI elements required to navigate that Group.
	 * <p>
	 * (E.g. buttons for opening up a sub-menu or a drop-down menu, Sprites to include in the menu,
	 * etc.)
	 * <p>
	 * This is primarily intended for ActiveAbilities.
	 * @return The ImageAssetSet associated with this EntityGroup
	 */
	ImageAssetSet imageAssetSet();
}
