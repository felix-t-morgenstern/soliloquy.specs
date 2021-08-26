package soliloquy.specs.gamestate.entities.abilities;

import soliloquy.specs.common.infrastructure.List;
import soliloquy.specs.common.infrastructure.Pair;
import soliloquy.specs.gamestate.entities.Character;
import soliloquy.specs.gamestate.entities.EntityMemberOfType;
import soliloquy.specs.gamestate.entities.Tile;
import soliloquy.specs.ruleset.entities.abilities.ActiveAbilityType;

/**
 * <b>ActiveAbility</b>
 * <p>
 * This is an ActiveAbility that belongs to an Item or a Character. It can be used on some
 * target(s). It has an Id for its ActiveAbilityType. It will return parameters regarding its
 * effects (e.g. damage done, chance-to-hit). It will return whether it can only be used when
 * equipped. (This only applies to ActiveAbilities belonging to Items.)
 * 
 * @author felix.t.morgenstern
 * @version 0.0.1
 *
 */
public interface ActiveAbility extends Ability, EntityMemberOfType<ActiveAbilityType> {
	/**
	 * @param targets The target(s) for this ActiveAbility. If none is provided, it is assumed that
	 *                this Ability either is being used by a PlayerCharacter, or that it does not
	 *                require a target.
	 */
	void use(List<Pair<Character, Tile>> targets);
}
