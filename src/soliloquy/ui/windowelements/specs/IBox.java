package soliloquy.ui.windowelements.specs;

import soliloquy.common.specs.IGenericParamsSet;
import soliloquy.common.specs.IGlobalAccess;

public interface IBox extends IScreenElement, IGlobalAccess {
	IGenericParamsSet returnVals();
}
