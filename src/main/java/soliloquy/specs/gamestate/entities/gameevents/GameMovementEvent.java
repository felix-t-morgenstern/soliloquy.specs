package soliloquy.specs.gamestate.entities.gameevents;

import soliloquy.specs.common.shared.HasId;
import soliloquy.specs.gamestate.entities.Character;

/**
 * <b>GameMovementEvent</b>
 * <p>
 * This class describes an event which is fired when some {@link Character} attempts to step into
 * some {@link soliloquy.specs.gamestate.entities.Tile} or
 * {@link soliloquy.specs.gamestate.entities.TileFixture}
 *
 * @author felix.t.morgenstern
 * @version 0.0.1
 */
public interface GameMovementEvent extends HasId {
    /**
     * Fires this GameMovementEvent with the provided source and target.
     * <p>
     * <i>NB: If this method returns true, it is expected that the character will still be unable
     * to step into this space, if that {@link soliloquy.specs.gamestate.entities.Tile} is of a
     * {@link soliloquy.specs.ruleset.entities.GroundType} or if that
     * {@link soliloquy.specs.gamestate.entities.TileFixture} is of a
     * {@link soliloquy.specs.ruleset.entities.FixtureType} which does not permit movement. (In
     * other words, returning true does not allow a Character to walk through rocks or over water.)
     * If this method returns null, that means that if any other GameMovementEvents on that Tile
     * have returned true or false, then that result will not be changed by this event.
     * method returns null, this means that </i>
     *
     * @param character The {@link Character} causing this GameMovementEvent
     * @param target    The {@link GameEventTarget} of this GameMovementEvent
     * @return True, if character is allowed to step into the space; false, if they are not; and
     *         null, if this event does not make a decision one way or the other.
     * @throws IllegalArgumentException If and only if source or target are null
     */
    Boolean fire(Character character, GameEventTarget target)
            throws IllegalArgumentException;
}
