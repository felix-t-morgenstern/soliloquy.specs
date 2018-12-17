package soliloquy.ruleset.gameentities.abilities.specs;

import soliloquy.common.specs.IEntityGroup;
import soliloquy.common.specs.IMap;

/**
 * <b>ActiveAbilityTypes</b>
 * <p>
 * This is a named set of ActiveAbilityTypes.
 * <p>
 * ActiveAbilities are grouped, so they can appear in menus and submenus in the UI.
 * 
 * @author felix.t.morgenstern
 * @version 0.0.1
 *
 */
public interface IActiveAbilityTypes extends IMap<String,IActiveAbilityType>, IEntityGroup<IActiveAbilityType> {
}
