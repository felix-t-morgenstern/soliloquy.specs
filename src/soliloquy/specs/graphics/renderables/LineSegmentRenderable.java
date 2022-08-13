package soliloquy.specs.graphics.renderables;

import soliloquy.specs.graphics.renderables.providers.ProviderAtTime;

import java.awt.*;

/**
 * <b>LineSegmentRenderable</b>
 * <p>
 * A line segment which can be rendered in the window; used by
 * {@link RasterizedLineSegmentRenderable} and {@link AntialiasedLineSegmentRenderable}
 *
 * @author felix.t.morgenstern
 * @version 0.0.1
 */
public interface LineSegmentRenderable extends RenderableWithDimensions {
    /**
     * @return A ProviderAtTime which provides the thickness of this line segment, <i>in rasterized
     *         pixels</i>, for a given timestamp. <i>It is expected that the value provided will
     *         never be
     *         null.</i>
     */
    ProviderAtTime<Float> getThicknessProvider();

    /**
     * C.f. {@link #getThicknessProvider()} for more information
     *
     * @param thicknessProvider The ThicknessProvider to set for this Renderable
     * @throws IllegalArgumentException If and only if thicknessProvider is null
     */
    void setThicknessProvider(ProviderAtTime<Float> thicknessProvider)
            throws IllegalArgumentException;

    /**
     * @return A ProviderAtTime which provides the color of this line segment. <i>It is expected
     *         that the value provided will never be null.</i>
     */
    ProviderAtTime<Color> getColorProvider();

    /**
     * C.f. {@link #getColorProvider()} for more information
     *
     * @param colorProvider The color provider to set for this Renderable
     * @throws IllegalArgumentException If and only if colorProvider is null
     */
    void setColorProvider(ProviderAtTime<Color> colorProvider) throws IllegalArgumentException;
}
