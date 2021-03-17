package soliloquy.specs.graphics.bootstrap.assetfactories.definitions;

import soliloquy.specs.common.shared.SoliloquyClass;
import soliloquy.specs.graphics.assets.ImageAsset;

/**
 * <b>ImageAssetSetAssetDefinition</b>
 * <p>
 * This class defines a snippet for a {@link ImageAssetSetDefinition}.
 * <p>
 * It is intended for this interface to be implemented anonymously at runtime.
 *
 * @author felix.t.morgenstern
 * @version 0.0.1
 *
 */
public interface ImageAssetSetAssetDefinition extends SoliloquyClass {
    /**
     * @return The type of this ImageAssetSetAssetDefinition (can be null)
     */
    String type();

    /**
     * @return The direction of this ImageAssetSetAssetDefinition (can be null)
     */
    String direction();

    /**
     * @return The type of {@link ImageAsset} used for this SpriteSetAsset
     */
    ImageAsset.ImageAssetType assetType();

    /**
     * @return The Id of the {@link soliloquy.specs.graphics.assets.Sprite} or
     * {@link soliloquy.specs.graphics.assets.Animation} used for this SpriteSetAsset (c.f.
     * {@link #assetType} to know which asset type to use)
     */
    String assetId();
}
