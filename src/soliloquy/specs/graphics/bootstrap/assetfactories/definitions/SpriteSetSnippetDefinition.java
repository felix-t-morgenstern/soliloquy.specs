package soliloquy.specs.graphics.bootstrap.assetfactories.definitions;

import soliloquy.specs.graphics.assets.AssetSnippet;

/**
 * <b>SpriteSetSnippetDefinition</b>
 * <p>
 * This class defines a snippet for a {@link SpriteSetDefinition}.
 * <p>
 * It is intended for this interface to be implemented anonymously at runtime.
 *
 * @author felix.t.morgenstern
 * @version 0.0.1
 *
 */
public interface SpriteSetSnippetDefinition extends AssetSnippet {
    /**
     * @return The type of this SpriteSetSnippetDefinition (can be null)
     */
    String type();

    /**
     * @return The direction of this SpriteSetSnippetDefinition (can be null)
     */
    String direction();
}
