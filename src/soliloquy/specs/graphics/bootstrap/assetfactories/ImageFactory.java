package soliloquy.specs.graphics.bootstrap.assetfactories;

import soliloquy.specs.common.shared.SoliloquyClass;
import soliloquy.specs.graphics.assets.Image;
import soliloquy.specs.graphics.bootstrap.assetfactories.definitions.ImageDefinition;

/**
 * <b>ImageFactory</b>
 * <p>
 * Creates {@link Image}s
 *
 * @author felix.t.morgenstern
 * @version 0.0.1
 */
public interface ImageFactory extends SoliloquyClass {
    /**
     * @param imageDefinition The definition of the Image to be created
     * @return The newly-created Image
     * @throws IllegalArgumentException If and only if imageDefinition is null, or has a null or
     *                                  empty relativeLocation
     */
    Image make(ImageDefinition imageDefinition) throws IllegalArgumentException;
}
