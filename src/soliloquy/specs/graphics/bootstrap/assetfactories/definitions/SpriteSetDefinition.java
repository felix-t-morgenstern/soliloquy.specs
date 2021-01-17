package soliloquy.specs.graphics.bootstrap.assetfactories.definitions;

import soliloquy.specs.graphics.assets.SpriteSet;

import java.util.List;

/**
 * <b>SpriteSetDefinition</b>
 * <p>
 * This class defines a {@link SpriteSet}.
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
