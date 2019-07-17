package soliloquy.specs.ruleset.entities.abilities;

/**
 * <b>ReactiveAbilityType</b>
 * <p>
 * It has an Id for its type.
 * <p>
 * It has a priority, in case multiple ReactiveAbilities wish to respond to the same incoming
 * Ability
 * <p>
 * It specifies which phase of an Ability it responds to
 * <p>
 * It can determine whether it will react.
 * <p>
 * It can react, performing actions, and ultimately deciding whether it blocks the incoming
 * Ability.
 * 
 * @author felix.t.morgenstern
 * @version 0.0.1
 *
 */
public interface ReactiveAbilityType extends AbilityType {
	/**
	 * @return The (optional) priority for when this ReactiveAbilityType performs its reaction, if
	 * there are multiple ReactiveAbilityTypes reacting to the same incoming ability
	 */
	Integer priority();
	
	/**
	 * @return An ability has names for various events during its execution (e.g. when it selects a
	 * target, before the target is hit, and after the target is hit). This string identifies the
	 * event to which this ReactiveAbilityType reacts. (For instance, it might take effect before
	 * the Character is hit, or after, depending on this value.)
	 */
	String eventHook();
	
	/**
	 * Determines whether the ReactiveAbility should react to the incoming Ability
	 * @param incomingAbility - Description of the incoming Ability
	 * @return True, if and only if the ReactiveAbility in question will indeed respond to the
	 * incoming Ability 
	 */
	boolean willReact(IncomingAbilityDescription incomingAbility);
	
	/**
	 * Determines how the ReactiveAbility does actually react
	 * @param alreadyBlocked - True, if and if the incoming Ability has already been blocked. (Some
	 * ReactiveAbilities won't bother doing anything if this is the case; others will.)
	 * @param source - The source of the ActiveAbilityType
	 * @param incomingAbility - Description of the incoming Ability
	 * @return True, if and only if the incoming Ability has been blocked
	 */
	boolean react(boolean alreadyBlocked, AbilitySource source, IncomingAbilityDescription incomingAbility);
}
