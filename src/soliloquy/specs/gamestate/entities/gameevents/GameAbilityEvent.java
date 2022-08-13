package soliloquy.specs.gamestate.entities.gameevents;

import soliloquy.specs.common.shared.HasGlobalAccess;
import soliloquy.specs.common.shared.HasId;
import soliloquy.specs.gamestate.entities.abilities.AbilitySource;
import soliloquy.specs.ruleset.entities.abilities.Ability;

/**
 * <b>GameAbilityEvent</b>
 * <p>
 * This class describes an event which is fired when some
 * {@link soliloquy.specs.gamestate.entities.Character} attempts to step into some
 * {@link soliloquy.specs.gamestate.entities.Tile} or
 * {@link soliloquy.specs.gamestate.entities.TileFixture}
 *
 * @author felix.t.morgenstern
 * @version 0.0.1
 */
public interface GameAbilityEvent extends HasId, HasGlobalAccess {
    /**
     * Fires this Event with the provided source and target.
     *
     * @param source The source Character or Item of the {@link Ability} causing this
     *               GameAbilityEvent
     * @param target The {@link GameEventTarget} of this GameMovementEvent
     * @throws IllegalArgumentException If and only if source or target are null
     */
    void fire(AbilitySource source, Ability ability, GameEventTarget target)
            throws IllegalArgumentException;
}
