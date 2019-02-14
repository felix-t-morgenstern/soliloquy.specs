package soliloquy.ui.gameentities.specs;

import soliloquy.common.specs.ICollection;
import soliloquy.common.specs.ISoliloquyClass;
import soliloquy.ruleset.gameentities.specs.IAttribute;
import soliloquy.ui.windowelements.specs.IBoxFactoryParams;

public interface IAttributeTypesBoxParams extends ISoliloquyClass {
	IBoxFactoryParams factoryParams(ICollection<IAttribute> attrTypes);
}
