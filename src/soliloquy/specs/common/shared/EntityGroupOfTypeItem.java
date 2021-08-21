package soliloquy.specs.common.shared;

/**
 * <b>EntityGroupOfTypeItem</b>
 * <p>
 * It is an item in an EntityGroupOfType, which is either an Entity, or a subgrouping--i.e. another
 * EntityGroupOfType.
 * 
 * @author felix.t.morgenstern
 * @version 0.0.1
 *
 * @param <EntityType> The type of Entity being grouped
 * @param <GroupItemType> The type of EntityGroupOfTypeItem (e.g. {@link EntityGroupItem} or
 * {@link soliloquy.specs.ruleset.entities.abilities.EntityGroupWithImageAssetSetItem})
 */
public interface EntityGroupOfTypeItem<EntityType,
		GroupType extends EntityGroupOfType<EntityType, GroupType, GroupItemType>,
		GroupItemType extends EntityGroupOfTypeItem<EntityType, GroupType, GroupItemType>>
		extends HasOneGenericParam<EntityType> {
	/**
	 * @return True, if and only if this EntityGroupOfTypeItem is a subgrouping, and not an Entity
	 */
	boolean isGroup();
	
	/**
	 * Initializes the actual value of this EntityGroupOfTypeItem; in this case, a subgrouping, i.e. an
	 * EntityGroupOfType
	 * @param group - The EntityGroupOfType to which to set this EntityGroupOfTypeItem's actual value
	 * @throws IllegalArgumentException If the group provided is illegal, e.g. if it is a
	 * duplicate, if it is null, if it is empty, etc.
	 * @throws UnsupportedOperationException If either the EntityGroupOfType or Entity for this
	 * EntityGroupOfTypeItem has been initialized
	 */
	void initializeGroup(GroupType group)
			throws IllegalArgumentException, UnsupportedOperationException;

	/**
	 * @return The actual value of this EntityGroupOfTypeItem, i.e., an EntityGroupOfType subgrouping
	 * @throws UnsupportedOperationException If this EntityGroupOfTypeItem is not a subgrouping, i.e. an
	 * EntityGroupOfType
	 */
	GroupType group() throws UnsupportedOperationException;
	
	/**
	 * Initializes the actual value of this EntityGroupOfTypeItem; in this case, an Entity
	 * @param entity - The Entity to which to set this EntityGroupOfTypeItem's actual value
	 * @throws IllegalArgumentException If the entity provided is illegal, e.g. if it is null, if
	 * it is a duplicate, etc.
	 * @throws UnsupportedOperationException If either the EntityGroupOfType or Entity for this
	 * EntityGroupOfTypeItem has been initialized
	 */
	void initializeEntity(EntityType entity)
			throws IllegalArgumentException, UnsupportedOperationException;

	/**
	 * @return The actual value of this EntityGroupOfTypeItem, i.e., an Entity
	 * @throws UnsupportedOperationException If this EntityGroupOfTypeItem is not an Entity
	 */
	EntityType entity() throws UnsupportedOperationException;
}
