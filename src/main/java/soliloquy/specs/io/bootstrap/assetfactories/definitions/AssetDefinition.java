package soliloquy.specs.io.bootstrap.assetfactories.definitions;

import soliloquy.specs.common.shared.HasId;
import soliloquy.specs.io.graphics.assets.Asset;

/**
 * <b>AssetDefinition</b>
 * <p>
 * This class defines an asset of a specified {@link AssetType}.
 *
 * @param <AssetType> The type of {@link Asset} defined
 * @author felix.t.morgenstern
 * @version 0.0.1
 */
public abstract class AssetDefinition<AssetType extends Asset> implements HasId {
    private final String ID;

    public AssetDefinition(String id) {
        ID = id;
    }

    @Override
    public String id() throws IllegalStateException {
        return ID;
    }
}
