package soliloquy.specs.ruleset.entities.abilities;

/**
 * <b>ReactiveAbility</b>
 * <p>
 * This class is an Ability which takes place in response to some incoming Ability or other sort of
 * event.
 *
 * @author felix.t.morgenstern
 * @version 0.0.1
 */
public interface ReactiveAbility extends Ability {
    /**
     * @return The (optional) priority for when this ReactiveAbility performs its reaction, if
     *         there are multiple ReactiveAbilityTypes reacting to the same Ability or event
     */
    Integer priority();

    /**
     * @param event The event to check for whether this ReactiveAbility will fire
     * @return True, if and only if this ReactiveAbility will fire for the specified event
     * @throws IllegalArgumentException If and only if event is null or empty
     */
    boolean firesOnEvent(String event) throws IllegalArgumentException;

    /**
     * @param source The source of the Ability to check for whether this ReactiveAbility will fire
     * @return True, if and only if this ReactiveAbility will fire for the specified Ability with
     *         the provided source
     * @throws IllegalArgumentException If and only if source is null
     */
    boolean firesAgainstAbility(AbilitySource source) throws IllegalArgumentException;

    /**
     * Determines how the ReactiveAbility does actually react
     *
     * @param alreadyBlocked True, if and if the incoming Ability has already been blocked. (Some
     *                       ReactiveAbilities won't bother doing anything if this is the case;
     *                       others will.)
     * @param source         The source of the Ability being reacted to
     * @return True, if and only if the incoming Ability has been blocked
     * @throws IllegalArgumentException If and only if source is null
     */
    boolean reactToAbility(boolean alreadyBlocked, AbilitySource source)
            throws IllegalArgumentException;

    /**
     * Determines how the ReactiveAbility does actually react
     *
     * @param alreadyBlocked True, if and if the incoming event has already been blocked. (Some
     *                       ReactiveAbilities won't bother doing anything if this is the case;
     *                       others will.)
     * @return True, if and only if the incoming Ability has been blocked
     */
    boolean reactToEvent(boolean alreadyBlocked);
}
