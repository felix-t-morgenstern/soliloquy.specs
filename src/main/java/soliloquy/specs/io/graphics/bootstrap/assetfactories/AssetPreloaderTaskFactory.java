package soliloquy.specs.io.graphics.bootstrap.assetfactories;

import java.util.Collection;

/**
 * <b>AssetPreloaderTaskFactory</b>
 * <p>
 * This class takes a collection of asset definition DTOs, generates those assets, and registers
 * them with the Graphics engine (c.f. {@link soliloquy.specs.io.graphics.Graphics#getImageAssetSet})
 *
 * @param <TDefinitionDto> A DTO containing the Asset definition
 * @param <TTask> The preloading Task to perform
 * @author felix.t.morgenstern
 * @version 0.0.1
 */
public interface AssetPreloaderTaskFactory<TDefinitionDto, TTask extends Runnable>
        {
    /**
     * @param definitionDTOs A collection of definitions of the asset to be created
     * @return A task, which, when run, will generate some asset(s), and register them with the
     *         Graphics engine
     * @throws IllegalArgumentException If and only if definitionDTOs is null
     */
    TTask make(Collection<TDefinitionDto> definitionDTOs) throws IllegalArgumentException;
}
