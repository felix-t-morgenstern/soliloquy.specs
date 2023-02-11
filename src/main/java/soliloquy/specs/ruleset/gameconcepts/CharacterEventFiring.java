package soliloquy.specs.ruleset.gameconcepts;

import soliloquy.specs.common.infrastructure.VariableCache;
import soliloquy.specs.common.shared.HasPriority;
import soliloquy.specs.gamestate.entities.Character;
import soliloquy.specs.gamestate.entities.abilities.AbilitySource;
import soliloquy.specs.gamestate.entities.exceptions.EntityDeletedException;
import soliloquy.specs.ruleset.entities.abilities.Ability;

/**
 * <b>CharacterEventFiring</b>
 * <p>
 * This class handles when events (see {@link soliloquy.specs.gamestate.entities.CharacterEvents})
 * or {@link Ability}s are directed towards a {@link soliloquy.specs.gamestate.entities.Character}.
 *
 * @author felix.t.morgenstern
 * @version 0.0.1
 */
public interface CharacterEventFiring {
    /**
     * @param target The Character being targeted by the event
     * @param event  The type of event being fired
     * @param data   Data associated with the firing of the event
     * @throws IllegalArgumentException If and only if target is null, event is null or empty, or
     *                                  data is null
     * @throws EntityDeletedException   If and only if target is deleted
     */
    void fireEvent(Character target, String event, VariableCache data)
            throws IllegalArgumentException, EntityDeletedException;

    /**
     * @param target The Character being targeted by the incoming
     *               {@link soliloquy.specs.ruleset.entities.abilities.Ability}
     * @param source The source of the incoming Ability
     * @throws IllegalArgumentException If and only if target or source are null
     * @throws EntityDeletedException   If and only if target is deleted
     */
    void fireAbility(Character target, AbilitySource source)
            throws IllegalArgumentException, EntityDeletedException;

    /**
     * This interface is used by {@link soliloquy.specs.gamestate.entities.CharacterEvents} and
     * {@link soliloquy.specs.ruleset.entities.abilities.ReactiveAbility} to return their responses
     * to the fired event to this class. This class uses those
     */
    interface FiringResponse extends HasPriority {
        /**
         * @return True, if and only if the incoming event (including
         *         {@link soliloquy.specs.ruleset.entities.abilities.Ability}s) is blocked, and
         *         preventing further
         *         {@link soliloquy.specs.gamestate.entities.CharacterEvents.CharacterEvent}s or
         *         {@link soliloquy.specs.ruleset.entities.abilities.ReactiveAbility}s from
         *         responding.
         */
        boolean get();
    }

    interface RespondsToEvents {
        /**
         * Determines how the ReactiveAbility does actually react to an incoming {@link Ability}
         *
         * @param target The Character being targeted by the incoming {@link Ability}
         * @param source The source of the Ability being reacted to
         * @return A description of how this entity will respond to the incoming Ability, to be used
         *         by {@link CharacterEventFiring#fireAbility}
         * @throws IllegalArgumentException If and only if target or source is null
         * @throws EntityDeletedException   If and only if target is deleted
         */
        FiringResponse reactToAbility(Character target, AbilitySource source)
                throws IllegalArgumentException, EntityDeletedException;

        /**
         * Determines how the entity does actually react to an incoming event
         *
         * @param target The Character being targeted by the incoming event
         * @param event  The event being fired
         * @param data   The data associated with the event firing
         * @return A description of how this entity will respond to the incoming event, to be used
         *         by {@link CharacterEventFiring#fireEvent}
         * @throws IllegalArgumentException If and only if target is null, event is null or empty,
         *                                  or data is null
         * @throws EntityDeletedException   If and only if target is deleted
         */
        FiringResponse reactToEvent(Character target, String event, VariableCache data)
                throws IllegalArgumentException, EntityDeletedException;
    }
}
