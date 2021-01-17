package soliloquy.specs.graphics.renderables;

import soliloquy.specs.graphics.assets.Sprite;

/**
 * <b>SpriteRenderable</b>
 * <p>
 * A Sprite which can be rendered in the window
 *
 * @author felix.t.morgenstern
 * @version 0.0.1
 *
 */
public interface SpriteRenderable extends RenderableType {
    /**
     * @return The Sprite to be rendered
     */
    Sprite sprite();
}
