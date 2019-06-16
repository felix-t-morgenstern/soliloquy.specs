package soliloquy.specs.ruleset.entities.abilities;

import soliloquy.specs.common.valueobjects.ICollection;
import soliloquy.specs.common.valueobjects.IGenericParamsSet;
import soliloquy.specs.common.valueobjects.IPair;
import soliloquy.specs.gamestate.entities.ICharacter;
import soliloquy.specs.gamestate.entities.ITile;

/**
 * <b>ActiveAbilityType</b>
 * <p>
 * It can be used on a target(s), given a source, and parameters regarding its effects
 * 
 * @author felix.t.morgenstern
 * @version 0.0.1
 *
 */
public interface IActiveAbilityType extends IAbilityType {
	/**
	 * Uses this ActiveAbilityType against some target(s)
	 * @param source - The source of the ActiveAbilityType
	 * @param targets - The target(s) of the ActiveAbilityType
	 * @param params - The parameters regarding the effects (e.g. damage healed, chance-to-hit) of
	 * the ActiveAbilityType
	 */
	void use(IAbilitySource source,
			 ICollection<IPair<ICharacter, ITile>> targets,
			 IGenericParamsSet params);
}
