package soliloquy.sprites.spritefactory.specs;

import soliloquy.common.specs.IAction;
import soliloquy.common.specs.ICoordinate;
import soliloquy.common.specs.ISoliloquyClass;

// TODO: Document this interface
public interface IStaticSpriteParams extends ISoliloquyClass {
	int spriteSheetId();
	ICoordinate upperLeft();
	ICoordinate lowerRight();
	
	// NB: This is used as an alternate way to render it
	IAction<Void> hook();
}
