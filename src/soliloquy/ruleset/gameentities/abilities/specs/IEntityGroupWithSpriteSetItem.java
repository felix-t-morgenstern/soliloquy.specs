package soliloquy.ruleset.gameentities.abilities.specs;

import soliloquy.common.specs.ISoliloquyClass;

/**
 * <b>EntityGroupWithSpriteSetItem</b>
 * <p>
 * (This interface is analogous to {@link soliloquy.common.specs.IEntityGroupItem}, with the difference being that if the GroupItem is a Group, it returns an {@link soliloquy.ruleset.gameentities.abilities.specs.IEntityGroupWithSpriteSet} instead of an {@link soliloquy.common.specs.IEntityGroup}.)
 * 
 * @author felix.t.morgenstern
 * @version 0.0.1
 *
 * @param <Entity> The type of Entity being grouped
 */
public interface IEntityGroupWithSpriteSetItem<Entity> extends ISoliloquyClass {
	// NB: There MUST be an invariant that ONLY
	//     one or the other of these should return
	//     an object.
	// NB: There should also be an invariant that
	//     'order' values within a Group should be
	//     unique.
	
	/**
	 * @return The order of this entity or subgrouping within the EntityGroup
	 */
	int getOrder();
	
	/**
	 * @param order - The order to set for this entity or subgrouping within the EntityGroup
	 */
	void setOrder(int order);
	
	/**
	 * @return True, if and only if this EntityGroupItem is a subgrouping, and not an Entity
	 */
	boolean isGroup();
	
	/**
	 * Initializes the actual value of this EntityGroupItem; in this case, a subgrouping, i.e. an EntityGroup
	 * @param group - The EntityGroup to which to set this EntityGroupItem's actual value
	 * @throws IllegalArgumentException If the group provided is illegal, e.g. if it is a duplicate, if it is null, if it is empty, etc.
	 * @throws UnsupportedOperationException If either the EntityGroup or Entity for this EntityGroupItem has been initialized
	 */
	void initializeGroup(IEntityGroupWithSpriteSet<Entity> group) throws IllegalArgumentException, UnsupportedOperationException;

	/**
	 * @return The actual value of this EntityGroupItem, i.e., an EntityGroup subgrouping
	 * @throws UnsupportedOperationException If this EntityGroupItem is not a subgrouping, i.e. an EntityGroup
	 */
	IEntityGroupWithSpriteSet<Entity> group() throws UnsupportedOperationException;
	
	/**
	 * Initializes the actual value of this EntityGroupItem; in this case, an Entity
	 * @param group - The Entity to which to set this EntityGroupItem's actual value
	 * @throws IllegalArgumentException If the entity provided is illegal, e.g. if it is null, if it is a duplicate, etc.
	 * @throws UnsupportedOperationException If either the EntityGroup or Entity for this EntityGroupItem has been initialized
	 */
	void initializeEntity(Entity entity) throws IllegalArgumentException, UnsupportedOperationException;

	/**
	 * @return The actual value of this EntityGroupItem, i.e., an Entity
	 * @throws UnsupportedOperationException If this EntityGroupItem is not an Entity
	 */
	Entity entity() throws UnsupportedOperationException;
}
