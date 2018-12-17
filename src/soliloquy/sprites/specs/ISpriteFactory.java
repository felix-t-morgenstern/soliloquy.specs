package soliloquy.sprites.specs;

import soliloquy.sprites.spritefactory.specs.ISpriteParams;

public interface ISpriteFactory {
	ISprite make(ISpriteParams params);
}
