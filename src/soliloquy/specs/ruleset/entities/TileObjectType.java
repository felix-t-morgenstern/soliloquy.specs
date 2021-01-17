package soliloquy.specs.ruleset.entities;

import soliloquy.specs.common.infrastructure.Map;
import soliloquy.specs.common.shared.HasGlobalAccess;
import soliloquy.specs.gamestate.entities.Character;
import soliloquy.specs.gamestate.entities.Tile;
import soliloquy.specs.graphics.assets.Sprite;
import soliloquy.specs.ruleset.entities.abilities.ActiveAbility;
import soliloquy.specs.ruleset.entities.abilities.ReactiveAbility;

/**
 * <b>TileObject</b>
 * <p>
 * This is an object--either a {@link GroundType GroundType} or a
 * {@link FixtureType FixtureType}--which exists on a
 * {@link Tile Tile}.
 * 
 * @author felix.t.morgenstern
 * @version 0.0.1
 *
 */
public interface TileObjectType extends HasDefaultColorShifts, HasGlobalAccess {
	/**
	 * @return The {@link Sprite} for this TileObject
	 */
	Sprite sprite();
	
	/**
	 * This determines what happens when a Character steps into a Tile with this TileObject on it.
	 * @param character - The Character stepping into the Tile with this TileObject on it.
	 * @return True, if and only if the Character may still proceed into the Tile with this
	 * TileObject on it
	 */
	boolean onStep(Character character);
	
	/**
	 * @param character - The Character whose ability to step into the Tile with this TileObject on
	 * it is being evaluated
	 * @return True, if and only if the Character may proceed into the Tile with this TileObject on
	 * it
	 */
	boolean canStep(Character character);
	
	/**
	 * These ActiveAbilities are default behaviors of this TileObject, and will be present for
	 * every instance of this TileObject.
	 * @return A named Map of this TileObject's ActiveAbilities; e.g. Heal Nearby Allies, Generate
	 * Golem; the Ids are the AbilityTypeIds
	 * @throws IllegalStateException If this TileFixture has been deleted or if it has no
	 * FixtureType
	 */
	Map<String, ActiveAbility> activeAbilities() throws IllegalStateException;
	
	/**
	 * These ReactiveAbilities are default behaviors of this TileObject, and will be present for
	 * every instance of this TileObject.
	 * @return A named Map of this TileObject's ReactiveAbilities; e.g. Explode, Talk, Trigger
	 * Event when Investigated; the Ids are the AbilityTypeIds
	 * @throws IllegalStateException If this TileFixture has been deleted or if it has no
	 * FixtureType
	 */
	Map<String, ReactiveAbility> reactiveAbilities() throws IllegalStateException;
}
