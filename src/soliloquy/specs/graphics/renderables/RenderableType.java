package soliloquy.specs.graphics.renderables;

import soliloquy.specs.common.shared.SoliloquyClass;
import soliloquy.specs.common.valueobjects.ReadableCoordinate;
import soliloquy.specs.graphics.assets.Sprite;
import soliloquy.specs.graphics.colorshifting.ColorShiftType;

import java.util.Collection;
import java.util.List;

/**
 * <b>RenderableType</b>
 * <p>
 * An object which can be rendered in the window
 * <p>
 * Each renderable can contain Renderables within it, each with their own internal z-indices, which
 * cannot supersede the rendering of anything with a higher z-index than its parent Renderable.
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
	boolean getCapturesMouseEvents();

	/**
	 * @param capturesMouseEvents Determines whether this Renderable captures (and thus potentially
	 *                            triggers) mouse events
	 */
	void setCapturesMouseEvents(boolean capturesMouseEvents);

	/**
	 * If this Renderable can capture mouse events, this method verifies whether it does so at the
	 * specified pixel location on the screen. (An intended use of this is for
	 * {@link Sprite}s, where some of the Sprite is transparent:
	 * Where the Sprite is transparent, the mouse should not capture any events. Put differently,
	 * you shouldn't be able to click on the transparent part of a Sprite.)
	 * @param windowLocation The pixel location in the window at which to test whether this
	 *                       Renderable captures mouse events.
	 * @return True, if and only if this Renderable captures mouse events at the provided location
	 * @throws IllegalArgumentException If and only if location is null
	 * @throws UnsupportedOperationException If and only if this Renderable does not capture mouse
	 * events
	 */
	boolean capturesAtLocation(ReadableCoordinate windowLocation)
			throws IllegalArgumentException, UnsupportedOperationException;

	/**
	 * @param onClick This event is triggered whenever a mouse click happens on this Renderable.
	 *                (If onClick is null, then no event will occur.)
	 */
	void setOnClick(Runnable onClick);

	/**
	 * Triggers the onClick event, defined in {@link #setOnClick}.
	 * @throws UnsupportedOperationException If and only if this Renderable does not capture mouse
	 * events
	 */
	void click() throws UnsupportedOperationException;

	/**
	 * @param onMouseOver This event is triggered whenever a mouse enters this Renderable. (If
	 *                    onMouseOver is null, then no event will occur.)
	 */
	void setOnMouseOver(Runnable onMouseOver);

	/**
	 * Triggers the onClick event, defined in {@link #setOnMouseOver}.
	 * @throws UnsupportedOperationException If and only if this Renderable does not capture mouse
	 * events
	 */
	void mouseOver() throws UnsupportedOperationException;

	/**
	 * @param onMouseLeave This event is triggered whenever a mouse leaves this Renderable. (If
	 *                     onMouseLeave is null, then no event will occur.)
	 */
	void setOnMouseLeave(Runnable onMouseLeave);

	/**
	 * Triggers the onClick event, defined in {@link #setOnMouseLeave}.
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
	Collection<ColorShiftType> colorShifts();

	List<RenderableType> innerRenderables();
}
