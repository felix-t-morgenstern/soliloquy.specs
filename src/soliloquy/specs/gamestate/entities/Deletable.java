package soliloquy.specs.gamestate.entities;

import soliloquy.specs.common.shared.SoliloquyClass;

/**
 * <b>Deletable</b>
 * <p>
 * This class is one which can be deleted. The delete operation is intended to both remove
 * references to a class so it can be removed from memory by the garbage collector, as well as to
 * take down any two-way bindings between entities (e.g. between a GameZone and its Characters).
 *
 * @author felix.t.morgenstern
 * @version 0.0.1
 */
public interface Deletable extends SoliloquyClass {
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
