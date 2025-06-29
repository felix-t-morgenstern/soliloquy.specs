package soliloquy.specs.io.graphics.bootstrap.assetfactories.definitions;

import soliloquy.specs.io.graphics.assets.ImageAsset;

/**
 * <b>ImageAssetSetAssetDefinition</b>
 * <p>
 * This class defines a snippet for a {@link ImageAssetSetDefinition}.
 * <p>
 * It is intended for this interface to be implemented anonymously at runtime.
 *
 * @author felix.t.morgenstern
 * @version 0.0.1
 */
public class ImageAssetSetAssetDefinition {
    private final String TYPE;
    private final Integer DIRECTION;
    private final ImageAsset.ImageAssetType ASSET_TYPE;
    private final String ASSET_ID;

    public ImageAssetSetAssetDefinition(String type,
                                        Integer direction,
                                        ImageAsset.ImageAssetType assetType,
                                        String assetId) {
        TYPE = type;
        DIRECTION = direction;
        ASSET_TYPE = assetType;
        ASSET_ID = assetId;
    }

    /**
     * @return The type of this ImageAssetSetAssetDefinition (can be null)
     */
    public String type() {
        return TYPE;
    }

    /**
     * @return The direction of this ImageAssetSetAssetDefinition (can be null)
     */
    public Integer direction() {
        return DIRECTION;
    }

    /**
     * @return The type of {@link ImageAsset} used for this SpriteSetAsset
     */
    public ImageAsset.ImageAssetType assetType() {
        return ASSET_TYPE;
    }

    /**
     * @return The Id of the {@link soliloquy.specs.io.graphics.assets.Sprite} or
     *         {@link soliloquy.specs.io.graphics.assets.Animation} used for this SpriteSetAsset (c.f.
     *         {@link #assetType} to know which asset type to use)
     */
    public String assetId() {
        return ASSET_ID;
    }
}
