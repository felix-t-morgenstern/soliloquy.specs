package soliloquy.specs.io.input.mouse;

import soliloquy.specs.common.valueobjects.Vertex;

import java.util.Map;

/**
 * <b>MouseEventHandler</b>
 * <p>
 * This class handles mouse events at a given location within the screen. This class triggers
 * press, release, mouseOver and mouseLeave events for all
 * {@link soliloquy.specs.io.graphics.renderables.RenderableWithMouseEvents}s which capture mouse
 * events.
 *
 * @author felix.t.morgenstern
 * @version 0.0.1
 */
public interface MouseEventHandler {
    /**
     * This method handles all mouse events for a given frame, given the mouse's current location,
     * and the mouse buttons being held at the start of that frame.
     *
     * @param location     The current location of the mouse
     * @param buttonEvents The mouse button events (i.e. being pressed down or being released) for
     *                     any mouse buttons (c.f. <a
     *                     href="https://www.glfw.org/docs/3.3/group__buttons.html">https://www
     *                     .glfw.org/docs/3.3/group__buttons.html</a>)
     *                     which have been pressed down or released
     * @param timestamp    The timestamp at which the events are to be handled
     * @throws IllegalArgumentException If and only if vertex is null or outside of window
     *                                  boundaries; or if buttonEvents is null, or has any null keys
     *                                  or values; or if timestamp is out-of-date
     */
    void actOnMouseLocationAndEvents(Vertex location, Map<Integer, EventType> buttonEvents,
                                     long timestamp)
            throws IllegalArgumentException;

    enum EventType {
        PRESS,
        RELEASE,
        MOUSE_OVER,
        MOUSE_LEAVE
    }
}
