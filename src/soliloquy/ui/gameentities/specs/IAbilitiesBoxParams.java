package soliloquy.ui.gameentities.specs;

import soliloquy.common.specs.ISoliloquyClass;
import soliloquy.ruleset.gameentities.abilities.specs.IActiveAbilityTypes;
import soliloquy.ui.windowelements.specs.IBoxFactoryParams;

public interface IAbilitiesBoxParams extends ISoliloquyClass {
	IBoxFactoryParams factoryParams(IActiveAbilityTypes abilities);
}
