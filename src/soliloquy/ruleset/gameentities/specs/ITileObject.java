package soliloquy.ruleset.gameentities.specs;

import soliloquy.common.specs.IGlobalAccess;
import soliloquy.common.specs.IMap;
import soliloquy.gamestate.specs.ICharacter;
import soliloquy.ruleset.gameentities.abilities.specs.IActiveAbility;
import soliloquy.ruleset.gameentities.abilities.specs.IReactiveAbility;
import soliloquy.sprites.specs.ISprite;

/**
 * <b>TileObject</b>
 * <p>
 * This is an object--either a {@link IGroundType GroundType} or a
 * {@link IFixtureType FixtureType}--which exists on a
 * {@link soliloquy.gamestate.specs.ITile Tile}.
 * 
 * @author felix.t.morgenstern
 * @version 0.0.1
 *
 */
public interface ITileObject extends IGlobalAccess {
	ISprite sprite();
	
	/**
	 * This determines what happens when a Character steps into a Tile with this TileObject on it.
	 * @param character - The Character stepping into the Tile with this TileObject on it.
	 * @return True, if and only if the Character may still proceed into the Tile with this
	 * TileObject on it
	 */
	boolean onStep(ICharacter character);
	
	/**
	 * @param character - The Character whose ability to step into the Tile with this TileObject on
	 * it is being evaluated
	 * @return True, if and only if the Character may proceed into the Tile with this TileObject on
	 * it
	 */
	boolean canStep(ICharacter character);
	
	/**
	 * These ActiveAbilities are default behaviors of this TileObject, and will be present for
	 * every instance of this TileObject.
	 * @return A named Map of this TileObject's ActiveAbilities; e.g. Heal Nearby Allies, Generate
	 * Golem; the Ids are the AbilityTypeIds
	 * @throws IllegalStateException If this TileFixture has been deleted or if it has no
	 * FixtureType
	 */
	IMap<String,IActiveAbility> activeAbilities() throws IllegalStateException;
	
	/**
	 * These ReactiveAbilities are default behaviors of this TileObject, and will be present for
	 * every instance of this TileObject.
	 * @return A named Map of this TileObject's ReactiveAbilities; e.g. Explode, Talk, Trigger
	 * Event when Investigated; the Ids are the AbilityTypeIds
	 * @throws IllegalStateException If this TileFixture has been deleted or if it has no
	 * FixtureType
	 */
	IMap<String,IReactiveAbility> reactiveAbilities() throws IllegalStateException;
}
