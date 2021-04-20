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
    Sprite sprite();

    /**
     * @return The thickness of the border to render around this Sprite, expressed in percentage of
     * the screen height
     */
    Float borderThickness();

    /**
     * @return The color of the border to render around this Sprite
     */
    Color borderColor();
}
