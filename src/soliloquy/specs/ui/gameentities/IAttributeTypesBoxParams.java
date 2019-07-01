package soliloquy.specs.ui.gameentities;

import soliloquy.specs.common.infrastructure.ICollection;
import soliloquy.specs.common.shared.ISoliloquyClass;
import soliloquy.specs.ruleset.entities.IAttributeType;
import soliloquy.specs.ui.windowelements.IBoxFactoryParams;

// TODO: Document this class
public interface IAttributeTypesBoxParams extends ISoliloquyClass {
	IBoxFactoryParams factoryParams(ICollection<IAttributeType> attrTypes);
}
