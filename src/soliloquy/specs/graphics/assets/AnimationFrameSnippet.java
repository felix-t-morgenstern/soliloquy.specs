package soliloquy.specs.graphics.assets;

/**
 * <b>AnimationFrameSnippet</b>
 * <p>
 * This class defines the state of an Animation at a given frame: It points to an {@link Image},
 * defines the boundaries for which to take a snippet from that Image, and defines the pixel
 * offsets for that snippet.
 * <p>
 * It is intended for this interface to be implemented anonymously at runtime.
 *
 * @author felix.t.morgenstern
 * @version 0.0.1
 *
 */
public interface AnimationFrameSnippet extends AssetSnippet {
    /**
     * @return The x offset of the snippet in pixels
     */
    int offsetX();

    /**
     * @return The y offset of the snippet in pixels
     */
    int offsetY();
}
