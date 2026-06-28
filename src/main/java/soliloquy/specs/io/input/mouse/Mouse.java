package soliloquy.specs.io.input.mouse;

import soliloquy.specs.common.valueobjects.Vertex;

/**
 * <b>MouseCursor</b>
 * <p>
 * This class manages the mouse cursor displayed in the window.
 *
 * @author felix.t.morgenstern
 * @version 0.0.1
 */
public interface Mouse {
    /**
     * @param mouseCursorId The id of the mouse cursor to set
     * @throws IllegalArgumentException If and only if mouseCursorId is null, empty, or does not
     *                                  correspond to a valid mouse cursor
     */
    void setMouseCursor(String mouseCursorId) throws IllegalArgumentException;

    /**
     * This method is intended to be used during frame execution, e.g. to determine how far up or
     * down a scrollbar is being dragged
     *
     * @return The location where the mouse was last observed upon the execution of the most recent
     *         frame
     */
    Vertex mostRecentMouseLocation();

    enum EventType {
        PRESS,
        RELEASE,
        MOUSE_OVER,
        MOUSE_LEAVE
    }
}
