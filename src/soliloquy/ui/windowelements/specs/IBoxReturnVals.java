package soliloquy.ui.windowelements.specs;

import soliloquy.common.specs.IMap;
import soliloquy.common.specs.ISoliloquyClass;

public interface IBoxReturnVals extends ISoliloquyClass {
	IMap<String,Boolean> boolVals();
	IMap<String,Integer> intVals();
	IMap<String,Double> doubleVals();
	IMap<String,String> stringVals();
}
