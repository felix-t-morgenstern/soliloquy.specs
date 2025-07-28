package soliloquy.specs.ui;

import soliloquy.specs.common.valueobjects.FloatBox;
import soliloquy.specs.io.graphics.renderables.Renderable;
import soliloquy.specs.io.graphics.renderables.providers.ProviderAtTime;
import soliloquy.specs.io.graphics.rendering.RenderingBoundaries;
import soliloquy.specs.ui.keyboard.KeyBindingContext;

import java.util.Set;

/**
 * <b>Component</b>
 * <p>
 * This class is a stack of {@link Renderable}s, to be rendered, in descending order of z-indices.
 * (Multiple Renderables can have the same z-index, but in this case, no promises can be made as to
 * which of those Renderables will be rendered first.) This class can impose a boundary, outside of
 * which its contents will not render.
 *
 * @author felix.t.morgenstern
 * @version 0.0.1
 */
public interface Component extends Renderable {
    /**
     * Components alone are expected to be in control of blocking KeyBindings of "lower" components,
     * so it is expected that KeyBindingContexts will not appear in any other context
     *
     * @return The KeyBindingContext for this Component
     */
    KeyBindingContext keyBindingContext();

    /**
     * @param content The content to add to this Component
     * @throws IllegalArgumentException If and only if content is null, or already present in
     *                                  another Component, or if it is a Component whose tier (c.f.
     *                                  {@link #tier()}) is not one higher than this Component
     */
    void add(Renderable content) throws IllegalArgumentException;

    /**
     * Deletes the content upon removal
     * @param content The content to remove
     * @throws IllegalArgumentException If and only if content is null or is in another Component
     */
    void remove(Renderable content) throws IllegalArgumentException;

    /**
     * (NB: To remove contents from this Component, call {@link Renderable#delete()}
     *
     * @return A representation of the Renderables which comprise this Component
     */
    Set<Renderable> contents();

    /**
     * <i>NB: To be used by {@link RenderingBoundaries#currentBoundaries()}</i>
     *
     * @return Provider for the rendering boundaries of this RenderableStack; all Renderables
     *         contained within will not be drawn beyond the dimensions provided here
     */
    ProviderAtTime<FloatBox> getRenderingBoundariesProvider();

    /**
     * @param renderingBoundariesProvider The Provider to assign for the rendering boundaries
     * @throws IllegalArgumentException      If and only if renderingBoundariesProvider is null
     * @throws UnsupportedOperationException If and only if the RenderingStack is top-level; the
     *                                       top-level RenderingStack should always only provide the
     *                                       whole screen as rendering boundaries
     */
    void setRenderingBoundariesProvider(ProviderAtTime<FloatBox> renderingBoundariesProvider)
            throws IllegalArgumentException, UnsupportedOperationException;

    /**
     * @return The 'tier' of Component, where lower values imply a higher tier, e.g., 0 for
     *         top-level, 1 for a Component beneath top-level, etc.
     */
    int tier();
}
