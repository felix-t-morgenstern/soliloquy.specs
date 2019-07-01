package soliloquy.specs.common.shared;

import soliloquy.specs.common.infrastructure.ICollection;
import soliloquy.specs.common.infrastructure.IPair;

/**
 * <b>EntityGroup</b>
 * <p>
 * An EntityGroup is an ordered grouping of Entities of a certain type, and subgroupings of that
 * Entity.
 * <p>
 * (This is used for both the top-level group, and for subgroupings.)
 * 
 * @author felix.t.morgenstern
 * @version 0.0.1
 *
 * @param <Entity> The entity being grouped
 */
public interface IEntityGroup<Entity> extends ISoliloquyClass {
	/**
	 * @return All of the entities/subgroupings in this grouping
	 */
	ICollection<IEntityGroupItem<Entity>> getAllGrouped();
	
	/**
	 * @return All of the entities in this grouping
	 */
	ICollection<Entity> getAllUngrouped();
	
	/**
	 * @param order - The number of the item to retrieve. (The first item has an order of 0.)
	 * @return The Entity or subgrouping in that slot
	 * @throws IllegalArgumentException If the order requested is either below zero, or is outside
	 * of the range of items (i.e. if it is greater than or equal to their count)
	 */
	IEntityGroupItem<Entity> getItemByOrder(int order) throws IllegalArgumentException;
	
	/**
	 * @param entity The Entity to add to this EntityGroup
	 * @param order The order in this EntityGroup in which the Entity appears. (Order numbers do
	 * not need to be positive, consecutive, etc; they must be unique.)
	 * @param groupId The id of the grouping to which the entity is to be added; if empty or null,
	 * it is assumed that entity is added to this group (i.e. the top-level group)
	 * @throws IllegalArgumentException If order is already used within this EntityGroup; or if
	 * entity is null; or if groupId is non-empty, non-null, and does not exist within this group
	 */
	void addEntity(Entity entity, int order, String groupId) throws IllegalArgumentException;
	
	/**
	 * @param order The order in this EntityGroup in which the child EntityGroup appears. (Order
	 * numbers do not need to be positive, consecutive, etc; they must be unique.)
	 * @param groupId The id of the grouping to be added
	 * @param parentGroupId The id of the parent group to which this grouping will be added; if
	 * empty or null, it is assumed that the new group will be added to this group (i.e. the
	 * top-level group)
	 * @throws IllegalArgumentException If order is already used within this EntityGroup
	 */
	void newSubgrouping(int order, String groupId, String parentGroupId) throws IllegalArgumentException;
	
	/**
	 * @param order The order number of the item in this group to be deleted
	 * @return True, if and only if an item exists (and was successfully deleted)
	 * @throws IllegalArgumentException If and only if itemId is null or blank
	 */
	boolean removeItem(String itemId) throws IllegalArgumentException;

	/**
	 * @param itemId The id of the item for which to search
	 * @return A pair containing the Id of the grouping of the item with itemId (if it is in the
	 * top-level grouping, then null is returned), and the order of the item within that grouping
	 * @throws IllegalArgumentException If itemId is blank or null, or an item with the specified
	 * id does not exist
	 */
	IPair<String,Integer> getGroupingIdAndOrder(String itemId) throws IllegalArgumentException;
}
