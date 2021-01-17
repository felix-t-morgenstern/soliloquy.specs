package soliloquy.specs.graphics.bootstrap.assetfactories;

import soliloquy.specs.graphics.bootstrap.assetfactories.definitions.AssetDefinition;
import soliloquy.specs.graphics.assets.AssetType;

/**
 * <b>AssetDefinition</b>
 * <p>
 * This class takes an {@link AssetDefinition}, and produces an asset of the corresponding
 * {@link AssetType}. This class is intended to be used by the
 * {@link soliloquy.specs.graphics.bootstrap.GraphicsPreloader}, to populate
 * {@link soliloquy.specs.common.infrastructure.Registry}s of various AssetTypes, e.g.
 * {@link soliloquy.specs.graphics.Graphics#spritesRegistry}.
 *
 * @author felix.t.morgenstern
 * @version 0.0.1
 *
 */
public interface AssetFactory<TAssetDefinition extends AssetDefinition<TAssetType>,
        TAssetType extends AssetType> {
    /**
     * NB: This method is intended to populate
     * {@link soliloquy.specs.common.infrastructure.Registry}s of various AssetTypes, e.g.
     * {@link soliloquy.specs.graphics.Graphics#spritesRegistry}.
     * @param definition The definition of the asset to create
     * @return The created asset
     * @throws IllegalArgumentException If and only if definition is null, or possesses invalid
     * values
     */
    TAssetType create(TAssetDefinition definition) throws IllegalArgumentException;
}
