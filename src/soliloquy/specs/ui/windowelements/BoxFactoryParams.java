package soliloquy.specs.ui.windowelements;

import soliloquy.specs.common.entities.Action;
import soliloquy.specs.common.infrastructure.VariableCache;

import java.util.Map;

public interface BoxFactoryParams extends VariableCache {
    // Why am I even presuming to make interfaces for this so prematurely?
    Map<String, Action<VariableCache>> eventHandlers();
}
