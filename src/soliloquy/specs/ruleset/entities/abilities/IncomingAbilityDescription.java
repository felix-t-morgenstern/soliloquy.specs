package soliloquy.specs.ruleset.entities.abilities;

import soliloquy.specs.common.infrastructure.VariableCache;
import soliloquy.specs.common.shared.SoliloquyClass;
import soliloquy.specs.gamestate.entities.abilities.AbilitySource;

/**
 * <b>IncomingAbilityDescription</b>
 * <p>
 * Describes the nature of an ability, from the perspective of (one of) its target(s)
 * <p>
 * It has fields for the Ids of both an ActiveAbility and a ReactiveAbility. <b>One and only one of
 * these methods should return a non-null value.</b>
 * 
 * @author felix.t.morgenstern
 * @version 0.0.1
 *
 */
public interface IncomingAbilityDescription extends SoliloquyClass {
	/**
	 * If reactiveAbilityTypeId() returns a non-null value, this method <b>must</b> return null.
	 * @return the Id of the ActiveAbilityType
	 */
	ActiveAbilityType activeAbilityTypeId();

	/**
	 * If activeAbilityTypeId() returns a non-null value, this method <b>must</b> return null.
	 * @return the Id of the RectiveAbilityType
	 */
	ReactiveAbilityType reactiveAbilityType();
	
	/**
	 * @return The source of the incoming Ability
	 */
	AbilitySource incomingAbilitySource();
	
	/**
	 * @return Parameters describing the Ability (e.g. its effectiveness)
	 */
	VariableCache incomingAbilityParams();
}
