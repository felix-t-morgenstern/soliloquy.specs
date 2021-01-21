package soliloquy.specs.graphics.rendering;

import soliloquy.specs.common.shared.SoliloquyClass;
import soliloquy.specs.common.valueobjects.ReadableCoordinate;

public interface WindowManager extends SoliloquyClass {
    /**
     * @return True, if and only if the window is fullscreen
     */
    boolean getFullscreen();

    /**
     * NB: Graphics engine implementation may restrict width and height combinations to common
     * screen resolutions, e.g. 800x600, 1920x1080, etc.
     * @param width The width to which to set the screen resolution
     * @param height The height to which to set the screen resolution
     * @throws IllegalArgumentException If and only if width or height are less than 1, or are
     * invalid, according to the rules of the graphics engine implementation.
     */
    void setFullscreen(int width, int height) throws IllegalArgumentException;

    /**
     * @return True, if and only if the window is windowed fullscreen
     */
    boolean getWindowedFullscreen();

    /**
     * If the window had previously been fullscreen, reverts the screen back to its original
     * resolution, and sets the window to occupy the full screen while hiding the window bar.
     */
    void setWindowedFullscreen();

    /**
     * @return True, if and only if the window is windowed (i.e. a movable window, not fullscreen
     * or windowed fullscreen)
     */
    boolean getWindowed();

    /**
     * @param width The width to which to set the window
     * @param height The height to which to set the window
     * @throws IllegalArgumentException If and only if width or height are less than 1, or less
     * than the minimum width and height values specified by the graphics engine settings
     */
    void setWindowed(int width, int height) throws IllegalArgumentException;

    /**
     * NB: This method throws an exception when the window is in windowed fullscreen mode, since
     * the window in that case should conform to the resolution of the screen.
     * @return The dimensions of the window
     * @throws UnsupportedOperationException If and only if the window is windowed fullscreen
     */
    ReadableCoordinate windowDimensions() throws UnsupportedOperationException;
}
