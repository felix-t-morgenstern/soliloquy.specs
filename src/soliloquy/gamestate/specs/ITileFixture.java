package soliloquy.gamestate.specs;

import soliloquy.common.specs.ICollection;
import soliloquy.common.specs.ICoordinate;
import soliloquy.common.specs.IMap;
import soliloquy.common.specs.ISoliloquyClass;
import soliloquy.ruleset.gameentities.abilities.specs.IActiveAbility;
import soliloquy.ruleset.gameentities.abilities.specs.IReactiveAbility;
import soliloquy.ruleset.gameentities.specs.IFixtureType;
import soliloquy.ruleset.gameentities.specs.IGameEntity;

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
 *
 */
public interface ITileFixture extends IGameEntity, ISoliloquyClass {
	/**
	 * @return The FixtureType of this TileFixture
	 * @throws IllegalStateException If this TileFixture has been deleted or if it has no FixtureType
	 */
	IFixtureType getFixtureType() throws IllegalStateException;
	
	/**
	 * @param fixtureType - The FixtureType to which to set this TileFixture
	 * @throws IllegalStateException If this TileFixture has been deleted
	 */
	void setFixtureType(IFixtureType fixtureType) throws IllegalStateException;
	
	/**
	 * @return A Collection of the Items in this TileFixture.
	 * @throws UnsupportedOperationException If this TileFixture's FixtureType is not a container
	 * @throws IllegalStateException If this TileFixture has been deleted or if it has no FixtureType
	 */
	ICollection<IItem> containedItems() throws UnsupportedOperationException, IllegalStateException;

	/**
	 * @return The offset in pixels of this TileFixture from the defaultOffset (can be null)
	 * @throws IllegalStateException If this TileFixture has been deleted or if it has no FixtureType
	 */
	ICoordinate getPixelOffset() throws IllegalStateException;
	
	/**
	 * @param pixelOffset - The offset in pixels from the defaultOffset to set for this TileFixture (can be null)
	 * @throws IllegalStateException If this TileFixture has been deleted or if it has no FixtureType
	 */
	void setPixelOffset(ICoordinate pixelOffset) throws IllegalStateException;
	
	/**
	 * @return A named Map of this Tile's ActiveAbilities; e.g. Heal Nearby Allies, Generate Golem; the Ids are the AbilityTypeIds
	 * @throws IllegalStateException If this TileFixture has been deleted or if it has no FixtureType
	 */
	IMap<String,IActiveAbility> activeAbilities() throws IllegalStateException;
	
	/**
	 * @return A named Map of this Tile's ReactiveAbilities; e.g. Explode, Talk, Trigger Event when Investigated; the Ids are the AbilityTypeIds
	 * @throws IllegalStateException If this TileFixture has been deleted or if it has no FixtureType
	 */
	IMap<String,IReactiveAbility> reactiveAbilities() throws IllegalStateException;
}
