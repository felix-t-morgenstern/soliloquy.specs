package soliloquy.specs.graphics.io;

import soliloquy.specs.common.shared.SoliloquyClass;
import soliloquy.specs.common.valueobjects.Vertex;

import java.util.Map;

public interface MouseListener extends SoliloquyClass {
    /**
     * (If a mouse button is pressed down when this method is called, and was not pressed down the
     * previous time this method was called, it is expected to pass a corresponding "press" event to
     * {@link MouseEventHandler#actOnMouseLocationAndEvents}; conversely, if the button is not
     * pressed down when this method is called, and was pressed down the previous time this method
     * was called, it is expected to pass a corresponding "release" event to MouseEventHandler
     * instead.)
     *
     * @param position               The position of the mouse in the window, where (0,0) is the
     *                               upper-left, and (1,1) is the bottom-right
     * @param mouseButtonPressStates A map, containing an index for each mouse button type (c.f. <a
     *                               href="https://www.glfw.org/docs/3.3/group__buttons.html">
     *                               https://www.glfw.org/docs/3.3/group__buttons.html</a>),
     *                               whose value indicates whether the mouse button is currently
     *                               being pressed down.
     * @param timestamp              The timestamp at which the mouse position and button states is
     *                               to be registered
     * @throws IllegalArgumentException If and only if position is null; mouseButtonPressStates is
     *                                  null, or has any null keys or values, and does not contain
     *                                  an entry for all supported mouse buttons; or if timestamp is
     *                                  out-of-date
     */
    void registerMousePositionAndButtonStates(Vertex position,
                                              Map<Integer, Boolean> mouseButtonPressStates,
                                              long timestamp)
            throws IllegalArgumentException;
}
