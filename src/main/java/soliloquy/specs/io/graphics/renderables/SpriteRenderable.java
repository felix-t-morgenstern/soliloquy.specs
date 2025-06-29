package soliloquy.specs.io.graphics.renderables;

import soliloquy.specs.io.graphics.assets.Sprite;

/**
 * <b>SpriteRenderable</b>
 * <p>
 * A Sprite which can be rendered in the window
 *
 * @author felix.t.morgenstern
 * @version 0.0.1
 */
public interface SpriteRenderable extends ImageAssetRenderable {
    /**
     * @return The Sprite to be rendered
     */
    Sprite getSprite();

    /**
     * C.f. {@link #getSprite()} for more information
     *
     * @param sprite The Sprite to set for this Renderable
     * @throws IllegalArgumentException If and only if sprite is null, or if sprite does not
     *                                  support mouse events, while this Renderable does support
     *                                  mouse events
     */
    void setSprite(Sprite sprite) throws IllegalArgumentException;
}
