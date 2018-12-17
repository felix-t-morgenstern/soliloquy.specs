package soliloquy.ui.windowelements.specs;

import soliloquy.common.specs.IAction;
import soliloquy.common.specs.IGenericParamsSet;
import soliloquy.common.specs.IMap;
import soliloquy.common.specs.ISoliloquyClass;

public interface IBoxFactoryParams extends IGenericParamsSet, ISoliloquyClass {
	// NB: In this case, the Integer keys map onto events
	//     which trigger the functions.
	//     The IBoxReturnVals are provided as an input, because
	//     the action performed may depend on the return
	//     values from the Box.
	//     (I chose to have the functions not return anything,
	//     since they can always pass values from their
	//     BoxReturnVals into a subsequent function.)
	IMap<String,IAction<IBoxReturnVals>> eventHandlers();
}
