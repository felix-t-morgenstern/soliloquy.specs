package soliloquy.specs.io.graphics.renderables;

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
     * The start timestamp, used when {@link ImageAssetSet#getImageAssetWithDisplayParams} returns
     * an {@link soliloquy.specs.io.graphics.assets.Animation}. When rendered, the Animation will be
     * rendered with an effective starting timestamp provided. Unlike arguments passed to e.g.
     * {@link soliloquy.specs.io.graphics.renderables.providers.ProviderAtTime#provide}, the
     * timestamp can be in the past.
     */
    Long getAnimationStart();

    /**
     * C.f. {@link #getAnimationStart()}
     *
     * @param timestamp The timestamp at which a rendered Animation will be anchored for its
     *                  starting position
     */
    void setAnimationStart(Long timestamp);

    /**
     * @return A mutable Map which defines the parameters for displaying the ImageAssetSet (cf
     *         {@link ImageAssetSet#getImageAssetWithDisplayParams}
     */
    Map<String, String> displayParams();
}
