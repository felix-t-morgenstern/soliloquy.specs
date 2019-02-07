package soliloquy.ruleset.gameentities.abilities.specs;

import soliloquy.common.specs.IGenericParamsSet;
import soliloquy.common.specs.ISoliloquyClass;

/**
 * <b>IncomingAbilityDescription</b>
 * <p>
 * Describes the nature of an ability, from the perspective of (one of) its target(s)
 * <p>
 * It has fields for the Ids of both an ActiveAbility and a ReactiveAbility. <b>One and only one of these methods should return a non-null value.</b>
 * 
 * @author felix.t.morgenstern
 * @version 0.0.1
 *
 */
public interface IIncomingAbilityDescription extends ISoliloquyClass {
	/**
	 * If reactiveAbilityTypeId() returns a non-null value, this method <b>must</b> return null.
	 * @return the Id of the ActiveAbilityType
	 */
	String activeAbilityTypeId();

	/**
	 * If activeAbilityTypeId() returns a non-null value, this method <b>must</b> return null.
	 * @return the Id of the RectiveAbilityType
	 */
	String reactiveAbilityTypeId();
	
	/**
	 * @return The source of the incoming Ability
	 */
	IAbilitySource incomingAbilitySource();
	
	/**
	 * @return Parameters describing the Ability (e.g. its effectiveness)
	 */
	IGenericParamsSet incomingAbilityParams();
}
