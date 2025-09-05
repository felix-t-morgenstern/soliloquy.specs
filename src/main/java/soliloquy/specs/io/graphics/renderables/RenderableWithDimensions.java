package soliloquy.specs.io.graphics.renderables;

import soliloquy.specs.common.valueobjects.FloatBox;
import soliloquy.specs.io.graphics.renderables.providers.ProviderAtTime;

/**
 * <b>RenderableWithDimensions</b>
 * <p>
 * An object which can be rendered in the window, which has dimensions (i.e. which is not a
 * {@link TextLineRenderable}).
 *
 * @author felix.t.morgenstern
 * @version 0.0.1
 */
public interface RenderableWithDimensions extends Renderable {
    /**
     * <i>NB: For {@link RenderableWithMouseEvents}, this method is used to describe the total area
     * in which mouse events for that Renderable will need to occur.</i>
     *
     * @return A ProviderAtTime which provides the area in the window into which to render. <i>It is
     *         expected that the returned value will never be null.</i>
     */
    ProviderAtTime<FloatBox> getRenderingDimensionsProvider();
}
