package soliloquy.sprites.specs;

import soliloquy.common.specs.ISoliloquyClass;
import soliloquy.sprites.spritefactory.specs.ISpriteParams;

// TODO: Document this interface
public interface ISpriteFactory extends ISoliloquyClass {
	ISprite make(ISpriteParams params);
}
