package soliloquy.specs.graphics.bootstrap.assetfactories.definitions;

import soliloquy.specs.common.shared.HasId;
import soliloquy.specs.graphics.assets.Asset;

/**
 * <b>AssetDefinition</b>
 * <p>
 * This class defines an asset of a specified {@link AssetType}. (This interface exists so that
 * {@link soliloquy.specs.graphics.bootstrap.assetfactories.AssetFactory}s can only be created for
 * explicitly-defined and correctly typed classes.)
 *
 * @author felix.t.morgenstern
 * @version 0.0.1
 *
 */
public interface AssetDefinition<AssetType extends Asset> extends HasId {
}
