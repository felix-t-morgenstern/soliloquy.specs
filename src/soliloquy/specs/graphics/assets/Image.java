package soliloquy.specs.graphics.assets;

import soliloquy.specs.common.shared.SoliloquyClass;
import soliloquy.specs.graphics.rendering.Renderer;

/**
 * <b>Image</b>
 * <p>
 * This specifies an image, loaded into memory, which can be used to generate other assets (e.g.
 * {@link Sprite}s, {@link ImageAssetSet}s, etc.). It has a file location (relative to the application
 * base directory). If it is an Image that supports mouse event capturing, then this class can be
 * used to ask whether this Image is non-transparent at a given pixel. (Alpha threshold, aka
 * opacity threshold, is a {@link soliloquy.specs.common.infrastructure.Setting}, whose name will
 * depend on the implementation of the Graphics module.)
 *
 * @author felix.t.morgenstern
 * @version 0.0.1
 *
 */
public interface Image extends SoliloquyClass {
    /**
     * @return The id of the corresponding texture, which can be used by {@link Renderer}s
     */
    int textureId();

    /**
     * @return The location of this Image, relative to the base directory of the application
     */
    String relativeLocation();

    /**
     * @return The width of the image
     */
    int width();

    /**
     * @return The height of the image
     */
    int height();

    /**
     * (Whether this Image supports mouse event capturing is determined by the specific
     * implementation of the Graphics module.)
     * @return True, if and only if this Image supports mouse event capturing
     */
    boolean supportsMouseEventCapturing();

    /**
     * @param x The x value of the pixel whose alpha threshold to check
     * @param y The y value of the pixel whose alpha threshold to check
     * @return True, if and only if the pixel of this Image passes the alpha threshold
     * @throws UnsupportedOperationException If and only if this Image does not support mouse event
     * capturing
     * @throws IllegalArgumentException If and only if x or y are beyond the Image's dimensions
     */
    boolean capturesMouseEventsAtPixel(int x, int y)
            throws UnsupportedOperationException, IllegalArgumentException;
}
