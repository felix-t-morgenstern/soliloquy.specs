package soliloquy.specs.graphics.renderables;

import soliloquy.specs.graphics.renderables.providers.ProviderAtTime;

import java.awt.*;

/**
 * <b>RenderableWithBorders</b>
 * <p>
 * An object which can be rendered in the window, which has borders, which have both thickness and
 * color at given times
 *
 * @author felix.t.morgenstern
 * @version 0.0.1
 */
public interface RenderableWithBorders extends Renderable {
    /**
     * @return A ProviderAtTime providing thickness of the border to render around this Renderable
     *         for a given timestamp, expressed in percentage of the screen height. If the provider
     *         returns
     *         null, this implies no border.
     */
    ProviderAtTime<Float> getBorderThicknessProvider();

    /**
     * C.f. {@link #getBorderThicknessProvider()} for more information
     *
     * @param borderThicknessProvider The border thickness provider to set for this Renderable; can
     *                                be null, in which case there is no border
     * @throws IllegalArgumentException If and only if borderThicknessProvider is non-null, and
     *                                  borderColorProvider is null
     */
    void setBorderThicknessProvider(ProviderAtTime<Float> borderThicknessProvider)
            throws IllegalArgumentException;

    /**
     * @return A ProviderAtTime providing the color of the border to render around this Renderable
     *         for a given timestamp. If the borderThickness ProviderAtTime returns a non-null
     *         value, this
     *         ProviderAtTime must return a non-null value as well.
     */
    ProviderAtTime<Color> getBorderColorProvider();

    /**
     * C.f. {@link #getBorderColorProvider()} for more information
     *
     * @param borderColorProvider The border color provider to set for this Renderable
     * @throws IllegalArgumentException If and only if borderThicknessProvider is non-null, and
     *                                  borderColorProvider is null
     */
    void setBorderColorProvider(ProviderAtTime<Color> borderColorProvider)
            throws IllegalArgumentException;
}
