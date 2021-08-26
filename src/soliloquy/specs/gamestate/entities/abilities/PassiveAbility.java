package soliloquy.specs.gamestate.entities.abilities;

import soliloquy.specs.gamestate.entities.EntityMemberOfType;
import soliloquy.specs.ruleset.entities.abilities.PassiveAbilityType;

/**
 * <b>PassiveAbility</b>
 * <p>
 * This is a PassiveAbility possessed by a Character or Item. It will return parameters regarding
 * its effects (e.g. damage done, chance-to-hit). It will return whether it only has effect when
 * equipped. (This only applies to PassiveAbilities belonging to Items.)
 * 
 * @author felix.t.morgenstern
 * @version 0.0.1
 *
 */
public interface PassiveAbility extends Ability, EntityMemberOfType<PassiveAbilityType> {

}
