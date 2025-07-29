package soliloquy.specs.io.graphics.renderables;

import soliloquy.specs.common.entities.Action;
import soliloquy.specs.common.valueobjects.Vertex;
import soliloquy.specs.ui.EventInputs;

import java.util.Map;

/**
 * <b>RenderableWithMouseEvents</b>
 * <p>
 * A {@link Renderable} which can capture mouse events.
 *
 * @author felix.t.morgenstern
 * @version 0.0.1
 */
public interface RenderableWithMouseEvents extends Renderable {
    /**
     * @return True, if and only if this Renderable captures (and thus potentially triggers) mouse
     *         events
     */
    boolean getCapturesMouseEvents();

    /**
     * C.f. {@link #getCapturesMouseEvents()} for more information
     *
     * @param capturesMouseEvents Whether this Renderable supports mouse-capturing events
     * @throws IllegalArgumentException If and only if capturesMouseEvents is true, and the
     *                                  underlying Asset does not support capturing mouse events
     */
    void setCapturesMouseEvents(boolean capturesMouseEvents) throws IllegalArgumentException;

    /**
     * (NB: This method should return false if the mouse event occurs outside the
     * {@link soliloquy.specs.io.graphics.rendering.RenderingBoundaries} set by
     * {@link #component()}'s {@link soliloquy.specs.ui.Component#getRenderingBoundariesProvider()}
     *
     * @param point     The point in the window on which this Renderable may or may not capture
     *                  mouse events
     * @param timestamp The timestamp at which this Renderable was clicked
     * @return True, if and only if this Renderable captures mouse events at the timestamp and
     *         location provided
     * @throws UnsupportedOperationException If and only if this Renderable does not support mouse
     *                                       events
     * @throws IllegalArgumentException      If and only if point is null or outside the window
     *                                       boundaries (i.e. [0f,1f]), or if timestamp is before
     *                                       the most recent timestamp provided to class
     */
    boolean capturesMouseEventAtPoint(Vertex point, long timestamp)
            throws UnsupportedOperationException, IllegalArgumentException;

    /**
     * Triggers the onClick mouse event
     *
     * @param mouseButton The mouse button being pressed (c.f. GLFW_MOUSE_BUTTON_*)
     * @param timestamp   The timestamp at which the mouse button has been pressed
     * @throws UnsupportedOperationException If and only if this Renderable does not capture mouse
     *                                       events
     * @throws IllegalArgumentException      If and only if mouseButton does not correspond to a
     *                                       valid
     *                                       mouse button
     */
    void press(int mouseButton, long timestamp)
            throws UnsupportedOperationException, IllegalArgumentException;

    /**
     * C.f. {@link #press} for more information
     *
     * @param mouseButton The mouse button being pressed (c.f. GLFW_MOUSE_BUTTON_*)
     * @param onPress     The Action to run when the area of this Renderable is pressed; can be null
     * @throws IllegalArgumentException If and only if mouseButton does not correspond to a valid
     *                                  mouse button
     */
    void setOnPress(int mouseButton, Action<EventInputs> onPress)
            throws IllegalArgumentException;

    /**
     * @return A Map representing the links between mouse buttons (c.f. GLFW_MOUSE_BUTTON_*) and
     *         the Ids of the Actions ran when those respective mouse buttons are pressed
     */
    Map<Integer, String> pressActionIds();

    /**
     * Triggers the onRelease mouse event
     *
     * @param mouseButton The mouse button being released (c.f. GLFW_MOUSE_BUTTON_*)
     * @param timestamp   The timestamp at which the mouse button has been released
     * @throws UnsupportedOperationException If and only if this Renderable does not capture mouse
     *                                       events
     * @throws IllegalArgumentException      If and only if mouseButton does not correspond to a
     *                                       valid
     *                                       mouse button
     */
    void release(int mouseButton, long timestamp)
            throws UnsupportedOperationException, IllegalArgumentException;

    /**
     * C.f. {@link #release} for more information
     *
     * @param mouseButton The mouse button being released (c.f. GLFW_MOUSE_BUTTON_*)
     * @param onRelease   The Action to run when the area of this Renderable is released; can be
     *                    null
     * @throws IllegalArgumentException If and only if mouseButton does not correspond to a valid
     *                                  mouse button
     */
    void setOnRelease(int mouseButton, Action<EventInputs> onRelease)
            throws IllegalArgumentException;

    /**
     * @return A Map representing the links between mouse buttons (c.f. GLFW_MOUSE_BUTTON_*) and
     *         the Ids of the Actions ran when those respective mouse buttons are released
     */
    Map<Integer, String> releaseActionIds();

    /**
     * Triggers the onMouseOver mouse event
     *
     * @param timestamp The timestamp at which the mouse moved over the area of this Renderable
     * @throws UnsupportedOperationException If and only if this Renderable does not capture mouse
     *                                       events
     * @throws IllegalArgumentException      If and only if the timestamp is before the most recent
     *                                       timestamp provided to class
     */
    void mouseOver(long timestamp) throws UnsupportedOperationException, IllegalArgumentException;

    /**
     * C.f. {@link #mouseOver} for more information
     *
     * @param onMouseOver The Action to fire when the mouse goes over the area of this Renderable;
     *                    can be null
     */
    void setOnMouseOver(Action<EventInputs> onMouseOver);

    /**
     * @return The id of the Action ran when the mouse moves over the area of this Renderable
     */
    String mouseOverActionId();

    /**
     * Triggers the onMouseLeave mouse event
     *
     * @param timestamp The timestamp at which the mouse left the area of this Renderable
     * @throws UnsupportedOperationException If and only if this Renderable does not capture mouse
     *                                       events
     * @throws IllegalArgumentException      If and only if the timestamp is before the most recent
     *                                       timestamp provided to class
     */
    void mouseLeave(long timestamp) throws UnsupportedOperationException, IllegalArgumentException;

    /**
     * C.f. {@link #mouseLeave} for more information
     *
     * @param onMouseLeave The Action to fire when the mouse leaves the area of this Renderable;
     *                     can be null
     */
    void setOnMouseLeave(Action<EventInputs> onMouseLeave);

    /**
     * @return The id of the Action ran when the mouse leaves the area of this Renderable
     */
    String mouseLeaveActionId();
}
