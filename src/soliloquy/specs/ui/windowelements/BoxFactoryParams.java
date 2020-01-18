package soliloquy.specs.ui.windowelements;

import soliloquy.specs.common.entities.Action;
import soliloquy.specs.common.infrastructure.ReadableMap;
import soliloquy.specs.common.infrastructure.VariableCache;

//TODO: Document this interface
public interface BoxFactoryParams extends VariableCache {
	// NB: In this case, the Integer keys map onto movementEvents
	//     which trigger the functions.
	//     The IBoxReturnVals are provided as an input, because
	//     the action performed may depend on the return
	//     values from the Box.
	//     (I chose to have the functions not return anything,
	//     since they can always pass values from their
	//     BoxReturnVals into a subsequent function.)
	// TODO: Consider removing this member; and if so, BE SURE TO THOROUGHLY DOCUMENT THE FUNCTION OF IBoxReturnVals ELSEWHERE
	ReadableMap<String, Action<VariableCache>> eventHandlers();
}
