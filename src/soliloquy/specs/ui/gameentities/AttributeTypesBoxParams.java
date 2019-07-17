package soliloquy.specs.ui.gameentities;

import soliloquy.specs.common.infrastructure.Collection;
import soliloquy.specs.common.shared.SoliloquyClass;
import soliloquy.specs.ruleset.entities.AttributeType;
import soliloquy.specs.ui.windowelements.BoxFactoryParams;

// TODO: Document this class
public interface AttributeTypesBoxParams extends SoliloquyClass {
	BoxFactoryParams factoryParams(Collection<AttributeType> attrTypes);
}
