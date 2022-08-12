package soliloquy.specs.graphics.io;

import soliloquy.specs.common.shared.SoliloquyClass;

import java.util.List;

/**
 * <b>MouseEventHandler</b>
 * <p>
 * This class handles mouse events at a given location within the screen. This class triggers
 * press, release, mouseOver and mouseLeave events for all
 * {@link soliloquy.specs.graphics.renderables.RenderableWithMouseEvents}s which capture mouse
 * events.
 *
 * @author felix.t.morgenstern
 * @version 0.0.1
 *
 */
public interface MouseEventHandler extends SoliloquyClass {
    /**
     * This method handles all mouse events for a given frame, given the mouse's current location,
     * and the mouse buttons being held at the start of that frame.
     * @param x The current x location of the mouse
     * @param y The current y location of the mouse
     * @param mouseButton The button which has been pressed or released; can be null, if no mouse
     *                    press or release has been registered (c.f.
     *                    <a href="https://www.glfw.org/docs/3.3/group__buttons.html">https://www.glfw.org/docs/3.3/group__buttons.html</a>)
     * @param eventType Specifies whether the mouse button was pressed down, or released. If null,
     *                  implies that the mouse button was neither pressed or released.
     * @throws IllegalArgumentException If and only if x and y are outside of window boundaries; or
     * if eventType is non-null, and mouseButton is null; or if mouseButton does not correspond to
     * a valid mouse button (see link under mouseButton parameter description)
     */
    void actOnMouseLocationAndEvents(float x, float y, Integer mouseButton, EventType eventType)
            throws IllegalArgumentException;

    enum EventType {
        PRESS,
        RELEASE
    }
}
