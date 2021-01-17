package soliloquy.specs.graphics.assets;

/**
 * <b>Sprite</b>
 * <p>
 * This class defines an object which can be used to generate a
 * {@link soliloquy.specs.graphics.renderables.SpriteRenderable} at some location in the window. It
 * is defined by an Image, and a top-left and bottom-right corner specifying a snippet of that
 * Image.
 *
 * @author felix.t.morgenstern
 * @version 0.0.1
 *
 */
public interface Sprite extends AssetSnippet, AssetType {
}
