package soliloquy.specs.ruleset.entities.abilities;

import soliloquy.specs.common.infrastructure.Collection;
import soliloquy.specs.common.infrastructure.Pair;
import soliloquy.specs.common.infrastructure.VariableCache;
import soliloquy.specs.gamestate.entities.Character;
import soliloquy.specs.gamestate.entities.Tile;

/**
 * <b>ActiveAbilityType</b>
 * <p>
 * It can be used on a target(s), given a source, and parameters regarding its effects
 * 
 * @author felix.t.morgenstern
 * @version 0.0.1
 *
 */
public interface ActiveAbilityType extends AbilityType {
	/**
	 * Uses this ActiveAbilityType against some target(s)
	 * @param source - The source of the ActiveAbilityType
	 * @param targets - The target(s) of the ActiveAbilityType
	 * @param params - The parameters regarding the effects (e.g. damage healed, chance-to-hit) of
	 * the ActiveAbilityType
	 */
	void use(AbilitySource source, Collection<Pair<Character, Tile>> targets,
			 VariableCache params);
}
