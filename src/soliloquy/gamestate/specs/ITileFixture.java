package soliloquy.gamestate.specs;

import soliloquy.common.specs.ICollection;
import soliloquy.common.specs.ICoordinate;
import soliloquy.common.specs.IMap;
import soliloquy.ruleset.gameentities.abilities.specs.IActiveAbility;
import soliloquy.ruleset.gameentities.abilities.specs.IReactiveAbility;
import soliloquy.ruleset.gameentities.specs.IFixtureType;

/**
 * <b>TileFixture</b>
 * <p>
 * A TileFixture is an object (that is not a Character or an Item) on a Tile.
 * <p>
 * Has a FixtureType.
 * <p>
 * May have contained Items, if it its FixtureType is a container.
 * <p>
 * May have a pixel offset.
 * <p>
 * May have Active and Reactive Abilities.
 * 
 * @author felix.t.morgenstern
 * @version 0.0.1
 *
 */
public interface ITileFixture extends IGameEntity {
	/**
	 * @return The Tile on which this Fixture is affixed
	 * @throws IllegalStateException If this TileFixture has been deleted or if it has no
	 * FixtureType
	 */
	ITile tile() throws IllegalStateException;

	/**
	 * @return The FixtureType of this TileFixture
	 * @throws IllegalStateException If this TileFixture has been deleted or if it has no
	 * FixtureType
	 */
	IFixtureType fixtureType() throws IllegalStateException;
	
	/**
	 * <i>NB: This is only supposed to be a REPRESENTATION of the Items present in this TileFixture.
	 * To add or remove Items, use the other methods specified.</i>
	 * @return A Collection of the Items in this TileFixture.
	 * @throws UnsupportedOperationException If this TileFixture's FixtureType is not a container
	 * @throws IllegalStateException If this TileFixture has been deleted
	 */
	ICollection<IItem> getContainedItems()
			throws UnsupportedOperationException, IllegalStateException;

	/**
	 * @param item - The Item to add to this TileFixture
	 * @throws IllegalArgumentException If and only if item is null, or item exists elsewhere
	 * @throws IllegalStateException If this TileFixture has been deleted
	 */
	void addContainedItem(IItem item) throws IllegalArgumentException, IllegalStateException;

	/**
	 * @param item - The Item to remove from this TileFixture
	 * @return True, if and only if the Item was present, and therefore removed
	 * @throws IllegalArgumentException If and only if item is null
	 * @throws IllegalStateException If this TileFixture has been deleted
	 */
	boolean removeContainedItem(IItem item) throws IllegalArgumentException, IllegalStateException;

	/**
	 * @return The offset in pixels of this TileFixture from the defaultOffset (can be null)
	 * @throws IllegalStateException If this TileFixture has been deleted or if it has no
	 * FixtureType
	 */
	ICoordinate pixelOffset() throws IllegalStateException;
	
	/**
	 * @return A named Map of this Tile's ActiveAbilities; e.g. Heal Nearby Allies, Generate Golem;
	 * the Ids are the AbilityTypeIds
	 * @throws IllegalStateException If this TileFixture has been deleted or if it has no
	 * FixtureType
	 */
	IMap<String,IActiveAbility> activeAbilities() throws IllegalStateException;
	
	/**
	 * @return A named Map of this Tile's ReactiveAbilities; e.g. Explode, Talk, Trigger Event when
	 * Investigated; the Ids are the AbilityTypeIds
	 * @throws IllegalStateException If this TileFixture has been deleted or if it has no
	 * FixtureType
	 */
	IMap<String,IReactiveAbility> reactiveAbilities() throws IllegalStateException;
}
