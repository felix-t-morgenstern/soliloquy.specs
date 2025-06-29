package soliloquy.specs.io.graphics.bootstrap.assetfactories;

import soliloquy.specs.io.graphics.assets.Asset;
import soliloquy.specs.io.graphics.bootstrap.assetfactories.definitions.AssetDefinition;

/**
 * <b>AssetDefinition</b>
 * <p>
 * This class takes an {@link AssetDefinition}, and produces an asset of the corresponding
 * {@link Asset}. This class is intended to be used by the
 * {@link soliloquy.specs.io.graphics.bootstrap.GraphicsPreloader}, to populate
 * {@link soliloquy.specs.common.infrastructure.Registry}s of various AssetTypes, e.g.
 * {@link soliloquy.specs.io.graphics.Graphics#getSprite}.
 *
 * @author felix.t.morgenstern
 * @version 0.0.1
 */
public interface AssetFactory<TAssetDefinition extends AssetDefinition<TAssetType>,
        TAssetType extends Asset> {
    /**
     * NB: This method is intended to populate the Graphics engine with various AssetTypes, e.g.
     * {@link soliloquy.specs.io.graphics.Graphics#getSprite}.
     *
     * @param definition The definition of the asset to create
     * @return The created asset
     * @throws IllegalArgumentException If and only if definition is null, or possesses invalid
     *                                  values
     */
    TAssetType make(TAssetDefinition definition) throws IllegalArgumentException;
}
