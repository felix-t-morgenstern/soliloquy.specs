package soliloquy.specs.gamestate.entities.abilities;

import soliloquy.specs.gamestate.entities.EntityMemberOfType;
import soliloquy.specs.ruleset.entities.abilities.ReactiveAbilityType;

/**
 * <b>ReactiveAbility</b>
 * <p>
 * This is a ReactiveAbility possessed by a Character or Item. It will return parameters regarding
 * its effects (e.g. damage done, chance-to-hit). It will return whether it can only be used when
 * equipped. (This only applies to ReactiveAbilities belonging to Items.)
 * 
 * @author felix.t.morgenstern
 * @version 0.0.1
 *
 */
public interface ReactiveAbility extends Ability, EntityMemberOfType<ReactiveAbilityType> {

}
