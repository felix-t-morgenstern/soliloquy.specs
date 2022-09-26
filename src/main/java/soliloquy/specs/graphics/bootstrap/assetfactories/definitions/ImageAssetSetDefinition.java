package soliloquy.specs.graphics.bootstrap.assetfactories.definitions;

import soliloquy.specs.graphics.assets.ImageAssetSet;

import java.util.List;

/**
 * <b>ImageAssetSetDefinition</b>
 * <p>
 * This class defines a {@link ImageAssetSet}.
 * <p>
 * It is intended for this interface to be implemented anonymously at runtime.
 *
 * @author felix.t.morgenstern
 * @version 0.0.1
 */
public class ImageAssetSetDefinition extends AssetDefinition<ImageAssetSet> {
    private final List<ImageAssetSetAssetDefinition> ASSET_DEFINITIONS;

    public ImageAssetSetDefinition(String id,
                                   List<ImageAssetSetAssetDefinition> assetDefinitions) {
        super(id);
        ASSET_DEFINITIONS = assetDefinitions;
    }

    /**
     * @return The snippet definitions for this ImageAssetSet
     */
    public List<ImageAssetSetAssetDefinition> assetDefinitions() {
        return ASSET_DEFINITIONS;
    }
}
