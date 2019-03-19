package soliloquy.ruleset.gameentities.specs;

import soliloquy.common.specs.ICoordinate;

/**
 * <b>FixtureType</b>
 * <p>
 * This is a type of static object on a Tile which is not a Character and which cannot be picked
 * up, e.g. shrubs, chairs, piles of skulls, commodes
 * 
 * @author felix.t.morgenstern
 * @version 0.0.1
 *
 */
public interface IFixtureType extends ITileObject, IGameEntity {
	/**
	 * @return True, if and only if this FixtureType is a container (e.g. chests, bookshelves,
	 * corpses, secret cracks in the floor)
	 * @throws IllegalStateException If this FixtureType has been deleted
	 */
	boolean isContainer() throws IllegalStateException;
	
	/**
	 * @return The default offset, in pixels, from the bottom-left corner of the Tile, at which
	 * TileFixtures of this FixtureType are placed.
	 * @throws IllegalStateException If this FixtureType has been deleted
	 */
	ICoordinate defaultOffset() throws IllegalStateException;
}
