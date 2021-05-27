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
    Sprite getSprite();

    /**
     * C.f. {@link #getSprite()} for more information
     * @param sprite The Sprite to set for this Renderable
     * @throws IllegalArgumentException If and only if sprite is null
     */
    void setSprite(Sprite sprite) throws IllegalArgumentException;

    /**
     * @return A ProviderAtTime providing thickness of the border to render around this Sprite for
     * a given timestamp, expressed in percentage of the screen height. If the provider returns
     * null, this implies no border.
     */
    ProviderAtTime<Float> getBorderThicknessProvider();

    /**
     * C.f. {@link #getBorderThicknessProvider()} for more information
     * @param borderThicknessProvider The border thickness provider to set for this Renderable
     * @throws IllegalArgumentException If and only if borderThicknessProvider is null
     */
    void setBorderThicknessProvider(ProviderAtTime<Float> borderThicknessProvider)
            throws IllegalArgumentException;

    /**
     * @return A ProviderAtTime providing the color of the border to render around this Sprite for
     * a given timestamp. If the borderThickness ProviderAtTime returns a non-null value, this
     * ProviderAtTime must return a non-null value as well.
     */
    ProviderAtTime<Color> getBorderColorProvider();

    /**
     * C.f. {@link #getBorderColorProvider()} for more information
     * @param borderColorProvider The border color provider to set for this Renderable
     * @throws IllegalArgumentException If and only if borderColorProvider is null
     */
    void setBorderColorProvider(ProviderAtTime<Color> borderColorProvider)
            throws IllegalArgumentException;
}
