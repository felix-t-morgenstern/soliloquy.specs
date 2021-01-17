package soliloquy.specs.graphics.bootstrap.assetfactories.definitions;

import soliloquy.specs.graphics.assets.AssetSnippet;
import soliloquy.specs.graphics.assets.Sprite;

/**
 * <b>SpriteDefinition</b>
 * <p>
 * This class defines a {@link Sprite}, to be created by the corresponding
 * {@link soliloquy.specs.graphics.bootstrap.assetfactories.AssetFactory}.
 * <p>
 * It is intended for this interface to be implemented anonymously at runtime.
 *
 * @author felix.t.morgenstern
 * @version 0.0.1
 *
 */
public interface SpriteDefinition extends AssetDefinition<Sprite>, AssetSnippet {
}
