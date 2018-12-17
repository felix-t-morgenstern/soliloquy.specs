package soliloquy.ruleset.gameentities.abilities.specs;

import soliloquy.common.specs.IEntityGroup;
import soliloquy.common.specs.IMap;

/**
 * <b>PassiveAbilityTypes</b>
 * <p>
 * This is a named set of PassiveAbilityTypes, with grouping
 * <p>
 * (The grouping is probably unnecessary, but it is an option if that is how you want to structure your UI.)
 * 
 * @author felix.t.morgenstern
 * @version 0.0.1
 *
 */
public interface IPassiveAbilityTypes extends IMap<String,IPassiveAbilityTypes>, IEntityGroup<IPassiveAbilityTypes> {
}
