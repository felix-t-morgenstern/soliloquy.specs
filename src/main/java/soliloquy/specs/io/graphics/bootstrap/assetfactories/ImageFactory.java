package soliloquy.specs.io.graphics.bootstrap.assetfactories;

import soliloquy.specs.io.graphics.assets.Image;
import soliloquy.specs.io.graphics.bootstrap.assetfactories.definitions.ImageDefinition;

/**
 * <b>ImageFactory</b>
 * <p>
 * Creates {@link Image}s
 *
 * @author felix.t.morgenstern
 * @version 0.0.1
 */
public interface ImageFactory {
    /**
     * @param imageDefinition The definition of the Image to be created
     * @return The newly-created Image
     * @throws IllegalArgumentException If and only if imageDefinition is null, or has a null or
     *                                  empty relativeLocation
     */
    Image make(ImageDefinition imageDefinition) throws IllegalArgumentException;
}
