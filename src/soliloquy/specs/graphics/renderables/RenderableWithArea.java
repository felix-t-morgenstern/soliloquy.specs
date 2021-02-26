package soliloquy.specs.graphics.renderables;

import soliloquy.specs.graphics.colorshifting.ColorShift;

import java.util.List;

/**
 * <b>RenderableWithArea</b>
 * <p>
 * An object which can be rendered in the window, which has area (i.e. which is not a
 * {@link RasterizedLineSegmentRenderable} or a {@link TextLineRenderable}).
 * <p>
 * This interface is segregated out from {@link Renderable}, since members related to mouse event
 * capturing are only relevant to Renderables with an area. (Currently, TextLineRenderables are not
 * defined as having area, because the present implementation of text line rendering does not lend
 * itself to determining which pixel is currently under the mouse cursor.)
 * <p>
 * Intended use for this class is to be generated at runtime as an anonymous class.
 *
 * @author felix.t.morgenstern
 * @version 0.0.1
 *
 */
public interface RenderableWithArea<TRenderable extends Renderable>
        extends Renderable<TRenderable> {
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
     * Color shifts at the front of the List are processed by the
     * {@link soliloquy.specs.graphics.colorshifting.ColorShiftStackAggregator} before color shifts
     * at the end.
     * <p>
     * <i>NB: There should not be any color shifts for a {@link RectangleRenderable} which does not
     * have a background Sprite or Animation.</i>
     * @return A List of color shifts, to be applied to this Renderable, when rendering it in
     * the shader
     */
    List<ColorShift> colorShifts();
}
