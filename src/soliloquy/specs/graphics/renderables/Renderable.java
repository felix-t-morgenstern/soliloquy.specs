package soliloquy.specs.graphics.renderables;

import soliloquy.specs.common.shared.Cloneable;
import soliloquy.specs.common.shared.SoliloquyClass;
import soliloquy.specs.graphics.rendering.FloatBox;

/**
 * <b>Renderable</b>
 * <p>
 * An object which can be rendered in the window
 * <p>
 * Each renderable can contain Renderables within it, each with their own internal z-indices, which
 * cannot supersede the rendering of anything with a higher z-index than its parent Renderable.
 * <p>
 * Intended use for this class is to be generated at runtime as an anonymous class.
 * 
 * @author felix.t.morgenstern
 * @version 0.0.1
 *
 */
public interface Renderable<TRenderable extends Renderable>
		extends Cloneable<Renderable<TRenderable>>, SoliloquyClass {
	/**
	 * @return The area in the window into which to render
	 */
	FloatBox renderingArea();

	/**
	 * <i>NB: Higher z values will be rendered first.</i>
	 * @return The z-index of this Renderable. (If this Renderable is within another Renderable,
	 * then the z-index is only used to determine rendering order amongst other Renderables within
	 * the containing Renderable.)
	 */
	int z();
}
