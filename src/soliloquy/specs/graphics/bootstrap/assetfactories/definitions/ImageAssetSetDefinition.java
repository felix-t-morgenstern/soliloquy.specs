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
 *
 */
public interface ImageAssetSetDefinition extends AssetDefinition<ImageAssetSet> {
    /**
     * @return The snippet definitions for this ImageAssetSet
     */
    List<ImageAssetSetAssetDefinition> assetDefinitions();
}
