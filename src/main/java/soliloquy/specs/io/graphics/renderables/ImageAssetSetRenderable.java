package soliloquy.specs.io.graphics.renderables;

import soliloquy.specs.common.shared.Direction;
import soliloquy.specs.io.graphics.assets.ImageAssetSet;

import java.util.Map;

/**
 * <b>ImageAssetSetRenderable</b>
 * <p>
 * A ImageAssetSet which can be rendered in the window
 *
 * @author felix.t.morgenstern
 * @version 0.0.1
 */
public interface ImageAssetSetRenderable extends ImageAssetRenderable {
    /**
     * @return The ImageAssetSet to be rendered
     */
    ImageAssetSet getImageAssetSet();

    /**
     * C.f. {@link #getImageAssetSet()} for more information
     *
     * @param imageAssetSet The ImageAssetSet to set for this Renderable
     * @throws IllegalArgumentException If and only if imageAssetSet is null, or if imageAssetSet
     *                                  does not support mouse events, while this Renderable does
     *                                  support mouse events
     */
    void setImageAssetSet(ImageAssetSet imageAssetSet) throws IllegalArgumentException;

    /**
     * @return A mutable Map which defines the parameters for displaying the ImageAssetSet (cf {@link ImageAssetSet#getImageAssetWithDisplayParams}
     */
    Map<String, String> displayParams();
}
