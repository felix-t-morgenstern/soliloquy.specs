package soliloquy.specs.ui.windowelements;

import soliloquy.specs.common.valueobjects.IGenericParamsSet;
import soliloquy.specs.common.shared.IHasGlobalAccess;

// TODO: Document this interface
public interface IBox extends IScreenElement, IHasGlobalAccess {
	IGenericParamsSet returnVals();
}
