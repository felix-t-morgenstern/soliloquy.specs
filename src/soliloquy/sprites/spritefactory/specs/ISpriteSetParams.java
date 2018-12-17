package soliloquy.sprites.spritefactory.specs;

import soliloquy.common.specs.IMap;
import soliloquy.common.specs.ISoliloquyClass;

public interface ISpriteSetParams extends ISoliloquyClass {
	// NB: The Map's index is to specify SpriteSet "type",
	//     and the inner Map is to specify "direction"
	IMap<String,IMap<Integer,ISpriteParams>> params();
}
