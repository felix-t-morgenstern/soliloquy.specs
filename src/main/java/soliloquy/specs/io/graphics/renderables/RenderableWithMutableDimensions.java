package soliloquy.specs.io.graphics.renderables;

import soliloquy.specs.io.graphics.renderables.providers.ProviderAtTime;
import soliloquy.specs.common.valueobjects.FloatBox;

/**
 * <b>RenderableWithMutableDimensions</b>
 * <p>
 * A {@link RenderableWithDimensions} whose dimensions can be arbitrarily set, e.g. a
 * {@link RectangleRenderable}
 *
 * @author felix.t.morgenstern
 * @version 0.0.1
 */
public interface RenderableWithMutableDimensions extends RenderableWithDimensions {
    /**
     * C.f. {@link #getRenderingDimensionsProvider()} for more information
     *
     * @param renderingDimensionsProvider The renderingDimensionsProvider to set for this
     *                                    Renderable
     * @throws IllegalArgumentException If and only if renderingDimensionsProvider is null
     */
    void setRenderingDimensionsProvider(ProviderAtTime<FloatBox> renderingDimensionsProvider)
            throws IllegalArgumentException;
}
