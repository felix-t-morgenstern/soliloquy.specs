package soliloquy.gamestate.specs;

import soliloquy.common.specs.IGenericParamsSet;
import soliloquy.common.specs.IHasName;

/**
 * <b>GameEntity</b>
 * <p>
 * Specifies common properties for entities that exist in the GameWorld.
 * <p>
 * All entities that exist in the GameWorld have a String Id and a name. They can be read from a
 * file and written to a file.
 * 
 * @author felix.t.morgenstern
 * @version 0.0.1
 *
 */
public interface IGameEntity extends IHasName {
	/**
	 * This is useful when an entity needs to be completely removed from a GameZone (so it can be
	 * cleared away by the garbage collector)
	 * @return This entity's GameZone.
	 * @throws IllegalStateException If this entity does not have a GameZone, or If this entity
	 * does not have a GameZone, or if this entity has been deleted, or if this entity has no Id
	 */
	IGameZone gameZone() throws IllegalStateException;
	
	/**
	 * @return Any parameters regarding this entity which do not fit neatly into any of their other
	 * properties.
	 * @throws IllegalStateException If this Item has been deleted
	 */
	IGenericParamsSet data() throws IllegalStateException;
	
	/**
	 * Deletes this entity. After an entity is deleted, any call to its members should return an
	 * IllegalStateException.
	 * <p>
	 * Intended use of this method is to delete all GameEntities contained within this GameEntity.
	 * So, when deleting a Tile, all Items, Fixtures, and Characters on that Tile are deleted. When
	 * deleting a Fixture, all Items it contains are deleted. When deleting a Character, all Items
	 * held by that Character (in inventory or equipment) are deleted.
	 * @throws IllegalStateException If this entity has already been deleted 
	 */
	void delete() throws IllegalStateException;
	
	/**
	 * This method is intended to be used in cases where this entity has been deleted (by the
	 * delete method), but this object has not been deleted by the garbage collector.
	 * @return True if and only if this entity has been deleted
	 */
	boolean isDeleted();
}
