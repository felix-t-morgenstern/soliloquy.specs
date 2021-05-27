package soliloquy.specs.graphics.renderables;

import soliloquy.specs.graphics.renderables.providers.ProviderAtTime;

import java.awt.*;

/**
 * <b>RasterizedLineSegmentRenderable</b>
 * <p>
 * A rasterized (i.e. pixelated) line segment which can be rendered in the window
 *
 * @author felix.t.morgenstern
 * @version 0.0.1
 *
 */
public interface RasterizedLineSegmentRenderable extends RenderableWithDimensions {
    /**
     * @return A ProviderAtTime which provides the thickness of this line segment, <i>in rasterized
     * pixels</i>, for a given timestamp. <i>It is expected that the value provided will never be
     * null.</i>
     */
    ProviderAtTime<Float> getThicknessProvider();

    /**
     * C.f. {@link #getThicknessProvider()} for more information
     * @param thicknessProvider The ThicknessProvider to set for this Renderable
     * @throws IllegalArgumentException If and only if thicknessProvider is null
     */
    void setThicknessProvider(ProviderAtTime<Float> thicknessProvider)
            throws IllegalArgumentException;

    /**
     * @return The stippling pattern for this line segment (see documentation for more information
     * about line segment stippling)
     */
    short getStipplePattern();

    /**
     * C.f. {@link #getStipplePattern()} for more information
     * @param stipplePattern The stipple pattern to set for this Renderable
     * @throws IllegalArgumentException If and only if stipplePattern is 0
     */
    void setStipplePattern(short stipplePattern) throws IllegalArgumentException;

    /**
     * @return The stippling factor for this line segment (see documentation for more information
     * about line segment stippling)
     */
    short getStippleFactor();

    /**
     * C.f. {@link #getStippleFactor()} for more information
     * @param stippleFactor The stipple factor to set for this Renderable
     * @throws IllegalArgumentException If and only if stippleFactor is less than 1 or greater than
     * 256
     */
    void setStippleFactor(short stippleFactor) throws IllegalArgumentException;

    /**
     * @return A ProviderAtTime which provides the color of this line segment. <i>It is expected
     * that the value provided will never be null.</i>
     */
    ProviderAtTime<Color> getColorProvider();

    /**
     * C.f. {@link #getColorProvider()} for more information
     * @param colorProvider The color provider to set for this Renderable
     * @throws IllegalArgumentException If and only if colorProvider is null
     */
    void setColorProvider(ProviderAtTime<Color> colorProvider) throws IllegalArgumentException;
}
