package soliloquy.specs.ruleset.entities.abilities;

/**
 * <b>PassiveAbility</b>
 * <p>
 * It has an Id for its PassiveAbilityType.
 * <p>
 * It will return parameters regarding its effects (e.g. damage done, chance-to-hit).
 * <p>
 * It will return whether it only has effect when equipped. (This only applies to PassiveAbilities
 * belonging to Items.)
 * 
 * @author felix.t.morgenstern
 * @version 0.0.1
 *
 */
public interface IPassiveAbility extends IAbility {
}
