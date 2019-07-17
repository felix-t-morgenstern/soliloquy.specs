package soliloquy.specs.graphics;

import soliloquy.specs.common.valueobjects.Coordinate;
import soliloquy.specs.common.shared.SoliloquyClass;

/**
 * <b>Renderable</b>
 * <p>
 * An object which can be rendered in the window
 * 
 * @author felix.t.morgenstern
 * @version 0.0.1
 *
 */
public interface Renderable extends SoliloquyClass {
	/**
	 * @param windowLoc - The location, in the window, in which to render this object
	 */
	void render(Coordinate windowLoc);
}
