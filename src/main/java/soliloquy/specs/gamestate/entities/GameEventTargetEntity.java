package soliloquy.specs.gamestate.entities;

import soliloquy.specs.gamestate.entities.gameevents.GameAbilityEvent;
import soliloquy.specs.gamestate.entities.gameevents.GameEventTarget;
import soliloquy.specs.gamestate.entities.gameevents.GameMovementEvent;
import soliloquy.specs.ruleset.entities.abilities.Ability;

import java.util.List;

/**
 * <b>GameEventTargetEntity</b>
 * <p>
 * This class has a {@link List} of {@link GameMovementEvent}s, to be fired when this object is the
 * target of an incoming {@link Ability}, or when a {@link Character} walks into this object.
 *
 * @author felix.t.morgenstern
 * @version 0.0.1
 */
public interface GameEventTargetEntity extends GameEntity {
    /**
     * @return A {@link List} of {@link GameMovementEvent}s, triggered when a {@link Character}
     *         steps on this entity.
     * @throws IllegalStateException If this entity has been deleted
     */
    List<GameMovementEvent> movementEvents() throws IllegalStateException;

    /**
     * An example of this is a barrel being burned away by a fireball.
     * @return A {@link List} of {@link GameMovementEvent}s, triggered when a {@link Character} or
     *         {@link Item} uses an {@link Ability} on this entity.
     * @throws IllegalStateException If this entity has been deleted
     */
    List<GameAbilityEvent> abilityEvents() throws IllegalStateException;

    /**
     * @return A {@link GameEventTarget} corresponding to this entity
     * @throws IllegalStateException If this entity has been deleted
     */
    GameEventTarget makeGameEventTarget() throws IllegalStateException;
}
