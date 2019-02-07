package soliloquy.sprites.specs;

import soliloquy.common.specs.ISoliloquyClass;

// TODO: Document this interface
public interface ISpriteSet extends ISoliloquyClass {
	ISprite getSprite(String type);
	
	ISprite getSprite(String type, String direction);
	
	IGraphicalTransformations graphicalTransformations();
}
