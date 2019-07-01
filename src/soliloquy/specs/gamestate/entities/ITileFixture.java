package soliloquy.specs.gamestate.entities;

import soliloquy.specs.common.valueobjects.ICoordinate;
import soliloquy.specs.common.infrastructure.IMap;
import soliloquy.specs.ruleset.entities.abilities.IActiveAbility;
import soliloquy.specs.ruleset.entities.abilities.IReactiveAbility;
import soliloquy.specs.ruleset.entities.IFixtureType;

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

	/**
	 * @return A class by which items contained in this fixture may be accessed and altered
	 * @throws IllegalStateException If this TileFixture has been deleted or if it has no
	 * FixtureType
	 */
	ITileFixtureItems containedItems() throws IllegalStateException;

	/**
	 * <b>NB: This method is intended to <u>only</u> be used by
	 * {@link ITileFixtures#addTileFixture} and {@link ITileFixtures#removeTileFixture}; it is
	 * intended to check whether the Tile assigned to this TileFixture has this TileFixture on it,
	 * prior to assignment.</b>
	 * @param tile - The Tile to which to assign to this TileFixture
	 * @throws IllegalArgumentException If and only if tile is null, or tile does not contain this
	 * TileFixture
	 * @throws IllegalStateException If this TileFixture has been deleted or if it has no
	 * FixtureType
	 */
	void assignTileFixtureToTile(ITile tile) throws IllegalArgumentException, IllegalStateException;
}
