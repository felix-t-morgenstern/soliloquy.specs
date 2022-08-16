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
public interface LineSegmentRenderable extends RenderableWithColorAndThickness, RenderableWithDimensions {
    /**
     * @return A ProviderAtTime which provides the thickness of this line segment, <i>in rasterized
     *         pixels</i>, for a given timestamp. <i>It is expected that the value provided will
     *         never be null.</i>
     */
    ProviderAtTime<Float> getThicknessProvider();
}
