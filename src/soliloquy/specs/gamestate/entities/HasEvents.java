package soliloquy.specs.gamestate.entities;

import soliloquy.specs.common.infrastructure.Collection;
import soliloquy.specs.common.shared.SoliloquyClass;
import soliloquy.specs.gamestate.entities.gameevents.GameEvent;

/**
 * <b>HasEvents</b>
 * <p>
 * This class has a {@link Collection} of {@link GameEvent}s, to be fired when this object is the
 * target of an incoming {@link soliloquy.specs.ruleset.entities.abilities.Ability}, or when a
 * {@link soliloquy.specs.gamestate.entities.Character} walks into this object.
 *
 * @author felix.t.morgenstern
 * @version 0.0.1
 */
public interface HasEvents extends SoliloquyClass {
    /**
     * Whether any of the {@link GameEvent}s on this object respond to a {@link Character} walking
     * into this, or to an {@link soliloquy.specs.ruleset.entities.abilities.Ability} being used on
     * this, depends on the functionality defined within the {@link GameEvent}.
     * @return A {@link Collection} of {@link GameEvent}s present on this object
     * @throws IllegalStateException If this object has been deleted
     */
    Collection<GameEvent> events() throws IllegalStateException;
}
