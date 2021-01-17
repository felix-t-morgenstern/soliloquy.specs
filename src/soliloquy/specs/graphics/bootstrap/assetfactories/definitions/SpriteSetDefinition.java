package soliloquy.specs.graphics.bootstrap.assetfactories.definitions;

import soliloquy.specs.graphics.assets.SpriteSet;

import java.util.List;

/**
 * <b>SpriteSetDefinition</b>
 * <p>
 * This class defines a {@link SpriteSet}.
 * <p>
 * It is intended for this interface to be implemented anonymously at runtime.
 *
 * @author felix.t.morgenstern
 * @version 0.0.1
 *
 */
public interface SpriteSetDefinition extends AssetDefinition<SpriteSet> {
    /**
     * @return The snippet definitions for this SpriteSet
     */
    List<SpriteSetSnippetDefinition> snippetDefinitions();
}
