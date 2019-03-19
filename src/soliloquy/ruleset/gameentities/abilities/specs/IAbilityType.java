package soliloquy.ruleset.gameentities.abilities.specs;

import soliloquy.common.specs.IGenericParamsSet;
import soliloquy.ruleset.gameentities.specs.IGameEntity;

/**
 * <b>AbilityType</b>
 * <p>
 * A common set of behaviors for ActiveAbilityTypes and ReactiveAbilityTypes
 * 
 * @author felix.t.morgenstern
 * @version 0.0.1
 *
 */
public interface IAbilityType extends IGameEntity {
	/**
	 * Returns a string describing the Ability.
	 * @param params - Used to help describe the effects of the Ability (e.g. the damage it will do)
	 * @return The full description of the Ability.
	 * @throws IllegalStateException If this AbilityType has no Id (and also in the extremely
	 * unorthodox case that it has been deleted)
	 */
	String description(IGenericParamsSet params) throws IllegalStateException;
}
