package soliloquy.specs.graphics;

import soliloquy.specs.common.valueobjects.ICoordinate;
import soliloquy.specs.common.shared.ISoliloquyClass;

/**
 * <b>Renderable</b>
 * <p>
 * An object which can be rendered in the window
 * 
 * @author felix.t.morgenstern
 * @version 0.0.1
 *
 */
public interface IRenderable extends ISoliloquyClass {
	/**
	 * @param windowLoc - The location, in the window, in which to render this object
	 */
	void render(ICoordinate windowLoc);
}
