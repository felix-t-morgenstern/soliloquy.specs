package soliloquy.specs.graphics.bootstrap.assetfactories.definitions;

import soliloquy.specs.common.shared.SoliloquyClass;

/**
 * <b>AssetDefinition</b>
 * <p>
 * This class defines an asset of a specified {@link AssetType}.
 *
 * @author felix.t.morgenstern
 * @version 0.0.1
 *
 */
public interface AssetDefinition<AssetType> extends SoliloquyClass {
    /**
     * @return The Id of the asset being defined
     */
    String assetId();
}
