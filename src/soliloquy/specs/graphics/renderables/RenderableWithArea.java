package soliloquy.specs.graphics.renderables;

import soliloquy.specs.common.entities.Action;
import soliloquy.specs.graphics.renderables.colorshifting.ColorShift;

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
 *
 * @author felix.t.morgenstern
 * @version 0.0.1
 *
 */
public interface RenderableWithArea extends RenderableWithDimensions {
    /**
     * @return True, if and only if this Renderable captures (and thus potentially triggers) mouse
     * events
     */
    boolean getCapturesMouseEvents();

    /**
     * C.f. {@link #getCapturesMouseEvents()} for more information
     * @param capturesMouseEvents Whether this Renderable supports mouse-capturing events
     * @throws IllegalArgumentException If and only if capturesMouseEvents is true, and the
     * underlying Asset does not support capturing mouse events
     */
    void setCapturesMouseEvents(boolean capturesMouseEvents) throws IllegalArgumentException;

    /**
     * Triggers the onClick mouse event
     * @throws UnsupportedOperationException If and only if this Renderable does not capture mouse
     * events
     */
    void click() throws UnsupportedOperationException;

    /**
     * C.f. {@link #click()} for more information
     * @param onClick The Action to fire when this Renderable is clicked; can be null
     */
    void setOnClick(@SuppressWarnings("rawtypes") Action onClick);

    /**
     * Triggers the onMouseOver mouse event
     * @throws UnsupportedOperationException If and only if this Renderable does not capture mouse
     * events
     */
    void mouseOver() throws UnsupportedOperationException;

    /**
     * C.f. {@link #mouseOver()} for more information
     * @param onMouseOver The Action to fire when the mouse goes over this Renderable; can be null
     */
    void setOnMouseOver(@SuppressWarnings("rawtypes") Action onMouseOver);

    /**
     * Triggers the onMouseLeave mouse event
     * @throws UnsupportedOperationException If and only if this Renderable does not capture mouse
     * events
     */
    void mouseLeave() throws UnsupportedOperationException;

    /**
     * C.f. {@link #mouseLeave()} for more information
     * @param onMouseLeave The Action to fire when the mouse leaves this Renderable; can be null
     */
    void setOnMouseLeave(@SuppressWarnings("rawtypes") Action onMouseLeave);

    /**
     * Color shifts at the front of the List are processed by the
     * {@link soliloquy.specs.graphics.renderables.colorshifting.ColorShiftStackAggregator}
     * before color shifts at the end.
     * <p>
     * <i>NB: There should not be any color shifts for a {@link RectangleRenderable} which does not
     * have a background Sprite or Animation.</i>
     * @return A List of color shifts, to be applied to this Renderable, when rendering it in
     * the shader
     */
    List<ColorShift> colorShifts();
}
