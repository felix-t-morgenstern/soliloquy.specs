package soliloquy.ui.gameentities.specs;

import soliloquy.common.specs.IEntityGroup;
import soliloquy.common.specs.ISoliloquyClass;
import soliloquy.ruleset.gameentities.abilities.specs.IActiveAbilityType;
import soliloquy.ui.windowelements.specs.IBoxFactoryParams;

// TODO: Document this interface
public interface IAbilitiesBoxParams extends ISoliloquyClass {
	IBoxFactoryParams factoryParams(IEntityGroup<IActiveAbilityType> abilities);
}
