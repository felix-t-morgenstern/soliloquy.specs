package soliloquy.specs.common.shared;

import soliloquy.specs.common.infrastructure.List;
import soliloquy.specs.common.infrastructure.Pair;
import soliloquy.specs.ruleset.entities.abilities.EntityGroupWithImageAssetSet;

/**
 * <b>EntityGroupOfType</b>
 * <p>
 * An EntityGroupOfType is an ordered grouping of Entities of a certain type, and subgroupings of that
 * EntityType.
 * <p>
 * (This is used for both the top-level group, and for subgroupings.)
 * 
 * @author felix.t.morgenstern
 * @version 0.0.1
 *
 * @param <EntityType> The entity being grouped
 * @param <GroupItemType> The type of the group item (e.g. {@link EntityGroupItem} or
 * {@link EntityGroupWithImageAssetSet})
 */
public interface EntityGroupOfType<EntityType,
		GroupType extends EntityGroupOfType<EntityType, GroupType, GroupItemType>,
		GroupItemType extends EntityGroupOfTypeItem<EntityType, GroupType, GroupItemType>>
		extends SoliloquyClass {
	/**
	 * @return A representation of all of the entities and subgroupings in this grouping
	 */
	List<GroupItemType> getAllGroupedRepresentation();

	 /**
	 * @return A representation of all of the entities in this grouping, excluding subgroupings
	 */
	List<EntityType> getAllUngroupedRepresentation();
	
	/**
	 * @param order - The number of the item to retrieve. (The first item has an order of 0.)
	 * @return The EntityType or subgrouping in that slot
	 * @throws IllegalArgumentException If the order requested is either below zero, or is outside
	 * of the range of items (i.e. if it is greater than or equal to their count)
	 */
	GroupItemType getItemByOrder(int order) throws IllegalArgumentException;
	
	/**
	 * @param entity The EntityType to add to this EntityGroupOfType
	 * @param order The order in this EntityGroupOfType in which the EntityType appears. (Order numbers
	 *              do not need to be positive, consecutive, etc; they must be unique.)
	 * @param groupId The id of the grouping to which the entity is to be added; if empty or null,
	 * it is assumed that entity is added to this group (i.e. the top-level group)
	 * @throws IllegalArgumentException If order is already used within this EntityGroupOfType; or if
	 * entity is null; or if groupId is non-empty, non-null, and does not exist within this group
	 */
	void addEntity(EntityType entity, int order, String groupId) throws IllegalArgumentException;
	
	/**
	 * @param order The order in this EntityGroupOfType in which the child EntityGroupOfType appears. (Order
	 * numbers do not need to be positive, consecutive, etc; they must be unique.)
	 * @param groupId The id of the grouping to be added
	 * @param parentGroupId The id of the parent group to which this grouping will be added; if
	 * empty or null, it is assumed that the new group will be added to this group (i.e. the
	 * top-level group)
	 * @throws IllegalArgumentException If order is already used within this EntityGroupOfType
	 */
	void newSubgrouping(int order, String groupId, String parentGroupId) throws IllegalArgumentException;
	
	/**
	 * @param id The id of the item in this group to be deleted
	 * @return True, if and only if an item exists (and was successfully deleted)
	 * @throws IllegalArgumentException If and only if id is null or blank
	 */
	boolean removeItem(String id) throws IllegalArgumentException;

	/**
	 * @param itemId The id of the item for which to search
	 * @return A pair containing the Id of the grouping of the item with itemId (if it is in the
	 * top-level grouping, then null is returned), and the order of the item within that grouping
	 * @throws IllegalArgumentException If itemId is blank or null, or an item with the specified
	 * id does not exist
	 */
	Pair<String,Integer> getGroupingIdAndOrder(String itemId) throws IllegalArgumentException;
}
