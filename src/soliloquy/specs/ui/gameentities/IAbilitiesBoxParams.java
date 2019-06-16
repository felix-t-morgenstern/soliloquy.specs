package soliloquy.specs.ui.gameentities;

import soliloquy.specs.common.shared.IEntityGroup;
import soliloquy.specs.common.shared.ISoliloquyClass;
import soliloquy.specs.ruleset.entities.abilities.IActiveAbilityType;
import soliloquy.specs.ui.windowelements.IBoxFactoryParams;

// TODO: Document this interface
public interface IAbilitiesBoxParams extends ISoliloquyClass {
	IBoxFactoryParams factoryParams(IEntityGroup<IActiveAbilityType> abilities);
}
