package soliloquy.ui.windowelements.specs;

import soliloquy.common.specs.ICoordinate;
import soliloquy.graphics.specs.IRenderable;

/**
 * <b>ScreenElement</b>
 * <p>
 * An object which exists in the Screen, to be rendered by the WindowRenderer.
 * <p>
 * Can be a Sprite, or a Box.
 * 
 * @author felix.t.morgenstern
 * @version 0.0.1
 *
 */
public interface IScreenElement extends IRenderable {
	/**
	 * This method specifies the Id of the ScreenElement, so it can be altered or removed in any way necessary
	 * @return The Id of this ScreenElement
	 */
	int windowElementId();
	
	/**
	 * @return True, if and only if this ScreenElement is a Sprite
	 */
	boolean isSprite();
	
	/**
	 * @return The (x,y) offset of this ScreenElement in the Screen
	 */
	ICoordinate getOffset();
	
	/**
	 * @param offset The (x,y) offset in the Screen to which to set this ScreenElement
	 */
	void setOffset(ICoordinate offset);
}
