package soliloquy.specs.ruleset.entities;

import soliloquy.specs.common.infrastructure.VariableCache;
import soliloquy.specs.common.shared.HasGlobalAccess;
import soliloquy.specs.common.shared.HasId;

/**
 * <b>CharacterAI</b>
 * <p>
 * CharacterAI determines what a Character does when it is their turn to act.
 * <p>
 * CharacterAI contains parameters describing how the Character will behave, e.g. their level of
 * fear, their aggression, their current target(s)
 * <p>
 * CharacterAI describes a series of CharacterEvents which occur when certain events occur, e.g.
 * when the Character is killed, when the Character is close to death, when the demonic ritual is
 * complete
 * <p>
 * CharacterAIs may be written to and read from save files.
 *
 * @author felix.t.morgenstern
 * @version 0.0.1
 */
public interface CharacterAIType extends HasId, HasGlobalAccess {
    /**
     * Causes this Character to act when they are active
     */
    void act();

    /**
     * This is intended to be run within the course of some other game event, e.g. a {@link
     * soliloquy.specs.gamestate.entities.gameevents.GameEventFiring} or the behavior of another
     * Character AI
     *
     * @param eventType The type of event, e.g. "receiveDamage"
     * @param eventData The data corresponding to that event, e.g., the {@link Element} of that
     *                  damage, the {@link soliloquy.specs.gamestate.entities.Character} who
     *                  inflicted it, etc.
     * @throws IllegalArgumentException If and only if eventType is null or empty, or eventData is
     *                                  null. <i>Specific Character AIs may throw specific errors if
     *                                  eventData does not contain specific data, e.g., a
     *                                  "receiveDamage" event may throw an exception if the Element
     *                                  of that damage is not specified.</i>
     */
    void fireEvent(String eventType, VariableCache eventData) throws IllegalArgumentException;
}
