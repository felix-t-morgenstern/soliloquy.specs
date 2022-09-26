package soliloquy.specs.graphics.io;

import soliloquy.specs.common.shared.SoliloquyClass;

/**
 * <b>MouseCursor</b>
 * <p>
 * This class manages the mouse cursor displayed in the window.
 *
 * @author felix.t.morgenstern
 * @version 0.0.1
 */
public interface MouseCursor extends SoliloquyClass {
    /**
     * @param mouseCursorId The id of the mouse cursor to set
     * @throws IllegalArgumentException If and only if mouseCursorId is null, empty, or does not
     *                                  correspond to a valid mouse cursor
     */
    void setMouseCursor(String mouseCursorId) throws IllegalArgumentException;

    /**
     * @param windowId The id of the current window in the graphics library
     */
    void updateCursor(long windowId);
}
