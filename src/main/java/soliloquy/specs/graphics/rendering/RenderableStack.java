package soliloquy.specs.graphics.rendering;

import soliloquy.specs.graphics.renderables.Renderable;
import soliloquy.specs.graphics.renderables.providers.ProviderAtTime;

import java.util.List;
import java.util.Map;

/**
 * <b>RenderableStack</b>
 * <p>
 * This class is a stack of {@link Renderable}s, to be rendered, in descending order of
 * z-indices.
 * <p>
 * Multiple Renderables can have the same z-index, but in this case, no promises can be made as to
 * which of those Renderables will be rendered first.
 * <p>
 * (This class is not a stack in the strict sense of the term; it can be thought of more as a Map
 * of Lists.)
 *
 * @author felix.t.morgenstern
 * @version 0.0.1
 */
public interface RenderableStack extends Renderable {
    /**
     * Clears the contained Renderables
     */
    void clearContainedRenderables();

    /**
     * <i>NB: Higher z values will be rendered first. To remove a Renderable from this class, call
     * {@link Renderable#delete()}. If Renderable is already present in the stack, this method
     * refreshes its z-index.</i>
     *
     * @param renderable The Renderable to add to the stack
     * @throws IllegalArgumentException If and only if renderable is null
     */
    void add(Renderable renderable) throws IllegalArgumentException;

    /**
     * <i>NB: This method is only intended to be called by {@link Renderable#delete()}. That is why
     * this method will fail when renderable's containingStack is non-null; it is expected that
     * renderable will update its containingStack to null before calling this method.</i>
     *
     * @param renderable The Renderable to remove from this stack
     * @throws IllegalArgumentException If and only if renderable is null, or renderable's
     *                                  containingStack is non-null.
     */
    void remove(Renderable renderable) throws IllegalArgumentException;

    /**
     * <i>NB: To be used by {@link RenderingBoundaries#currentBoundaries()}</i>
     * @return Provider for the rendering boundaries of this RenderableStack; all Renderables
     * contained within will not be drawn beyond the dimensions provided here
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
     * @return A read-only representation of the stack. (NB: While the Renderables are not clones,
     * there should also be nothing mutable about any Renderable; they are essentially
     * stateless.)
     */
    Map<Integer, List<Renderable>> renderablesByZIndexRepresentation();

    /**
     * <i>NB: Higher z values will be rendered first.</i>
     *
     * @return The z-index of this Renderable within its {@link #containingStack()}
     * @throws UnsupportedOperationException If and only if this is a top-level RenderableStack
     */
    int getZ() throws UnsupportedOperationException;
}
