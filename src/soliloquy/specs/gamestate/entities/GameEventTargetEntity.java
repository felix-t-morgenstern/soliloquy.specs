package soliloquy.specs.gamestate.entities;

import soliloquy.specs.common.infrastructure.List;
import soliloquy.specs.common.shared.SoliloquyClass;
import soliloquy.specs.gamestate.entities.gameevents.GameAbilityEvent;
import soliloquy.specs.gamestate.entities.gameevents.GameEventTarget;
import soliloquy.specs.gamestate.entities.gameevents.GameMovementEvent;

/**
 * <b>GameEventTargetEntity</b>
 * <p>
 * This class has a {@link List} of {@link GameMovementEvent}s, to be fired when this object
 * is the target of an incoming {@link soliloquy.specs.ruleset.entities.abilities.Ability}, or when
 * a {@link Character} walks into this object.
 *
 * @author felix.t.morgenstern
 * @version 0.0.1
 */
public interface GameEventTargetEntity extends SoliloquyClass {
    /**
     * @return A {@link List} of {@link GameMovementEvent}s, triggered when a
     * {@link Character} steps on this entity.
     * @throws IllegalStateException If this entity has been deleted
     */
    List<GameMovementEvent> movementEvents() throws IllegalStateException;

    /**
     * @return A {@link List} of {@link GameMovementEvent}s, triggered when a
     * {@link Character} or {@link Item} uses an
     * {@link soliloquy.specs.ruleset.entities.abilities.Ability} on this entity.
     * @throws IllegalStateException If this entity has been deleted
     */
    List<GameAbilityEvent> abilityEvents() throws IllegalStateException;

    /**
     * @return A {@link GameEventTarget} corresponding to this entity
     * @throws IllegalStateException If this entity has been deleted
     */
    GameEventTarget makeGameEventTarget() throws IllegalStateException;
}
