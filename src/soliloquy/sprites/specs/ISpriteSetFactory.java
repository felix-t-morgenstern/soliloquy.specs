package soliloquy.sprites.specs;

import soliloquy.common.specs.IMap;
import soliloquy.common.specs.ISoliloquyClass;
import soliloquy.sprites.spritefactory.specs.ISpriteParams;

// TODO: Document this interface
public interface ISpriteSetFactory extends ISoliloquyClass {
	// NB: The Map's index is to specify SpriteSet "type",
	//     and the inner Map is to specify "direction"
	ISpriteSet make(IMap<String,IMap<Integer,ISpriteParams>> params);
}
