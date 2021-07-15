package soliloquy.specs.graphics.io;

import soliloquy.specs.common.shared.SoliloquyClass;

import java.util.List;

/**
 * <b>MouseEventListener</b>
 * <p>
 * This class handles mouse events at a given location within the screen. This class triggers
 * press, release, mouseOver and mouseLeave events for all
 * {@link soliloquy.specs.graphics.renderables.RenderableWithArea}s which capture mouse events.
 *
 * @author felix.t.morgenstern
 * @version 0.0.1
 *
 */
public interface MouseEventListener extends SoliloquyClass {
    /**
     * This method handles all mouse events for a given frame, given the mouse's current location,
     * and the mouse buttons being held at the start of that frame.
     * @param x The current x location of the mouse
     * @param y The current y location of the mouse
     * @param buttonsPressed A List of the buttons currently pressed (can be null)
     * @throws IllegalArgumentException If and only if x and y are outside of window boundaries
     */
    void actOnMouseLocationAndEvents(float x, float y, List<Short> buttonsPressed)
            throws IllegalArgumentException;
}
