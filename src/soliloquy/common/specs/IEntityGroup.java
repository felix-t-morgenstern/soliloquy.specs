package soliloquy.common.specs;

import soliloquy.sprites.specs.ISpriteSet;

/**
 * <b>EntityGroup</b>
 * <p>
 * An EntityGroup is an ordered grouping of Entities of a certain type, and subgroupings of that Entity.
 * <p>
 * (This is used for both the top-level group, and for subgroupings.)
 * 
 * @author felix.t.morgenstern
 * @version 0.0.1
 *
 * @param <Entity> The entity being grouped
 */
public interface IEntityGroup<Entity> extends IHasName, ISoliloquyClass {
	/**
	 * @return All of the entities/subgroupings in this grouping
	 */
	ICollection<IEntityGroupItem<Entity>> getAllGrouped();
	
	/**
	 * @param order - The number of the item to retrieve. (The first item has an order of 0.)
	 * @return The Entity or subgrouping in that slot
	 * @throws IllegalArgumentException If the order requested is either below zero, or is outside of the range of items (i.e. if it is greater than or equal to their count)
	 */
	IEntityGroupItem<Entity> getItemByOrder(int order) throws IllegalArgumentException;
	
	/**
	 * A grouping can require a SpriteSet if it has UI elements required to navigate that Group.
	 * <p>
	 * (E.g. buttons for opening up a sub-menu or a drop-down menu, Sprites to include in the menu, etc.)
	 * <p>
	 * This is primarily intended for ActiveAbilities.
	 * @return The SpriteSet associated with this EntityGroup
	 */
	ISpriteSet spriteSet();
}
