package soliloquy.specs.graphics.renderables;

import soliloquy.specs.common.shared.SoliloquyClass;

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
public interface Renderable extends SoliloquyClass {
	/**
	 * @return The x location of this Renderable on the window, where -1.0 is the left edge of the
	 * window, and 1.0 is the right edge of the window
	 */
	float xLoc();
	/**
	 * @return The y location of this Renderable on the window, where -1.0 is the bottom edge of
	 * the window, and 1.0 is the top edge of the window
	 */
	float yLoc();

	/**
	 * <i>NB: Can be negative. E.g., with a {@link RasterizedLineSegmentRenderable}, a negative
	 * width implies that the line will start to the left of its origin.</i>
	 * @return The width of this Renderable on the window, where 2.0 is the total width of the
	 * window (c.f. {@link #xLoc})
	 */
	float width();

	/**
	 * <i>NB: Can be negative. E.g., with a {@link RasterizedLineSegmentRenderable}, a negative
	 * height implies that the line will start to the left of its origin.</i>
	 * @return The height of this Renderable on the window, where 2.0 is the total height of the
	 * window (c.f. {@link #yLoc})
	 */
	float height();

	/**
	 * <i>NB: Higher z values will be rendered first.</i>
	 * @return The z-index of this Renderable. (If this Renderable is within another Renderable,
	 * then the z-index is only used to determine rendering order amongst other Renderables within
	 * the containing Renderable.)
	 */
	int z();
}
