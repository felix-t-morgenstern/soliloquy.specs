package soliloquy.specs.graphics.renderables;

import soliloquy.specs.graphics.assets.Sprite;
import soliloquy.specs.graphics.renderables.providers.ProviderAtTime;

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
     * @return A ProviderAtTime providing thickness of the border to render around this Sprite for
     * a given timestamp, expressed in percentage of the screen height. If the provider returns
     * null, this implies no border.
     */
    ProviderAtTime<Float> borderThicknessProvider();

    /**
     * @return A ProviderAtTime providing the color of the border to render around this Sprite for
     * a given timestamp. If the borderThickness ProviderAtTime returns a non-null value, this
     * ProviderAtTime must return a non-null value as well.
     */
    ProviderAtTime<Color> borderColorProvider();
}
