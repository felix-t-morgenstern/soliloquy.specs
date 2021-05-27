package soliloquy.specs.graphics.renderables;

import soliloquy.specs.graphics.renderables.providers.ProviderAtTime;
import soliloquy.specs.graphics.rendering.FloatBox;

/**
 * <b>RenderableWithDimensions</b>
 * <p>
 * An object which can be rendered in the window, which has dimensions (i.e. which is not a
 * {@link TextLineRenderable}).
 *
 * @author felix.t.morgenstern
 * @version 0.0.1
 *
 */
public interface RenderableWithDimensions extends Renderable {
    /**
     * @return A ProviderAtTime which provides the area in the window into which to render. <i>It
     * is expected that the returned value will never be null.</i>
     */
    ProviderAtTime<FloatBox> getRenderingDimensionsProvider();

    /**
     * C.f. {@link #getRenderingDimensionsProvider()} for more information
     * @param renderingDimensionsProvider The renderingDimensionsProvider to set for this
     *                                    Renderable
     * @throws IllegalArgumentException If and only if renderingDimensionsProvider is null
     */
    void setRenderingDimensionsProvider(ProviderAtTime<FloatBox> renderingDimensionsProvider)
            throws IllegalArgumentException;
}
