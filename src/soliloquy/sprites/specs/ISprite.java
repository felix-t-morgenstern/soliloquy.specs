package soliloquy.sprites.specs;

import soliloquy.common.specs.ICoordinate;
import soliloquy.ui.windowelements.specs.IScreenElement;

public interface ISprite extends IScreenElement {
	
	// NB: There should be an invariant whereby only 'frame'
	//     or 'animation' returns a non-null value, and only
	//     the one specified by 'isAnimated()' is defined
	boolean isAnimated();
	IAnimation animation();
	
	// NB: This method returns the dimensions of the Sprite.
	//     If this Sprite is animated, it should return the
	//     total span of the animation, not just its largest
	//     component frame. This may be necessary to place
	//     Sprites within their desired tiles, or to know how
	//     to center a Sprite.
	ICoordinate size();
}
