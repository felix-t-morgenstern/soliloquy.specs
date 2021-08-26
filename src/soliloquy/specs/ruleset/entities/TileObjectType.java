package soliloquy.specs.ruleset.entities;

import soliloquy.specs.common.shared.HasGlobalAccess;
import soliloquy.specs.gamestate.entities.Character;
import soliloquy.specs.graphics.assets.ImageAsset;

/**
 * <b>TileObject</b>
 * <p>
 * This is an object--either a {@link GroundType} or a {@link FixtureType}--which exists as a part
 * of a {@link soliloquy.specs.gamestate.entities.Tile}.
 * 
 * @author felix.t.morgenstern
 * @version 0.0.1
 *
 */
public interface TileObjectType extends HasDefaultColorShifts, HasGlobalAccess {
	/**
	 * @return The {@link ImageAsset} for this TileObject
	 */
	ImageAsset imageAsset();
	
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
}
