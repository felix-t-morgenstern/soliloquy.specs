package soliloquy.specs.ruleset.entities.abilities;

import soliloquy.specs.common.infrastructure.ImmutableMap;
import soliloquy.specs.gamestate.entities.abilities.AbilitySource;
import soliloquy.specs.ruleset.gameconcepts.CharacterEventFiring;

/**
 * <b>ReactiveAbility</b>
 * <p>
 * This class is an Ability which takes place in response to some incoming Ability or other sort of
 * event.
 *
 * @author felix.t.morgenstern
 * @version 0.0.1
 */
public interface ReactiveAbility extends Ability, CharacterEventFiring.RespondsToEvents {
    /**
     * @param event The event to check for whether this ReactiveAbility will fire
     * @param data  The data associated with the event firing
     * @return True, if and only if this ReactiveAbility will fire for the specified event
     * @throws IllegalArgumentException If and only if event is null or empty, or if data is null
     */
    boolean firesAgainstEvent(String event, ImmutableMap<String, Object> data) throws IllegalArgumentException;

    /**
     * @param source The source of the Ability to check for whether this ReactiveAbility will fire
     * @return True, if and only if this ReactiveAbility will fire for the specified Ability with
     *         the provided source
     * @throws IllegalArgumentException If and only if source is null
     */
    boolean firesAgainstAbility(AbilitySource source) throws IllegalArgumentException;
}
