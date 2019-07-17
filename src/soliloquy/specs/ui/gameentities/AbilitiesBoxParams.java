package soliloquy.specs.ui.gameentities;

import soliloquy.specs.common.shared.EntityGroup;
import soliloquy.specs.common.shared.SoliloquyClass;
import soliloquy.specs.ruleset.entities.abilities.ActiveAbilityType;
import soliloquy.specs.ui.windowelements.BoxFactoryParams;

// TODO: Document this interface
public interface AbilitiesBoxParams extends SoliloquyClass {
	BoxFactoryParams factoryParams(EntityGroup<ActiveAbilityType> abilities);
}
