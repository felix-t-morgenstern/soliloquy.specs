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
public interface RasterizedLineSegmentRenderable extends Renderable {
    /**
     * @return A ProviderAtTime which provides the thickness of this line segment, <i>in rasterized
     * pixels</i>, for a given timestamp. <i>It is expected that the value provided will never be
     * null.</i>
     */
    ProviderAtTime<Float> thicknessProvider();

    /**
     * @return The stippling pattern for this line segment (see documentation for more information
     * about line segment stippling)
     */
    short stipplePattern();

    /**
     * @return The stippling factor for this line segment (see documentation for more information
     * about line segment stippling)
     */
    short stippleFactor();

    /**
     * @return A ProviderAtTime which provides the color of this line segment. <i>It is expected
     * that the value provided will never be null.</i>
     */
    ProviderAtTime<Color> colorProvider();
}
