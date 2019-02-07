package soliloquy.sprites.specs;

import soliloquy.common.specs.ISoliloquyClass;
import soliloquy.sprites.spritefactory.specs.ISpriteSetParams;

// TODO: Document this interface
public interface ISpriteSetFactory extends ISoliloquyClass {
	ISpriteSet make(ISpriteSetParams params);
}
