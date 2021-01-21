package soliloquy.specs.graphics.rendering;

import soliloquy.specs.common.shared.SoliloquyClass;
import soliloquy.specs.common.valueobjects.ReadableCoordinate;

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
     * @throws IllegalArgumentException
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
     * NB: This method throws an exception when the window is in windowed fullscreen mode, since
     * the window in that case should conform to the resolution of the screen.
     * @return The dimensions of the window
     * @throws UnsupportedOperationException If and only if the window is windowed fullscreen
     */
    ReadableCoordinate windowDimensions() throws UnsupportedOperationException;

    /**
     * NB: This method will throw an exception when the {@link WindowDisplayMode} is anything but
     * Windowed, since in the other modes, the window's location is assumed to be affixed.
     * @param x The x position to which to set the window
     * @param y The y position to which to set the window
     * @throws IllegalArgumentException If and only if x or y are negative, or beyond the bounds of
     * the screen
     * @throws UnsupportedOperationException If the current WindowDisplayMode is not Windowed
     */
    void setLocation(int x, int y) throws IllegalArgumentException, UnsupportedOperationException;
}
