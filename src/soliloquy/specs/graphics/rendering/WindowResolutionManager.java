package soliloquy.specs.graphics.rendering;

import soliloquy.specs.common.shared.SoliloquyClass;
import soliloquy.specs.common.valueobjects.Coordinate;

import java.util.function.Consumer;

/**
 * <b>WindowResolutionManager</b>
 * <p>
 * This class manages the current WindowDisplayMode (i.e. Windowed, Windowed Fullscreen, or
 * Fullscreen) of the window, and its current dimensions and location.
 *
 * @author felix.t.morgenstern
 * @version 0.0.1
 *
 */
public interface WindowResolutionManager extends SoliloquyClass {
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
     * @param width The width to which to set the window resolution
     * @param height The height to which to set the window resolution
     * @throws IllegalArgumentException If and only if width or height are less than 1, or are
     * invalid, according to the rules of the graphics engine implementation.
     * @throws UnsupportedOperationException If and only if current WindowDisplayMode is
     * WindowedFullscreen
     */
    void setDimensions(int width, int height)
            throws IllegalArgumentException, UnsupportedOperationException;

    /**
     * @return The current width of the window
     */
    int getWidth();

    /**
     * @return The current height of the window
     */
    int getHeight();

    /**
     * @return The ratio of the window width to the window height
     */
    float windowWidthToHeightRatio();

    /**
     * This method updates the size, display mode, etc. of the window, if there have been any
     * changes, whenever the next frame is executed (c.f.
     * {@link soliloquy.specs.graphics.rendering.timing.FrameTimer}). (If the window has not yet
     * been created, this method will create it.)
     * @param windowId The id of the current window
     * @param titlebar The string to be displayed in the titlebar
     * @return The window Id, which changes when switching from one display mode to another
     * @throws IllegalArgumentException If and only if titlebar is null or empty
     */
    long updateWindowSizeAndLocation(long windowId, String titlebar)
            throws IllegalArgumentException;
}
