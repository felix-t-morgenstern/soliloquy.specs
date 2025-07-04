package soliloquy.specs.io.graphics.assets;

import java.util.Map;

/**
 * <b>ImageAssetSet</b>
 * <p>
 * This class defines an object which can be used to generate a
 * {@link soliloquy.specs.io.graphics.renderables.ImageAssetSetRenderable} at some location in the
 * window. It is defined one or more Images, and various snippets of those Images, corresponding to
 * the type and direction requested of this ImageAssetSet. (See description of
 * {@link #getImageAssetWithDisplayParams} for more information about type and
 * direction.)
 * <p>
 * This class can be thought of as a sprite set, except it supports both static {@link Sprite}s and
 * {@link Animation}s (c.f. {@link ImageAsset}).
 *
 * @author felix.t.morgenstern
 * @version 0.0.1
 */
public interface ImageAssetSet extends Asset {
    /**
     * Intended uses of this method include retrieving ImageAssets for a
     * {@link soliloquy.specs.gamestate.entities.Character} which vary by direction, whether the
     * Character is attacking, etc.
     *
     * @param displayParams The display parameters, which determine which ImageAsset from the set to
     *                      display
     * @return The Sprite or Animation for the provided type and direction
     * @throws IllegalArgumentException If and only if displayParams is null, or does not correspond
     *                                  to an ImageAsset within this set
     */
    ImageAsset getImageAssetWithDisplayParams(Map<String, String> displayParams)
            throws IllegalArgumentException;

    /**
     * <i>NB: This method is used to ensure that
     * {@link soliloquy.specs.io.graphics.renderables.ImageAssetSetRenderable}s intended to support
     * mouse event capturing only accept ImageAssetSets which support mouse event capturing.</i>
     *
     * @return True, if and only if this ImageAssetSet supports mouse event capturing
     */
    boolean supportsMouseEventCapturing();
}
