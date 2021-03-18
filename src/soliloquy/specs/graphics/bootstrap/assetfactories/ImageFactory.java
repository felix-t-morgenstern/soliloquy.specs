package soliloquy.specs.graphics.bootstrap.assetfactories;

import soliloquy.specs.common.shared.SoliloquyClass;
import soliloquy.specs.graphics.assets.Image;

/**
 * <b>ImageFactory</b>
 * <p>
 * Creates {@link Image}s
 *
 * @author felix.t.morgenstern
 * @version 0.0.1
 *
 */
public interface ImageFactory extends SoliloquyClass {
    /**
     * @param relativeLocation The location of the Image file, relative to the executing program
     * @param supportsMouseEventCapturing True, if and only if the returned Image is to support
     *                                    mouse event capturing
     *                                    (c.f. {@link Image#capturesMouseEventsAtPixel})
     * @return The newly-created Image
     * @throws IllegalArgumentException If and only if relativeLocation is null or empty
     */
    Image make(String relativeLocation, boolean supportsMouseEventCapturing)
            throws IllegalArgumentException;
}
