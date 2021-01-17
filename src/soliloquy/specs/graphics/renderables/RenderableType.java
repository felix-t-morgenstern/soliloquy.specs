package soliloquy.specs.graphics.renderables;

import soliloquy.specs.common.shared.SoliloquyClass;
import soliloquy.specs.common.valueobjects.ReadableCoordinate;
import soliloquy.specs.graphics.colorshifting.ColorShiftType;

import java.util.List;

/**
 * <b>RenderableType</b>
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
public interface RenderableType extends SoliloquyClass {
	/**
	 * @return True, if and only if this Renderable captures (and thus potentially triggers) mouse
	 * events
	 */
	boolean capturesMouseEvents();

	/**
	 * Triggers the onClick mouse event
	 * @throws UnsupportedOperationException If and only if this Renderable does not capture mouse
	 * events
	 */
	void click() throws UnsupportedOperationException;

	/**
	 * Triggers the onMouseOver mouse event
	 * @throws UnsupportedOperationException If and only if this Renderable does not capture mouse
	 * events
	 */
	void mouseOver() throws UnsupportedOperationException;

	/**
	 * Triggers the onMouseLeave mouse event
	 * @throws UnsupportedOperationException If and only if this Renderable does not capture mouse
	 * events
	 */
	void mouseLeave() throws UnsupportedOperationException;

	/**
	 * @return The pixel location of this Renderable on the screen
	 */
	ReadableCoordinate screenLocation();

	/**
	 * @return The z-index of this Renderable. (If this Renderable is within another Renderable,
	 * then the z-index is only used to determine rendering order amongst other Renderables within
	 * the containing Renderable.)
	 */
	int z();

	/**
	 * @return The dimensions of this Renderable, in pixels.
	 */
	ReadableCoordinate dimensions();

	/**
	 * Color shifts at the front of the Collection are processed by the
	 * {@link soliloquy.specs.graphics.colorshifting.ColorShiftStackAggregator} before color shifts
	 * at the end.
	 * @return A Collection of color shifts, to be applied to this Renderable, when rendering it in
	 * the shader
	 */
	List<ColorShiftType> colorShifts();

	/**
	 * NB: All child renderables will be rendered below all renderables above their parent, and all
	 * children of those renderables above their parent.
	 * @return The renderables which are children of this renderable
	 */
	List<RenderableType> innerRenderables();
}
