package soliloquy.specs.graphics.rendering;

import soliloquy.specs.common.shared.SoliloquyClass;

public interface WindowManager extends SoliloquyClass {
    /**
     * @param width The width to which to set the screen resolution
     * @param height The height to which to set the screen resolution
     * @throws IllegalArgumentException If and only if width or height are less than 1, or less
     * than the minimum width and height values specified by the graphics engine settings
     */
    void setFullscreen(int width, int height) throws IllegalArgumentException;

    /**
     * If the window had previously been fullscreen, reverts the screen back to its original
     * resolution, and sets the window to occupy the full screen while hiding the window bar.
     */
    void setWindowedFullscreen();

    /**
     * @param width The width to which to set the window
     * @param height The height to which to set the window
     * @throws IllegalArgumentException If and only if width or height are less than 1, or less
     * than the minimum width and height values specified by the graphics engine settings
     */
    void setWindowed(int width, int height) throws IllegalArgumentException;
}
