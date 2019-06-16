package soliloquy.specs.ruleset.entities.abilities;

/**
 * <b>ReactiveAbility</b>
 * <p>
 * It has an Id corresponding to its ReactiveAbilityType.
 * <p>
 * (The ReactiveAbilityType specifies common behavior for determining whether the ReactiveAbility
 * should react, and what it does when it actually does react.)
 * <p>
 * It has an Id for its ReactiveAbilityType.
 * <p>
 * It will return parameters regarding its effects (e.g. damage done, chance-to-hit).
 * <p>
 * It will return whether it can only be used when equipped. (This only applies to
 * ReactiveAbilities belonging to Items.)
 * 
 * @author felix.t.morgenstern
 * @version 0.0.1
 *
 */
public interface IReactiveAbility extends IAbility {
}
