package soliloquy.specs.graphics.rendering;

import soliloquy.specs.common.shared.SoliloquyClass;

/**
 * <b>WindowManager</b>
 * <p>
 * This class manages the current WindowDisplayMode (i.e. Windowed, Windowed Fullscreen, or
 * Fullscreen) of the window, and its current dimensions and location.
 *
 * @author felix.t.morgenstern
 * @version 0.0.1
 *
 */
public interface WindowManager extends SoliloquyClass {
    /**
     * @return The current WindowDisplayMode
     */
    WindowDisplayMode getWindowDisplayMode();

    /**
     * @param windowDisplayMode The new WindowDisplayMode
     * @throws IllegalArgumentException If and only if WindowDisplayMode is UNKNOWN
     */
    void setWindowDisplayMode(WindowDisplayMode windowDisplayMode) throws IllegalArgumentException;

    /**
     * NB: Graphics engine implementation may restrict width and height combinations to common
     * screen resolutions, e.g. 800x600, 1920x1080, etc.
     * <p>
     * Also, this method throws an exception when the window is in windowed fullscreen mode, since
     * the window in that case should conform to the resolution of the screen.
     * @param width The width to which to set the screen resolution
     * @param height The height to which to set the screen resolution
     * @throws IllegalArgumentException If and only if width or height are less than 1, or are
     * invalid, according to the rules of the graphics engine implementation.
     * @throws UnsupportedOperationException If and only if current WindowDisplayMode is
     * WindowedFullscreen
     */
    void setDimensions(int width, int height)
            throws IllegalArgumentException, UnsupportedOperationException;

    /**
     * This method updates the size, display mode, etc. of the window, if there have been any
     * changes, whenever the next frame is executed (c.f. {@link FrameTimer}).
     */
    void updateWindowSizeAndLocation();
}
