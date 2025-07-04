package soliloquy.specs.io.graphics.bootstrap.assetfactories.definitions;

import soliloquy.specs.io.graphics.assets.ImageAsset;

import static soliloquy.specs.io.graphics.assets.ImageAsset.ImageAssetType;

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
    /**
     * The display parameters for this asset (cf {@link soliloquy.specs.io.graphics.assets.ImageAssetSet#getImageAssetWithDisplayParams}
     */
    public final DisplayParam[] DISPLAY_PARAMS;

    /**
     * The type of {@link ImageAsset} used for this SpriteSetAsset
     */
    public final ImageAsset.ImageAssetType ASSET_TYPE;

    /**
     * The Id of the {@link soliloquy.specs.io.graphics.assets.Sprite} or {@link soliloquy.specs.io.graphics.assets.Animation} used for this SpriteSetAsset (c.f. {@link #ASSET_TYPE} to know which asset type to use)
     */
    public final String ASSET_ID;

    public ImageAssetSetAssetDefinition(ImageAssetType assetType,
                                        String assetId,
                                        DisplayParam... displayParams) {
        ASSET_TYPE = assetType;
        ASSET_ID = assetId;
        DISPLAY_PARAMS = displayParams;
    }

    public static class DisplayParam {
        public final String NAME;
        public final String VAL;

        public DisplayParam(String name, String val) {
            NAME = name;
            VAL = val;
        }
    }
}
