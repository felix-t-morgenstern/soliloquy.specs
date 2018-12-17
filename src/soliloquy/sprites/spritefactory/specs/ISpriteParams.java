package soliloquy.sprites.spritefactory.specs;

import soliloquy.common.specs.ICoordinate;
import soliloquy.common.specs.ISoliloquyClass;

public interface ISpriteParams extends ISoliloquyClass {
	ICoordinate locationOffset();
	
	// NB: Implement an invariant which only permits one of
	//     these to return a non-null value, and it must
	//     correspond to isAnimationParams
	boolean isAnimationParams();
	IStaticSpriteParams spriteFrameParams();
	IAnimationParams animationParams();
}
