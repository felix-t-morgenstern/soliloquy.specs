package soliloquy.specs.graphics.renderables;

import soliloquy.specs.graphics.assets.Sprite;

import java.awt.*;

/**
 * <b>SpriteRenderable</b>
 * <p>
 * A Sprite which can be rendered in the window
 *
 * @author felix.t.morgenstern
 * @version 0.0.1
 *
 */
public interface SpriteRenderable extends RenderableWithArea {
    /**
     * @return The Sprite to be rendered
     */
    Sprite getSprite();

    /**
     * C.f. {@link #getSprite()} for more information
     * @param sprite The Sprite to set for this Renderable
     * @throws IllegalArgumentException If and only if sprite is null
     */
    void setSprite(Sprite sprite) throws IllegalArgumentException;
}
