package soliloquy.specs.ruleset.entities;

import soliloquy.specs.common.shared.IHasGlobalAccess;
import soliloquy.specs.common.valueobjects.IMap;
import soliloquy.specs.gamestate.entities.ICharacter;
import soliloquy.specs.ruleset.entities.abilities.IActiveAbility;
import soliloquy.specs.ruleset.entities.abilities.IReactiveAbility;
import soliloquy.specs.gamestate.entities.ITile;
import soliloquy.specs.sprites.entities.ISprite;

/**
 * <b>TileObject</b>
 * <p>
 * This is an object--either a {@link IGroundType GroundType} or a
 * {@link IFixtureType FixtureType}--which exists on a
 * {@link ITile Tile}.
 * 
 * @author felix.t.morgenstern
 * @version 0.0.1
 *
 */
public interface ITileObjectType extends IHasGlobalAccess {
	/**
	 * @return The {@link ISprite} for this TileObject
	 */
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
