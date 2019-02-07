package soliloquy.sprites.spritefactory.specs;

import soliloquy.common.specs.ICoordinate;

// TODO: Document this interface
public interface IAnimationFrameParams extends IStaticSpriteParams {
	// NB: This field returns the offset of this animation
	//     frame from the location of the animation itself.
	//     E.g., an explosion will start small; so if the 
	//     first Sprite is small, then it should not start 
	//     at the upper-left corner of the Animation.
	ICoordinate animationFrameOffset();
	
	int frameMilliseconds();
}
