package soliloquy.specs.ruleset.entities.abilities;

import soliloquy.specs.common.infrastructure.ICollection;
import soliloquy.specs.common.infrastructure.IPair;
import soliloquy.specs.gamestate.entities.ICharacter;
import soliloquy.specs.gamestate.entities.ITile;

/**
 * <b>ActiveAbility</b>
 * <p>
 * This is an ActiveAbility that belongs to an Item or a Character.
 * <p>
 * It can be used on some target(s).
 * <p>
 * It has an Id for its ActiveAbilityType.
 * <p>
 * It will return parameters regarding its effects (e.g. damage done, chance-to-hit).
 * <p>
 * It will return whether it can only be used when equipped. (This only applies to ActiveAbilities
 * belonging to Items.)
 * <p>
 * (You could, hypothetically, create one-off Abilities which belong to Tiles, to be used by the
 * environment.)
 * 
 * @author felix.t.morgenstern
 * @version 0.0.1
 *
 */
public interface IActiveAbility extends IAbility {
	/**
	 * @param targets - The target(s) for this ActiveAbility. If none is provided, it is assumed
	 * that this Ability either is being used by a PlayerCharacter, or that it does not require a
	 * target.
	 */
	void use(ICollection<IPair<ICharacter, ITile>> targets);
}
