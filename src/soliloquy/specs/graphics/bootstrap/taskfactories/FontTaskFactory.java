package soliloquy.specs.graphics.bootstrap.taskfactories;

import soliloquy.specs.graphics.assets.Font;
import soliloquy.specs.graphics.bootstrap.assetfactories.AssetFactory;
import soliloquy.specs.graphics.bootstrap.assetfactories.definitions.FontDefinition;

import java.util.Collection;
import java.util.function.Consumer;

/**
 * <b>FontTaskFactory</b>
 * <p>
 * This class creates a Runnable which will load a Font when preloading all graphics (c.f.
 * {@link soliloquy.specs.graphics.bootstrap.GraphicsPreloader})
 *
 * @param <TDefinitionDto> The DTO defining the Font to be created
 *
 * @author felix.t.morgenstern
 * @version 0.0.1
 */
public interface FontTaskFactory<TDefinitionDto> {
    /**
     * @param fontDefinitions Definitions of the Fonts to be created
     * @param factory Creates the Font
     * @param processResult A function which processes each result as it is created
     * @return A Task, which, when run, will load some Animations
     * @throws IllegalArgumentException If and only if fontDefinitions, factory, or processResult
     * are null
     */
    Runnable make(Collection<FontDefinition> fontDefinitions,
                  AssetFactory<FontDefinition, Font> factory,
                  Consumer<Font> processResult)
            throws IllegalArgumentException;
}
