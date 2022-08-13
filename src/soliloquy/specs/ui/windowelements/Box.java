package soliloquy.specs.ui.windowelements;

import soliloquy.specs.common.infrastructure.VariableCache;
import soliloquy.specs.common.shared.HasGlobalAccess;

// TODO: Document this interface
public interface Box extends ScreenElement, HasGlobalAccess {
    VariableCache returnVals();
}
