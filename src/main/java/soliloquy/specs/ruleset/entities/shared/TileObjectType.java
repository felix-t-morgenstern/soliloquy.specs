package soliloquy.specs.ruleset.entities.shared;

import soliloquy.specs.common.shared.Direction;
import soliloquy.specs.gamestate.entities.Character;
import soliloquy.specs.gamestate.entities.Tile;
import soliloquy.specs.io.graphics.assets.ImageAsset;
import soliloquy.specs.ruleset.entities.FixtureType;
import soliloquy.specs.ruleset.entities.GroundType;

/**
 * <b>TileObject</b>
 * <p>
 * This is an object--either a {@link GroundType} or a {@link FixtureType}--which exists as a part
 * of a {@link soliloquy.specs.gamestate.entities.Tile}.
 *
 * @author felix.t.morgenstern
 * @version 0.0.1
 */
public interface TileObjectType extends HasDefaultColorShifts {
    /**
     * @return The {@link ImageAsset} for this TileObject
     */
    ImageAsset imageAsset();

    /**
     * This determines what happens when a Character steps into a Tile with this TileObject on it.
     *
     * @param character The Character stepping into the Tile with this TileObject on it.
     * @return True, if and only if the Character may still proceed into the Tile with this
     *         TileObject on it
     */
    boolean onStep(Character character);

    /**
     * @param character The Character whose ability to step into the Tile with this TileObject on
     *                  it is being evaluated
     * @return True, if and only if the Character may proceed into the Tile with this TileObject on
     *         it
     */
    boolean canStep(Character character);

    /**
     * @return The additional movement cost for moving into or onto this object
     */
    int additionalMovementCost();

    /**
     * This method describes how much a Character's Z height is raised by when moving in a provided
     * direction, e.g. stairs allowing a Character to reach higher or lower neighboring Tiles
     *
     * @param direction The direction of movement from the {@link Tile} containing this entity
     * @return The amount of escalation this entity provides to movement in the provided direction
     */
    int escalation(Direction direction);

    /**
     * This method is intended for things like stairs or ramps which make going up or down large
     * heights take up less movement
     *
     * @param tile      The {@link Tile} onto which the {@link Character} is moving
     * @param character The {@link Character} moving onto the {@link Tile}
     * @param direction The direction in which the {@link Character} is moving to get into or onto
     *                  this object
     * @return The degree to which the height movement penalty is mitigated for a {@link Character}
     *         moving in the specified direction
     */
    int heightMovementPenaltyMitigation(Tile tile, Character character, Direction direction);
}
