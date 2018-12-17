package soliloquy.ui.windowelements.specs;

import soliloquy.common.specs.ISoliloquyClass;

public interface IBoxFactory extends ISoliloquyClass {
	IBox makeBox(IBoxFactoryParams params);
	
	// NB: This might be a bit too far-flung to actually use
	//     My thought process is, the Box can be defined
	//     entirely by its parameters, allowing a completely
	//     custom Box, without requiring it to be defined by
	//     the UI engine in advance. This can allow for 
	//     custom controllers, but that might require more 
	//     specification than is allowed by BoxFactoryParams...
	//public IBox makeBoxFromElements(Map<Integer,IBoxFactoryParams> params);
}
