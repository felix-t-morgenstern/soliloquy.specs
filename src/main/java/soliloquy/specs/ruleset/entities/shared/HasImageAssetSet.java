package soliloquy.specs.ruleset.entities.shared;

import soliloquy.specs.io.graphics.assets.ImageAssetSet;

/**
 * <b>HasImageAssetSet</b>
 * <p>
 * This class has a {@link ImageAssetSet}, which can be altered.
 *
 * @author felix.t.morgenstern
 * @version 0.0.1
 */
public interface HasImageAssetSet {
    /**
     * Intended use for this ImageAssetSet is for any icons or pictures associated with this
     * entity.
     *
     * @return The ImageAssetSet for this entity (can be null)
     */
    ImageAssetSet imageAssetSet();
}
