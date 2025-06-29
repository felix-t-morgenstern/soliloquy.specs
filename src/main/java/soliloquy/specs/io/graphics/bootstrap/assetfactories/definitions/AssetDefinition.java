package soliloquy.specs.io.graphics.bootstrap.assetfactories.definitions;

import soliloquy.specs.common.shared.HasId;
import soliloquy.specs.io.graphics.assets.Asset;

/**
 * <b>AssetDefinition</b>
 * <p>
 * This class defines an asset of a specified {@link AssetType}. (This interface exists so that
 * {@link soliloquy.specs.io.graphics.bootstrap.assetfactories.AssetFactory}s can only be created for
 * explicitly-defined and correctly typed classes.)
 *
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
