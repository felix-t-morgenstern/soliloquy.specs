package soliloquy.specs.io.graphics.renderables.providers.factories;

import soliloquy.specs.io.graphics.bootstrap.assetfactories.definitions.StaticMouseCursorProviderDefinition;
import soliloquy.specs.io.graphics.renderables.providers.StaticMouseCursorProvider;

public interface StaticMouseCursorProviderFactory {
    /**
     * @param definition The definition used to create the StaticMouseCursorProvider
     * @return The newly-created StaticMouseCursorProvider
     * @throws IllegalArgumentException If and only if definition is null, or if its id or relative
     *                                  locations are null or empty
     */
    StaticMouseCursorProvider make(StaticMouseCursorProviderDefinition definition)
            throws IllegalArgumentException;
}
