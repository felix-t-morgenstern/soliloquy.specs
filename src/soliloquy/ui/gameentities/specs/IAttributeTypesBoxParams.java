package soliloquy.ui.gameentities.specs;

import soliloquy.common.specs.ISoliloquyClass;
import soliloquy.ruleset.gameentities.specs.IAttributes;
import soliloquy.ui.windowelements.specs.IBoxFactoryParams;

public interface IAttributeTypesBoxParams extends ISoliloquyClass {
	IBoxFactoryParams factoryParams(IAttributes attrTypes);
}
