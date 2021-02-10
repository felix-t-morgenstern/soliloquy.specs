package soliloquy.specs.ui.windowelements;

import soliloquy.specs.common.valueobjects.Coordinate;
import soliloquy.specs.graphics.renderables.Renderable;

/**
 * <b>ScreenElement</b>
 * <p>
 * An object which exists in the Screen, to be rendered by the StackRenderer.
 * <p>
 * Can be a Sprite, or a Box.
 * 
 * @author felix.t.morgenstern
 * @version 0.0.1
 *
 */
public interface ScreenElement extends Renderable {
	/**
	 * This method specifies the Id of the ScreenElement, so it can be altered or removed in any
	 * way necessary
	 * @return The Id of this ScreenElement
	 */
	int windowElementId();
	
	/**
	 * @return True, if and only if this ScreenElement is a Sprite
	 */
	boolean isSprite();

	/**
	 * @return The x offset of this ScreenElement in the Screen, where 2.0f is the total width of
	 * the screen.
	 */
	float xOffset();

	/**
	 * @return The y offset of this ScreenElement in the Screen, where 2.0f is the total height of
	 * the screen.
	 */
	float yOffset();
	
	/**
	 * @param offset The (x,y) offset in the Screen to which to set this ScreenElement
	 */
	void setOffset(Coordinate offset);
}
