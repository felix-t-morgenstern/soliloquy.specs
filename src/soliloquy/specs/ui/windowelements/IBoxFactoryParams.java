package soliloquy.specs.ui.windowelements;

import soliloquy.specs.common.entities.IAction;
import soliloquy.specs.common.valueobjects.IGenericParamsSet;
import soliloquy.specs.common.valueobjects.IMap;

//TODO: Document this interface
public interface IBoxFactoryParams extends IGenericParamsSet {
	// NB: In this case, the Integer keys map onto events
	//     which trigger the functions.
	//     The IBoxReturnVals are provided as an input, because
	//     the action performed may depend on the return
	//     values from the Box.
	//     (I chose to have the functions not return anything,
	//     since they can always pass values from their
	//     BoxReturnVals into a subsequent function.)
	// TODO: Consider removing this member; and if so, BE SURE TO THOROUGHLY DOCUMENT THE FUNCTION OF IBoxReturnVals ELSEWHERE
	IMap<String, IAction<IGenericParamsSet>> eventHandlers();
}
